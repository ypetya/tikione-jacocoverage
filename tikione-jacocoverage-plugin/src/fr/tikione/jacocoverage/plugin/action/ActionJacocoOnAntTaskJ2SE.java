package fr.tikione.jacocoverage.plugin.action;

import fr.tikione.jacocoexec.analyzer.JaCoCoReportAnalyzer;
import fr.tikione.jacocoexec.analyzer.JaCoCoXmlReportParser;
import fr.tikione.jacocoexec.analyzer.JavaClass;
import fr.tikione.jacocoverage.plugin.anno.AbstractCoverageAnnotation;
import fr.tikione.jacocoverage.plugin.config.Globals;
import fr.tikione.jacocoverage.plugin.config.ProjectConfig;
import fr.tikione.jacocoverage.plugin.util.NBUtils;
import fr.tikione.jacocoverage.plugin.util.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.tools.ant.module.api.AntProjectCookie;
import org.apache.tools.ant.module.api.AntTargetExecutor;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.netbeans.api.project.Project;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.HtmlBrowser;
import org.openide.execution.ExecutorTask;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.util.RequestProcessor;
import org.openide.util.Utilities;
import org.xml.sax.SAXException;

/**
 * A toolkit that launches Ant tasks with the JaCoCo JavaAgent, colorizes Java source files and shows a coverage report.
 * <br/>See <a href="http://wiki.netbeans.org/DevFaqRequestProcessor">DevFaqRequestProcessor</a> for NetBeans threading tweaks.
 * <br/>See <a href="http://wiki.netbeans.org/DevFaqActionContextSensitive">DevFaqActionContextSensitive</a> for context action tweaks.
 * <br/>See <a href="http://wiki.netbeans.org/DevFaqAddGlobalContext">DevFaqAddGlobalContext</a> for global context and project tweaks.
 *
 * @author Jonathan Lermitage
 */
