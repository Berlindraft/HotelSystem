/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.AdminSignupController;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author marvi
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register1
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        firstName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userPass = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        userEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        userPNumber = new javax.swing.JTextField();
        userPass2 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        closeBtn1 = new javax.swing.JButton();
        showPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(101, 28, 50));
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel2.setLayout(null);
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 500, 560);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 500));

        firstName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        firstName.setForeground(new java.awt.Color(204, 204, 204));
        firstName.setText("Firstname *");
        firstName.setToolTipText("");
        firstName.setMargin(new java.awt.Insets(6, 6, 6, 6));
        firstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameFocusGained(evt);
            }
        });
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Password");

        userPass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        userPass.setForeground(new java.awt.Color(204, 204, 204));
        userPass.setText("password");
        userPass.setMargin(new java.awt.Insets(6, 6, 6, 6));
        userPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPassFocusGained(evt);
            }
        });

        btnlogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(51, 51, 255));
        btnlogin.setText("Login");
        btnlogin.setToolTipText("");
        btnlogin.setInheritsPopupMenu(true);
        btnlogin.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnlogin.setMaximumSize(new java.awt.Dimension(64, 42));
        btnlogin.setMinimumSize(new java.awt.Dimension(64, 42));
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Already have an account?");

        btnSignup.setBackground(new java.awt.Color(179, 139, 78));
        btnSignup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setText("Sign up");
        btnSignup.setToolTipText("");
        btnSignup.setInheritsPopupMenu(true);
        btnSignup.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btnSignup.setMaximumSize(new java.awt.Dimension(64, 42));
        btnSignup.setMinimumSize(new java.awt.Dimension(64, 42));
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        jLabel4.setText("Email Address");

        userEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        userEmail.setForeground(new java.awt.Color(204, 204, 204));
        userEmail.setText("Email Address *");
        userEmail.setToolTipText("");
        userEmail.setMargin(new java.awt.Insets(6, 6, 6, 6));
        userEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userEmailFocusGained(evt);
            }
        });
        userEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailActionPerformed(evt);
            }
        });

        jLabel5.setText("Contact Number");

        userPNumber.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        userPNumber.setForeground(new java.awt.Color(204, 204, 204));
        userPNumber.setText("0900-0000-000 *");
        userPNumber.setToolTipText("");
        userPNumber.setMargin(new java.awt.Insets(6, 6, 6, 6));
        userPNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPNumberFocusGained(evt);
            }
        });
        userPNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPNumberActionPerformed(evt);
            }
        });

        userPass2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        userPass2.setForeground(new java.awt.Color(204, 204, 204));
        userPass2.setText("password");
        userPass2.setToolTipText("");
        userPass2.setMargin(new java.awt.Insets(6, 6, 6, 6));
        userPass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPass2FocusGained(evt);
            }
        });

        jLabel6.setText("Confirm Password");

        lastName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lastName.setForeground(new java.awt.Color(204, 204, 204));
        lastName.setText("Lastname *");
        lastName.setToolTipText("");
        lastName.setMargin(new java.awt.Insets(6, 6, 6, 6));
        lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameFocusGained(evt);
            }
        });
        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });

        closeBtn1.setBackground(new java.awt.Color(179, 139, 78));
        closeBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        closeBtn1.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        closeBtn1.setToolTipText("");
        closeBtn1.setFocusCycleRoot(true);
        closeBtn1.setMargin(new java.awt.Insets(5, 14, 5, 14));
        closeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtn1ActionPerformed(evt);
            }
        });

        showPass.setText("Show Password");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnSignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPass)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(userPNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
                    .addComponent(userPass2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastName))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeBtn1)
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(userPNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPass2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPass)
                .addGap(24, 24, 24)
                .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 0, 490, 530);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(500, 0, 500, 570);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
//        Login login = new Login();
//        login.setVisible(true);
//        login.pack();
//        login.setLocationRelativeTo(null);
//        this.dispose();
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        // TODO add your handling code here:
        String userFirst = firstName.getText();
        String userLast = lastName.getText();
        String email = userEmail.getText();
        String phoneNumber = userPNumber.getText();
        
        
        //MAO NI ANG DEPRECATED NGA CODE!!!
        //MAO NI ANG DEPRECATED NGA CODE!!!
        //MAO NI ANG DEPRECATED NGA CODE!!!
        String password = userPass.getText();
        String confirmPassword = userPass2.getText();
        
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(new JFrame(), "Passwords do not match");
            return;
        }
        AdminSignupController controller = new AdminSignupController();
        controller.signUp(userFirst, userLast, email, phoneNumber, password);
    }//GEN-LAST:event_btnSignupActionPerformed

    private void userEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmailActionPerformed

    private void userPNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userPNumberActionPerformed

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameActionPerformed

    private void closeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtn1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeBtn1ActionPerformed

    private void firstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFocusGained
        // TODO add your handling code here:
        if(firstName != null && firstName.getText().equals("Firstname *"))
        {
            firstName.setText("");
            firstName.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_firstNameFocusGained

    private void lastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFocusGained
        // TODO add your handling code here:
        if(lastName != null && lastName.getText().equals("Lastname *"))
        {
            lastName.setText("");
            lastName.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_lastNameFocusGained

    private void userEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userEmailFocusGained
        // TODO add your handling code here:
        if(userEmail != null && userEmail.getText().equals("Email Address *"))
        {
            userEmail.setText("");
            userEmail.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_userEmailFocusGained

    private void userPNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPNumberFocusGained
        // TODO add your handling code here:
        if(userPNumber != null && userPNumber.getText().equals("0900-0000-000 *"))
        {
            userPNumber.setText("");
            userPNumber.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_userPNumberFocusGained

    private void userPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPassFocusGained
        // TODO add your handling code here:
        if(userPass != null && userPass.getText().equals("password"))
        {
            userPass.setText("");
            userPass.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_userPassFocusGained

    private void userPass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPass2FocusGained
        // TODO add your handling code here:
        if(userPass2 != null && userPass2.getText().equals("password"))
        {
            userPass2.setText("");
            userPass2.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_userPass2FocusGained

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        // TODO add your handling code here:
        if (showPass.isSelected()) {
            userPass.setEchoChar((char) 0); 
            userPass2.setEchoChar((char) 0); 
        } else {
            userPass.setEchoChar('\u2022');
            userPass2.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_showPassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignup;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton closeBtn1;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField lastName;
    private javax.swing.JCheckBox showPass;
    private javax.swing.JTextField userEmail;
    private javax.swing.JTextField userPNumber;
    private javax.swing.JPasswordField userPass;
    private javax.swing.JPasswordField userPass2;
    // End of variables declaration//GEN-END:variables
}
