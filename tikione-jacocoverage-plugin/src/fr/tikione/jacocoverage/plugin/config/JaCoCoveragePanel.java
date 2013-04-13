package fr.tikione.jacocoverage.plugin.config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;

// TODO add input verifiers (int, 0-255) on text-fields
final class JaCoCoveragePanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    private static final String DEF_COVERED_R = "205";

    private static final String DEF_COVERED_G = "235";

    private static final String DEF_COVERED_B = "175";

    private static final String DEF_PARTIAL_COVERED_R = "255";

    private static final String DEF_PARTIAL_COVERED_G = "231";

    private static final String DEF_PARTIAL_COVERED_B = "157";

    private static final String DEF_NOT_COVERED_R = "252";

    private static final String DEF_NOT_COVERED_G = "201";

    private static final String DEF_NOT_COVERED_B = "194";

    private final JaCoCoverageOptionsPanelController controller;

    JaCoCoveragePanel(JaCoCoverageOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
    }

    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHighlightingCoveredCode = new JPanel();
        jLabelCoveredCodeBG = new JLabel();
        jLabelPartiallyCoveredCodeBG = new JLabel();
        jLabelNotCoveredCodeBG = new JLabel();
        jTextFieldCoveredR = new JTextField();
        jTextFieldCoveredG = new JTextField();
        jTextFieldCoveredB = new JTextField();
        jTextFieldPartiallyCoveredR = new JTextField();
        jTextFieldPartiallyCoveredG = new JTextField();
        jTextFieldPartiallyCoveredB = new JTextField();
        jTextFieldNotCoveredR = new JTextField();
        jTextFieldNotCoveredG = new JTextField();
        jTextFieldNotCoveredB = new JTextField();
        jPanelNotCoveredPreview = new JPanel();
        jPanelPartiallyCoveredPreview = new JPanel();
        jPanelCoveredPreview = new JPanel();
        jLabelInfoColorsAreRGB = new JLabel();
        jButtonResoreDefaults = new JButton();

        jPanelHighlightingCoveredCode.setBorder(BorderFactory.createTitledBorder(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jPanelHighlightingCoveredCode.border.title"))); // NOI18N

        Mnemonics.setLocalizedText(jLabelCoveredCodeBG, NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jLabelCoveredCodeBG.text")); // NOI18N

        Mnemonics.setLocalizedText(jLabelPartiallyCoveredCodeBG, NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jLabelPartiallyCoveredCodeBG.text")); // NOI18N

        Mnemonics.setLocalizedText(jLabelNotCoveredCodeBG, NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jLabelNotCoveredCodeBG.text")); // NOI18N

        jTextFieldCoveredR.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldCoveredR.text")); // NOI18N

        jTextFieldCoveredG.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldCoveredG.text")); // NOI18N

        jTextFieldCoveredB.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldCoveredB.text")); // NOI18N

        jTextFieldPartiallyCoveredR.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldPartiallyCoveredR.text")); // NOI18N

        jTextFieldPartiallyCoveredG.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldPartiallyCoveredG.text")); // NOI18N

        jTextFieldPartiallyCoveredB.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldPartiallyCoveredB.text")); // NOI18N

        jTextFieldNotCoveredR.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldNotCoveredR.text")); // NOI18N

        jTextFieldNotCoveredG.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldNotCoveredG.text")); // NOI18N

        jTextFieldNotCoveredB.setText(NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jTextFieldNotCoveredB.text")); // NOI18N

        jPanelNotCoveredPreview.setBackground(new Color(255, 255, 255));
        jPanelNotCoveredPreview.setMaximumSize(new Dimension(16, 16));
        jPanelNotCoveredPreview.setMinimumSize(new Dimension(16, 16));
        jPanelNotCoveredPreview.setName(""); // NOI18N

        GroupLayout jPanelNotCoveredPreviewLayout = new GroupLayout(jPanelNotCoveredPreview);
        jPanelNotCoveredPreview.setLayout(jPanelNotCoveredPreviewLayout);
        jPanelNotCoveredPreviewLayout.setHorizontalGroup(
            jPanelNotCoveredPreviewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanelNotCoveredPreviewLayout.setVerticalGroup(
            jPanelNotCoveredPreviewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanelPartiallyCoveredPreview.setBackground(new Color(255, 255, 255));
        jPanelPartiallyCoveredPreview.setMaximumSize(new Dimension(16, 16));
        jPanelPartiallyCoveredPreview.setMinimumSize(new Dimension(16, 16));
        jPanelPartiallyCoveredPreview.setName(""); // NOI18N

        GroupLayout jPanelPartiallyCoveredPreviewLayout = new GroupLayout(jPanelPartiallyCoveredPreview);
        jPanelPartiallyCoveredPreview.setLayout(jPanelPartiallyCoveredPreviewLayout);
        jPanelPartiallyCoveredPreviewLayout.setHorizontalGroup(
            jPanelPartiallyCoveredPreviewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanelPartiallyCoveredPreviewLayout.setVerticalGroup(
            jPanelPartiallyCoveredPreviewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanelCoveredPreview.setBackground(new Color(255, 255, 255));
        jPanelCoveredPreview.setMaximumSize(new Dimension(16, 16));
        jPanelCoveredPreview.setMinimumSize(new Dimension(16, 16));
        jPanelCoveredPreview.setName(""); // NOI18N

        GroupLayout jPanelCoveredPreviewLayout = new GroupLayout(jPanelCoveredPreview);
        jPanelCoveredPreview.setLayout(jPanelCoveredPreviewLayout);
        jPanelCoveredPreviewLayout.setHorizontalGroup(
            jPanelCoveredPreviewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanelCoveredPreviewLayout.setVerticalGroup(
            jPanelCoveredPreviewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jLabelInfoColorsAreRGB.setFont(new Font("Tahoma", 2, 11)); // NOI18N
        Mnemonics.setLocalizedText(jLabelInfoColorsAreRGB, NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jLabelInfoColorsAreRGB.text")); // NOI18N

        GroupLayout jPanelHighlightingCoveredCodeLayout = new GroupLayout(jPanelHighlightingCoveredCode);
        jPanelHighlightingCoveredCode.setLayout(jPanelHighlightingCoveredCodeLayout);
        jPanelHighlightingCoveredCodeLayout.setHorizontalGroup(
            jPanelHighlightingCoveredCodeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHighlightingCoveredCodeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHighlightingCoveredCodeLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelHighlightingCoveredCodeLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelPartiallyCoveredCodeBG)
                        .addComponent(jLabelNotCoveredCodeBG))
                    .addComponent(jLabelCoveredCodeBG, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHighlightingCoveredCodeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHighlightingCoveredCodeLayout.createSequentialGroup()
                        .addComponent(jTextFieldCoveredR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCoveredG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCoveredB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCoveredPreview, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelHighlightingCoveredCodeLayout.createSequentialGroup()
                        .addComponent(jTextFieldPartiallyCoveredR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPartiallyCoveredG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPartiallyCoveredB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelPartiallyCoveredPreview, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelHighlightingCoveredCodeLayout.createSequentialGroup()
                        .addComponent(jTextFieldNotCoveredR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNotCoveredG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNotCoveredB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelNotCoveredPreview, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelHighlightingCoveredCodeLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabelInfoColorsAreRGB)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanelHighlightingCoveredCodeLayout.setVerticalGroup(
            jPanelHighlightingCoveredCodeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHighlightingCoveredCodeLayout.createSequentialGroup()
                .addComponent(jLabelInfoColorsAreRGB)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHighlightingCoveredCodeLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelCoveredCodeBG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoveredR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoveredG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoveredB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCoveredPreview, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHighlightingCoveredCodeLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelPartiallyCoveredCodeBG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPartiallyCoveredR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPartiallyCoveredG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPartiallyCoveredB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPartiallyCoveredPreview, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHighlightingCoveredCodeLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelNotCoveredCodeBG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNotCoveredR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNotCoveredG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNotCoveredB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelNotCoveredPreview, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        Mnemonics.setLocalizedText(jButtonResoreDefaults, NbBundle.getMessage(JaCoCoveragePanel.class, "JaCoCoveragePanel.jButtonResoreDefaults.text")); // NOI18N
        jButtonResoreDefaults.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonResoreDefaultsActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonResoreDefaults))
            .addComponent(jPanelHighlightingCoveredCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHighlightingCoveredCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButtonResoreDefaults))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResoreDefaultsActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonResoreDefaultsActionPerformed
        jTextFieldCoveredR.setText(DEF_COVERED_R);
        jTextFieldCoveredG.setText(DEF_COVERED_G);
        jTextFieldCoveredB.setText(DEF_COVERED_B);
        jTextFieldPartiallyCoveredR.setText(DEF_PARTIAL_COVERED_R);
        jTextFieldPartiallyCoveredG.setText(DEF_PARTIAL_COVERED_G);
        jTextFieldPartiallyCoveredB.setText(DEF_PARTIAL_COVERED_B);
        jTextFieldNotCoveredR.setText(DEF_NOT_COVERED_R);
        jTextFieldNotCoveredG.setText(DEF_NOT_COVERED_G);
        jTextFieldNotCoveredB.setText(DEF_NOT_COVERED_B);
    }//GEN-LAST:event_jButtonResoreDefaultsActionPerformed

    void load() {
        Preferences pref = NbPreferences.forModule(JaCoCoveragePanel.class);
        String coveredR = pref.get("JaCoCoverage.CoveredR", DEF_COVERED_R);
        String coveredG = pref.get("JaCoCoverage.CoveredG", DEF_COVERED_G);
        String coveredB = pref.get("JaCoCoverage.CoveredB", DEF_COVERED_B);
        String parCoveredR = pref.get("JaCoCoverage.PartiallyCoveredR", DEF_PARTIAL_COVERED_R);
        String parCoveredG = pref.get("JaCoCoverage.PartiallyCoveredG", DEF_PARTIAL_COVERED_G);
        String parCoveredB = pref.get("JaCoCoverage.PartiallyCoveredB", DEF_PARTIAL_COVERED_B);
        String notCoveredR = pref.get("JaCoCoverage.NotCoveredR", DEF_NOT_COVERED_R);
        String notCoveredG = pref.get("JaCoCoverage.NotCoveredG", DEF_NOT_COVERED_G);
        String notCoveredB = pref.get("JaCoCoverage.NotCoveredB", DEF_NOT_COVERED_B);
        jTextFieldCoveredR.setText(coveredR);
        jTextFieldCoveredG.setText(coveredG);
        jTextFieldCoveredB.setText(coveredB);
        jTextFieldPartiallyCoveredR.setText(parCoveredR);
        jTextFieldPartiallyCoveredG.setText(parCoveredG);
        jTextFieldPartiallyCoveredB.setText(parCoveredB);
        jTextFieldNotCoveredR.setText(notCoveredR);
        jTextFieldNotCoveredG.setText(notCoveredG);
        jTextFieldNotCoveredB.setText(notCoveredB);
        jPanelCoveredPreview.setBackground(new Color(
                Integer.parseInt(coveredR),
                Integer.parseInt(coveredG),
                Integer.parseInt(coveredB)));
        jPanelPartiallyCoveredPreview.setBackground(new Color(
                Integer.parseInt(parCoveredR),
                Integer.parseInt(parCoveredG),
                Integer.parseInt(parCoveredB)));
        jPanelNotCoveredPreview.setBackground(new Color(
                Integer.parseInt(notCoveredR),
                Integer.parseInt(notCoveredG),
                Integer.parseInt(notCoveredB)));
    }

    void store() {
        Preferences pref = NbPreferences.forModule(JaCoCoveragePanel.class);
        pref.put("JaCoCoverage.CoveredR", jTextFieldCoveredR.getText());
        pref.put("JaCoCoverage.CoveredG", jTextFieldCoveredG.getText());
        pref.put("JaCoCoverage.CoveredB", jTextFieldCoveredB.getText());
        pref.put("JaCoCoverage.PartiallyCoveredR", jTextFieldPartiallyCoveredR.getText());
        pref.put("JaCoCoverage.PartiallyCoveredG", jTextFieldPartiallyCoveredG.getText());
        pref.put("JaCoCoverage.PartiallyCoveredB", jTextFieldPartiallyCoveredB.getText());
        pref.put("JaCoCoverage.NotCoveredR", jTextFieldNotCoveredR.getText());
        pref.put("JaCoCoverage.NotCoveredG", jTextFieldNotCoveredG.getText());
        pref.put("JaCoCoverage.NotCoveredB", jTextFieldNotCoveredB.getText());
    }

    boolean valid() {
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButtonResoreDefaults;
    private JLabel jLabelCoveredCodeBG;
    private JLabel jLabelInfoColorsAreRGB;
    private JLabel jLabelNotCoveredCodeBG;
    private JLabel jLabelPartiallyCoveredCodeBG;
    private JPanel jPanelCoveredPreview;
    private JPanel jPanelHighlightingCoveredCode;
    private JPanel jPanelNotCoveredPreview;
    private JPanel jPanelPartiallyCoveredPreview;
    private JTextField jTextFieldCoveredB;
    private JTextField jTextFieldCoveredG;
    private JTextField jTextFieldCoveredR;
    private JTextField jTextFieldNotCoveredB;
    private JTextField jTextFieldNotCoveredG;
    private JTextField jTextFieldNotCoveredR;
    private JTextField jTextFieldPartiallyCoveredB;
    private JTextField jTextFieldPartiallyCoveredG;
    private JTextField jTextFieldPartiallyCoveredR;
    // End of variables declaration//GEN-END:variables
}
