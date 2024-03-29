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
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import model.score.Score;

/**
 *
 * @author Yuli
 */
public class DeleteScore extends javax.swing.JDialog {

    /**
     * Creates new form DeleteScore
     */
    public DeleteScore(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SwingTools.getSwingTools().setIcon(this, null);
        TreeMap<String, Score> userScores = Manager.getManager().getCurrentUser().getScores();
        for (Map.Entry<String, Score> codeScoreItem : userScores.entrySet()) {
            selectScore.addItem(codeScoreItem.getKey());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        selectScore = new javax.swing.JComboBox<>();
        deleteScore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete Score");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Choose a score");

        deleteScore.setText("Delete");
        deleteScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteScoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectScore, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteScore, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectScore, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(deleteScore, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Call a method to delete score in Manager
     * @param evt 
     */
    private void deleteScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteScoreActionPerformed
        if (selectScore.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Score not selected", "Message", JOptionPane.WARNING_MESSAGE);
        } else {
            int optionSelected = JOptionPane.showConfirmDialog(this, "Are you sure?", "Delete Score", JOptionPane.YES_NO_CANCEL_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (optionSelected == 0) {
                try {
                    String code = selectScore.getSelectedItem().toString();
                    Score scoreForDelete = Manager.getManager().checkExistUserScore(code);
                    if (scoreForDelete == null) {
                        JOptionPane.showMessageDialog(this, "Score not registred", "Message", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (Manager.getManager().deleteScore(scoreForDelete)) {
                            JOptionPane.showMessageDialog(this, "Score deleted successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Error ", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (ManagerException ex) {
                    JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
                } catch (InputOutputException ex) {
                    JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_deleteScoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> selectScore;
    // End of variables declaration//GEN-END:variables
}
