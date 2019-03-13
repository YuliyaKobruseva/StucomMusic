/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import controller.Manager;
import exceptions.ManagerException;
import javax.swing.JOptionPane;
import model.user.User;

/**
 *
 * @author Yuli
 */
public class AddUser extends javax.swing.JDialog {

    /**
     * Creates new form AddUser
     *
     * @param parent
     * @param modal
     */
    public AddUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        errorName.setVisible(false);
        errorPass.setVisible(false);
        errorPass2.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        nameUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password1 = new javax.swing.JPasswordField();
        password2 = new javax.swing.JPasswordField();
        addUserButton = new javax.swing.JButton();
        labelAdmin = new javax.swing.JLabel();
        isAdmin = new javax.swing.JCheckBox();
        errorPass2 = new javax.swing.JLabel();
        errorName = new javax.swing.JLabel();
        errorPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New User");

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel.setLabelFor(nameUser);
        nameLabel.setText("User name");

        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordLabel.setLabelFor(password1);
        passwordLabel.setText("Password");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setLabelFor(password2);
        jLabel3.setText("Confirm password");

        password2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                password2FocusLost(evt);
            }
        });

        addUserButton.setText("Add user");
        addUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserButtonMouseClicked(evt);
            }
        });

        labelAdmin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAdmin.setLabelFor(isAdmin);
        labelAdmin.setText("Admin type");

        errorPass2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        errorPass2.setForeground(new java.awt.Color(255, 51, 0));
        errorPass2.setText("Password does not match");

        errorName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        errorName.setForeground(new java.awt.Color(255, 51, 0));
        errorName.setText("Name us required");

        errorPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        errorPass.setForeground(new java.awt.Color(255, 51, 0));
        errorPass.setText("Password is required");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorPass, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(isAdmin)
                        .addComponent(nameUser, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addComponent(errorPass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(password1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(errorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameUser, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorPass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(errorPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isAdmin))
                .addGap(58, 58, 58)
                .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseClicked
        String name = nameUser.getText();
        String pass1 = String.valueOf(password1.getPassword());
        String pass2 = String.valueOf(password2.getPassword());
        boolean isAdminUser = isAdmin.isSelected();
        if (name.equals("") || name.trim().equals("")) {
            errorName.setVisible(true);
        } else if (pass1.equals("") || pass1.trim().equals("")) {
            errorPass.setVisible(true);
        } else {
            if (Manager.getManager().checkPassword(pass1, pass2)) {
                try {
                    User userAdd = Manager.getManager().checkExistUser(name);
                    if (userAdd != null) {
                        JOptionPane.showMessageDialog(this, "User already exist", "Message", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (Manager.getManager().addNewUser(name, pass1, isAdminUser)) {
                            JOptionPane.showMessageDialog(this, "User added successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                            nameUser.setText("");
                            password1.setText("");
                            password2.setText("");
                        } else {
                            JOptionPane.showMessageDialog(this, "User already exist", "Message", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (ManagerException ex) {
                    JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                errorPass2.setVisible(true);
            }
        }
    }//GEN-LAST:event_addUserButtonMouseClicked

    private void password2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password2FocusLost
        String pass1 = String.valueOf(password1.getPassword());
        String pass2 = String.valueOf(password2.getPassword());
        if (Manager.getManager().checkPassword(pass1, pass2)) {
            errorPass2.setVisible(false);
        } else {
            errorPass2.setVisible(true);
        }
    }//GEN-LAST:event_password2FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JLabel errorName;
    private javax.swing.JLabel errorPass;
    private javax.swing.JLabel errorPass2;
    private javax.swing.JCheckBox isAdmin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelAdmin;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameUser;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    private javax.swing.JLabel passwordLabel;
    // End of variables declaration//GEN-END:variables
}
