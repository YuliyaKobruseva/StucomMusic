/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import SwingTools.SwingTools;
import controller.Manager;
import exceptions.ManagerException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.score.Score;

/**
 *
 * @author Yuli
 */
public class InformationScores extends javax.swing.JDialog {

    int counter = 0;
    ArrayList scores;

    /**
     * Creates new form InformationScores
     */
    public InformationScores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SwingTools.getSwingTools().setIcon(this, null);
        SwingTools.getSwingTools().generateSelect(instrumentSelected, "instrument");
        SwingTools.getSwingTools().generateSelect(difficultyLevel, "level");
        instrumentSelected.setSelectedIndex(-1);
        difficultyLevel.setSelectedIndex(-1);
        panelInformation.setVisible(false);
        setSize(950, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelScoresInformation = new javax.swing.JLabel();
        instrumentSelected = new javax.swing.JComboBox<>();
        difficultyLevel = new javax.swing.JComboBox<>();
        show = new javax.swing.JButton();
        labelInstrumen = new javax.swing.JLabel();
        labelLevel = new javax.swing.JLabel();
        panelInformation = new javax.swing.JPanel();
        code = new javax.swing.JTextField();
        title = new javax.swing.JTextField();
        artist = new javax.swing.JTextField();
        genre = new javax.swing.JTextField();
        instrument = new javax.swing.JTextField();
        codeLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        artistLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        instrumentLabel = new javax.swing.JLabel();
        difficultyLevelLabel = new javax.swing.JLabel();
        level = new javax.swing.JTextField();
        printedLabel = new javax.swing.JLabel();
        isPrinted = new javax.swing.JTextField();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Scores infromation");

        labelScoresInformation.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelScoresInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelScoresInformation.setText("Information about all scores");

        show.setText("Show");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        labelInstrumen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelInstrumen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInstrumen.setLabelFor(instrumentSelected);
        labelInstrumen.setText("Choose instrument");

        labelLevel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLevel.setLabelFor(difficultyLevel);
        labelLevel.setText("Choose a difficulty level");

        code.setEditable(false);

        title.setEditable(false);

        artist.setEditable(false);

        genre.setEditable(false);

        instrument.setEditable(false);

        codeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codeLabel.setText("Code");

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleLabel.setText("Title");

        artistLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        artistLabel.setText("Artist");

        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        genderLabel.setText("Genre");

        instrumentLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        instrumentLabel.setText("Instrument");

        difficultyLevelLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        difficultyLevelLabel.setText("Difficulty level");

        level.setEditable(false);

        printedLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        printedLabel.setText("Printed");

        isPrinted.setEditable(false);

        previous.setText("<< Previous");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        next.setText("Next >>");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        total.setEditable(false);
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setBorder(null);

        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userLabel.setText("User");

        userName.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout panelInformationLayout = new javax.swing.GroupLayout(panelInformation);
        panelInformation.setLayout(panelInformationLayout);
        panelInformationLayout.setHorizontalGroup(
            panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformationLayout.createSequentialGroup()
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformationLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(artistLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(instrumentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(difficultyLevelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(printedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformationLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(previous, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(81, 81, 81)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artist, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instrument, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isPrinted, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInformationLayout.createSequentialGroup()
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        panelInformationLayout.setVerticalGroup(
            panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artist, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artistLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instrumentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instrument, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(difficultyLevelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isPrinted, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelScoresInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelInstrumen, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(instrumentSelected, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(difficultyLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(74, 74, 74)
                        .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelScoresInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelInstrumen, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(labelLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(instrumentSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(difficultyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(panelInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Select options to filter scores
     *
     * @param evt
     */
    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        String instrumentSelected;
        String levelSelected;
        counter = 0;
        if (this.instrumentSelected.getSelectedIndex() == -1) {
            instrumentSelected = "";
        } else {
            instrumentSelected = this.instrumentSelected.getSelectedItem().toString();
        }
        if (difficultyLevel.getSelectedIndex() == -1) {
            levelSelected = "";
        } else {
            levelSelected = difficultyLevel.getSelectedItem().toString();
        }
        try {
            scores = Manager.getManager().selectedScores(instrumentSelected, levelSelected);
            if (scores.isEmpty()) {
                throw new ManagerException(ManagerException.SCORES_EMPTY);
            } else {
                showData();
                panelInformation.setVisible(true);
                setSize(950, 900);
                previous.setVisible(false);
                this.instrumentSelected.setSelectedIndex(-1);
                difficultyLevel.setSelectedIndex(-1);
            }
        } catch (ManagerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_showActionPerformed
    /**
     * Button previous
     *
     * @param evt
     */
    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        counter--;
        showData();
    }//GEN-LAST:event_previousActionPerformed
    /**
     * Button next
     *
     * @param evt
     */
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        counter++;
        showData();
    }//GEN-LAST:event_nextActionPerformed

    /**
     * Method to show score informations
     */
    private void showData() {
        next.setVisible(true);
        previous.setVisible(true);
        try {
            if (counter == 0 || scores.size() == 1) {
                previous.setVisible(false);
            }

            if ((counter == 0 && scores.size() == 1) || scores.size() == 1) {
                previous.setVisible(false);
                next.setVisible(false);
            }

            if ((counter > 0 && counter == scores.size() - 1) || (counter > 0 && counter == scores.size()) || (counter > 0 && counter == scores.size())) {
                next.setVisible(false);
            }

            Score score = (Score) scores.get(counter);
            total.setText(counter + 1 + " de " + scores.size());
            code.setText(score.getCode());
            title.setText(score.getTitle());
            artist.setText(score.getArtist());
            instrument.setText(score.getInstrument());
            genre.setText(score.getGenre());
            level.setText(score.getDifficultyLevel());
            if (score.isIsPrinted()) {
                isPrinted.setText("Yes");
            } else {
                isPrinted.setText("No");
            }
            userName.setText(Manager.getManager().scoreOwner(score.getCode()).getName());
        } catch (ManagerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField artist;
    private javax.swing.JLabel artistLabel;
    private javax.swing.JTextField code;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JComboBox<String> difficultyLevel;
    private javax.swing.JLabel difficultyLevelLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField genre;
    private javax.swing.JTextField instrument;
    private javax.swing.JLabel instrumentLabel;
    private javax.swing.JComboBox<String> instrumentSelected;
    private javax.swing.JTextField isPrinted;
    private javax.swing.JLabel labelInstrumen;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelScoresInformation;
    private javax.swing.JTextField level;
    private javax.swing.JButton next;
    private javax.swing.JPanel panelInformation;
    private javax.swing.JButton previous;
    private javax.swing.JLabel printedLabel;
    private javax.swing.JButton show;
    private javax.swing.JTextField title;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField total;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
