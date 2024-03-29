/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import SwingTools.SwingTools;
import controller.Manager;
import exceptions.InputOutputException;
import exceptions.ManagerException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuli
 */
public class NewScore extends javax.swing.JDialog {

    /**
     * Creates new form NewScore
     *
     * @param parent
     * @param modal
     */
    public NewScore(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SwingTools.getSwingTools().setIcon(this, null);
        SwingTools.getSwingTools().generateSelect(genreScore, "genre");
        SwingTools.getSwingTools().generateSelect(instrument, "instrument");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        difficultyLevel = new javax.swing.ButtonGroup();
        labelForCode = new javax.swing.JLabel();
        labelForTitle = new javax.swing.JLabel();
        labelForArtist = new javax.swing.JLabel();
        labelForInstrument = new javax.swing.JLabel();
        labelForDifficultyLevel = new javax.swing.JLabel();
        labelForPrinted = new javax.swing.JLabel();
        addNewScore = new javax.swing.JButton();
        codeScore = new javax.swing.JTextField();
        titleScore = new javax.swing.JTextField();
        artistScore = new javax.swing.JTextField();
        instrument = new javax.swing.JComboBox<>();
        isPrinted = new javax.swing.JCheckBox();
        low = new javax.swing.JRadioButton();
        medium = new javax.swing.JRadioButton();
        high = new javax.swing.JRadioButton();
        labelForGender = new javax.swing.JLabel();
        genreScore = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Score");

        labelForCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelForCode.setLabelFor(labelForCode);
        labelForCode.setText("Code of score");

        labelForTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelForTitle.setLabelFor(labelForTitle);
        labelForTitle.setText("Title");

        labelForArtist.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelForArtist.setLabelFor(labelForArtist);
        labelForArtist.setText("Artist");

        labelForInstrument.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelForInstrument.setLabelFor(labelForInstrument);
        labelForInstrument.setText("Instrument");

        labelForDifficultyLevel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelForDifficultyLevel.setLabelFor(labelForDifficultyLevel);
        labelForDifficultyLevel.setText("Difficulty Level");

        labelForPrinted.setLabelFor(labelForPrinted);
        labelForPrinted.setText("Printed");

        addNewScore.setText("Add new score");
        addNewScore.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        addNewScore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewScoreActionPerformed(evt);
            }
        });

        difficultyLevel.add(low);
        low.setText("Low");

        difficultyLevel.add(medium);
        medium.setText("Medium");

        difficultyLevel.add(high);
        high.setSelected(true);
        high.setText("high");

        labelForGender.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelForGender.setText("Gender");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelForDifficultyLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(labelForInstrument, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelForArtist, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelForTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelForCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelForGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addNewScore, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelForPrinted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(low, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(medium)
                                .addGap(49, 49, 49)
                                .addComponent(high))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isPrinted, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genreScore, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(codeScore, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                                .addComponent(titleScore)
                                .addComponent(artistScore))
                            .addComponent(instrument, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForCode, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeScore, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleScore, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artistScore, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(genreScore, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(labelForGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instrument, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForDifficultyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(low)
                    .addComponent(medium)
                    .addComponent(high))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelForPrinted, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isPrinted))
                .addGap(35, 35, 35)
                .addComponent(addNewScore, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Call a method to create a new score
     *
     * @param evt
     */
    private void addNewScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewScoreActionPerformed
        String code = codeScore.getText();
        String title = titleScore.getText();
        String artist = artistScore.getText();
        String gender = genreScore.getSelectedItem().toString();
        String instrumentScore = this.instrument.getSelectedItem().toString();
        String difficultyLevelScore = SwingTools.getSwingTools().getSelectedButtonText(difficultyLevel);
        boolean isPrintedScore = this.isPrinted.isSelected();
        if (code.equalsIgnoreCase("") || title.equalsIgnoreCase("") || artist.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "You have not filled in all the fields", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                if (Manager.getManager().addNewScore(code, title, artist, instrumentScore, gender, difficultyLevelScore, isPrintedScore)) {
                    JOptionPane.showMessageDialog(this, "Score added successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                    codeScore.setText("");
                    titleScore.setText("");
                    artistScore.setText("");
                    genreScore.setSelectedIndex(0);
                    instrument.setSelectedIndex(0);
                    difficultyLevel.setSelected(low.getModel(), true);
                    isPrinted.setSelected(false);
                } else {
                    throw new ManagerException(ManagerException.SCORE_EXIST);
                }
            } catch (ManagerException ex) {
                JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
            } catch (InputOutputException ex) {
                JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_addNewScoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewScore;
    private javax.swing.JTextField artistScore;
    private javax.swing.JTextField codeScore;
    private javax.swing.ButtonGroup difficultyLevel;
    private javax.swing.JComboBox<String> genreScore;
    private javax.swing.JRadioButton high;
    private javax.swing.JComboBox<String> instrument;
    private javax.swing.JCheckBox isPrinted;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelForArtist;
    private javax.swing.JLabel labelForCode;
    private javax.swing.JLabel labelForDifficultyLevel;
    private javax.swing.JLabel labelForGender;
    private javax.swing.JLabel labelForInstrument;
    private javax.swing.JLabel labelForPrinted;
    private javax.swing.JLabel labelForTitle;
    private javax.swing.JRadioButton low;
    private javax.swing.JRadioButton medium;
    private javax.swing.JTextField titleScore;
    // End of variables declaration//GEN-END:variables
}
