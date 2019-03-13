/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import controller.Manager;
import exceptions.ManagerException;
import java.awt.Color;
import javax.swing.JOptionPane;
import model.user.User;

/**
 *
 * @author Yuli
 */
public class UserInterface extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     *
     * @param user
     */
    public UserInterface(User user) {
        initComponents();
        Manager.getManager().setIcon(null, this);
        helloText.setOpaque(false);
        helloText.setBackground(new Color(0, 0, 0, 0));
        Manager.getManager().setCurrentUser(user);
        helloText.setText("¡Welcome to StucomMusic, " + user.getName() + "!");
        if (user.getTypeUser().toString().equals("USER")) {
            addUser.setVisible(false);
            modifyUser.setVisible(false);
            deleteUser.setVisible(false);
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

        helloText = new javax.swing.JTextField();
        addScore = new javax.swing.JButton();
        modifyScore = new javax.swing.JButton();
        deleteScore = new javax.swing.JButton();
        showScores = new javax.swing.JButton();
        showGlobalInformation = new javax.swing.JButton();
        addUser = new javax.swing.JButton();
        modifyUser = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StucomMusic");

        helloText.setEditable(false);
        helloText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        helloText.setForeground(new java.awt.Color(0, 152, 141));
        helloText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        helloText.setBorder(null);

        addScore.setText("Add Score");
        addScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addScoreMouseClicked(evt);
            }
        });

        modifyScore.setText("Modify Score");
        modifyScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyScoreMouseClicked(evt);
            }
        });

        deleteScore.setText("Delete Score");
        deleteScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteScoreMouseClicked(evt);
            }
        });

        showScores.setText("Show Scores");
        showScores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showScoresMouseClicked(evt);
            }
        });

        showGlobalInformation.setText("Show Global Information");
        showGlobalInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showGlobalInformationMouseClicked(evt);
            }
        });

        addUser.setText("Add User");
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });

        modifyUser.setText("Modify User");
        modifyUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyUserMouseClicked(evt);
            }
        });

        deleteUser.setText("Delete User");
        deleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(showScores, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(showGlobalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(modifyScore, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(deleteScore, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(helloText, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addScore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(modifyUser, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(helloText, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addScore, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modifyScore, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteScore, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showScores, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showGlobalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt
     */
    private void addScoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addScoreMouseClicked
        NewScore newScore = new NewScore(this, true);
        newScore.setLocationRelativeTo(null);
        newScore.setVisible(true);
    }//GEN-LAST:event_addScoreMouseClicked

    /**
     *
     * @param evt
     */
    private void modifyScoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyScoreMouseClicked
         try {
            if (Manager.getManager().allScores().isEmpty()) {
                throw new ManagerException(ManagerException.SCORES_EMPTY);
            } else {
                ModifyScore modifyScore = new ModifyScore(this, true);
                modifyScore.setLocationRelativeTo(null);
                modifyScore.setVisible(true);
            }
        } catch (ManagerException ex) {
            JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_modifyScoreMouseClicked

    /**
     *
     * @param evt
     */
    private void deleteScoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteScoreMouseClicked
         try {
            if (Manager.getManager().allScores().isEmpty()) {
                throw new ManagerException(ManagerException.SCORES_EMPTY);
            } else {
                DeleteScore deleteScore = new DeleteScore(this, true);
                deleteScore.setLocationRelativeTo(null);
                deleteScore.setVisible(true);
            }
        } catch (ManagerException ex) {
            JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_deleteScoreMouseClicked

    /**
     *
     * @param evt
     */
    private void showScoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showScoresMouseClicked
        try {
            if (Manager.getManager().allScores().isEmpty()) {
                throw new ManagerException(ManagerException.SCORES_EMPTY);
            } else {
                InformationScores informationScores = new InformationScores(this, true);
                informationScores.setLocationRelativeTo(null);
                informationScores.setVisible(true);
            }
        } catch (ManagerException ex) {
            JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_showScoresMouseClicked

    /**
     *
     * @param evt
     */
    private void showGlobalInformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showGlobalInformationMouseClicked
        StatisticalInformation statisticalInformation = new StatisticalInformation(this, true);
        statisticalInformation.setLocationRelativeTo(null);
        statisticalInformation.setVisible(true);
    }//GEN-LAST:event_showGlobalInformationMouseClicked

    /**
     *
     * @param evt
     */
    private void modifyUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyUserMouseClicked
        ModifyUser modifyUser = new ModifyUser(this, true);
        modifyUser.setLocationRelativeTo(null);
        modifyUser.setVisible(true);
    }//GEN-LAST:event_modifyUserMouseClicked

    /**
     *
     * @param evt
     */
    private void deleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserMouseClicked
        DeleteUser deleteUser = new DeleteUser(this, true);
        deleteUser.setLocationRelativeTo(null);
        deleteUser.setVisible(true);
    }//GEN-LAST:event_deleteUserMouseClicked

    /**
     *
     * @param evt
     */
    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
        AddUser newUser = new AddUser(this, true);
        newUser.setLocationRelativeTo(null);
        newUser.setVisible(true);
    }//GEN-LAST:event_addUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addScore;
    private javax.swing.JButton addUser;
    private javax.swing.JButton deleteScore;
    private javax.swing.JButton deleteUser;
    private javax.swing.JTextField helloText;
    private javax.swing.JButton modifyScore;
    private javax.swing.JButton modifyUser;
    private javax.swing.JButton showGlobalInformation;
    private javax.swing.JButton showScores;
    // End of variables declaration//GEN-END:variables
}