@SuppressWarnings("CloneableImplementsClone")
public abstract class ActionJacocoOnAntTaskJ2SE
        extends AbstractAction
        implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(ActionJacocoOnAntTaskJ2SE.class.getName());

    /** The Ant task to launch. */
    private final String antTask;

    /** Additional properties passed to the Ant task. */
    private final Properties addAntTargetProps = new Properties();

    /**
     * Enable the context action on supported projects only.
     *
     * @param antTask additional properties passed to the Ant task.
     */
    public ActionJacocoOnAntTaskJ2SE(String antTask) {
        this.antTask = antTask;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        new RequestProcessor("JaCoCoverage Preparation Task", 3, true).post(new Runnable() {
            @Override
            public void run() {
                try {
                    runJacocoJavaagent(NBUtils.getSelectedProject());
                } catch (IllegalArgumentException | IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        });
    }

    /**
     * Run an Ant task with a JaCoCo Java Agent, collect and display coverage data.
     *
     * @param project the project to launch Ant target from.
     * @throws IOException if an I/O error occurs.
     */
    private void runJacocoJavaagent(final Project project)
            throws IOException {
        // Retrieve JaCoCoverage preferences.
        final ProjectConfig cfg = ProjectConfig.forFile(new File(NBUtils.getProjectDir(project), Globals.PRJ_CFG));
        final boolean enblHighlight = cfg.isEnblHighlighting();
        final boolean enblConsoleReport = cfg.isEnblConsoleReport();
        final boolean enblHtmlReport = cfg.isEnblHtmlReport();
        final boolean openHtmlReport = cfg.isOpenHtmlReport();

        if (enblHighlight || enblConsoleReport || enblHtmlReport) {
            // Retrieve project properties.
            final String prjDir = NBUtils.getProjectDir(project) + File.separator;
            FileObject prjPropsFo = project.getProjectDirectory().getFileObject("nbproject/project.properties");
            final Properties prjProps = new Properties();
            try (InputStream insPrjProps = prjPropsFo.getInputStream()) {
                prjProps.load(insPrjProps);
            }

            final File xmlreport = Utils.getJacocoXmlReportfile(project);
            final File binreport = Utils.getJacocoBinReportFile(project);
            if (binreport.exists() && !binreport.delete() || xmlreport.exists() && !xmlreport.delete()) {
                String msg = "Cannot delete the previous JaCoCo report files, please delete them manually:\n"
                        + binreport.getAbsolutePath() + " and/or\n"
                        + xmlreport.getAbsolutePath();
                NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.ERROR_MESSAGE);
                DialogDisplayer.getDefault().notify(nd);
            } else {
                // Apply JaCoCo JavaAgent customization.
                final String antTaskJavaagentParam;
                List<String> excludeList = cfg.getPkgclssExclude();
                StringBuilder exclude = new StringBuilder((excludeList.size() + 1) * 20);
                if (cfg.isOverrideGlobals() && !excludeList.isEmpty()) {
                    exclude.append(",excludes=");
                    boolean first = true;
                    for (String pkg : excludeList) {
                        if (!first) {
                            exclude.append(':');
                        }
                        exclude.append(pkg).append(".*");
                        first = false;
                    }
                }
                antTaskJavaagentParam = "\"" + NBUtils.getJacocoAgentJar().getAbsolutePath()
                        + "\"=includes=*:" + NBUtils.getProjectJavaPackagesAsStr(project, prjProps, ":", ".*")
                        + ",destfile=\"" + binreport.getAbsolutePath() + "\"" + exclude.toString();

                FileObject scriptToExecute = project.getProjectDirectory().getFileObject("build", "xml");
                if (scriptToExecute == null) { // Fix for GitHub #16.
                    scriptToExecute = project.getProjectDirectory().getFileObject("nbbuild", "xml");
                }
                DataObject dataObj = DataObject.find(scriptToExecute);
                AntProjectCookie antCookie = dataObj.getLookup().lookup(AntProjectCookie.class);

                AntTargetExecutor.Env env = new AntTargetExecutor.Env();
                AntTargetExecutor executor = AntTargetExecutor.createTargetExecutor(env);

                // Add the customized JaCoCo JavaAgent to the JVM arguments given to the Ant task. The JaCoCo JavaAgent is
                // appended to the existing list of JVM arguments that is given to the Ant task.
                Properties targetProps = env.getProperties();
                targetProps.putAll(addAntTargetProps);
                String prjJvmArgs = Utils.getProperty(prjProps, "run.jvmargs");
                targetProps.put("run.jvmargs", prjJvmArgs + "  -javaagent:" + antTaskJavaagentParam);
                env.setProperties(targetProps);

                // Launch the Ant task with the JaCoCo JavaAgent.
                final ExecutorTask execute = executor.execute(antCookie, new String[]{antTask});

                new RequestProcessor("JaCoCoverage Collection Task", 3, true).post(new Runnable() {
                    @Override
                    public void run() {
                        ProgressHandle progr = ProgressHandleFactory.createHandle("JaCoCoverage Collection Task");
                        try {
                            progr.setInitialDelay(400);
                            progr.start();
                            progr.switchToIndeterminate();

                            // Wait for the end of the Ant task execution. We do it in a new thread otherwise it would
                            // freeze the current one. This is a workaround for a known and old NetBeans bug: the ExecutorTask
                            // object provided by the NetBeans platform is not correctly wrapped.
                            int executeRes = execute.result();
                            if (/*0 == executeRes && */binreport.exists()) {
                                long st = System.currentTimeMillis();
                                // Load the generated JaCoCo coverage report.
                                File classDir = new File(prjDir + Utils.getProperty(prjProps, "build.classes.dir") + File.separator);
                                File srcDir = new File(prjDir + Utils.getProperty(prjProps, "src.dir") + File.separator);
                                JaCoCoReportAnalyzer.toXmlReport(binreport, xmlreport, classDir, srcDir);
                                final Map<String, JavaClass> coverageData = JaCoCoXmlReportParser.getCoverageData(xmlreport);
                                new File(prjDir + Globals.JACOCOVERAGE_DATA_DIR).mkdirs();

                                // Remove existing highlighting (from a previous coverage task), show reports and apply
                                // highlighting on each Java source file.
                                AbstractCoverageAnnotation.removeAll(NBUtils.getProjectId(project));
                                String prjname = NBUtils.getProjectName(project);
                                if (enblConsoleReport) {
                                    JaCoCoReportAnalyzer.toConsoleReport(coverageData, prjname + Globals.TXTREPORT_TABNAME);
                                }
                                File reportdir = new File(prjDir + Globals.HTML_REPORT_DIR);
                                if (reportdir.exists()) {
                                    org.apache.commons.io.FileUtils.deleteDirectory(reportdir);
                                }
                                if (enblHtmlReport) {
                                    reportdir.mkdirs();
                                    String report = JaCoCoReportAnalyzer.toHtmlReport(binreport, reportdir, classDir, srcDir, prjname);
                                    if (openHtmlReport) {
                                        try {
                                            HtmlBrowser.URLDisplayer.getDefault().showURL(Utilities.toURI(new File(report)).toURL());
                                        } catch (MalformedURLException ex) {
                                            Exceptions.printStackTrace(ex);
                                        }
                                    }
                                }
                                if (enblHighlight) {
                                    for (final JavaClass jclass : coverageData.values()) {
                                        NBUtils.colorDoc(project, jclass, cfg.isEnblHighlightingExtended(), srcDir);
                                    }
                                }
                                keepJaCoCoWorkfiles(binreport, xmlreport, prjDir, cfg.getJaCoCoWorkfilesRule());

                                long et = System.currentTimeMillis();
                                LOGGER.log(Level.INFO, "Coverage Collection Task took: {0} ms", et - st);
                            } else {
                                AbstractCoverageAnnotation.removeAll(NBUtils.getProjectId(project));
                                NBUtils.closeConsoleTab(Globals.TXTREPORT_TABNAME);
                                String msg = "Ant Task or JaCoCo Agent failed, JaCoCoverage can't process data.\n"
                                        + "(AntExitCode=" + executeRes + ", JacocoBinReportFound=" + binreport.exists() + ")";
                                NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.WARNING_MESSAGE);
                                DialogDisplayer.getDefault().notify(nd);
                            }
                        } catch (FileNotFoundException ex) {
                            Exceptions.printStackTrace(ex);
                        } catch (IOException ex) {
                            Exceptions.printStackTrace(ex);
                        } catch (ParserConfigurationException | SAXException ex) {
                            Exceptions.printStackTrace(ex);
                        } finally {
                            progr.finish();
                        }
                    }
                });
            }
        } else {
            String msg = "Please enable at least one JaCoCoverage feature first (highlighting or reporting).";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.ERROR_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
        }
    }

    /**
     * Apply retention policy on JaCoCo workfiles.
     * 
     * @param binreport JaCoCo binary report file.
     * @param xmlreport JaCoCo XML report file.
     * @param prjDir project directory.
     * @param wfrule retention policy.
     * @throws IOException if workfiles can't be removed or moved.
     */
    private void keepJaCoCoWorkfiles(File binreport, File xmlreport, String prjDir, int wfrule)
            throws IOException {
        File xmlreportCpy = new File(prjDir + Globals.XML_BACKUP_REPORT);
        File xmlreportZip = new File(prjDir + Globals.XMLZIP_BACKUP_REPORT);
        File binreportCpy = new File(prjDir + Globals.BIN_BACKUP_REPORT);
        File binreportZip = new File(prjDir + Globals.BINZIP_BACKUP_REPORT);
        xmlreportCpy.delete();
        xmlreportZip.delete();
        binreportCpy.delete();
        binreportZip.delete();
        switch (wfrule) {
            case 0:
                org.apache.commons.io.FileUtils.moveFile(binreport, binreportCpy);
                org.apache.commons.io.FileUtils.moveFile(xmlreport, xmlreportCpy);
                break;
            case 1:
                Utils.zip(binreport, binreportZip, Globals.BINZIP_BACKUP_REPORT_ENTRY, false);
                Utils.zip(xmlreport, xmlreportZip, Globals.XMLZIP_BACKUP_REPORT_ENTRY, false);
                break;
            case 2:
                break;
        }
        binreport.delete();
        xmlreport.delete();
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public Properties getAddAntTargetProps() {
        return addAntTargetProps;
    }
}
