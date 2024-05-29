/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.user;

import com.mysql.cj.protocol.Warning;
import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.ImageDAO;
import com.wingman.clothingshopmanagement.model.dao.UserDAO;
import com.wingman.clothingshopmanagement.model.image.Image;
import com.wingman.clothingshopmanagement.model.user.Permission;
import com.wingman.clothingshopmanagement.model.user.User;
import com.wingman.clothingshopmanagement.util.BCryptUtil;
import com.wingman.clothingshopmanagement.util.ImageUtil;
import com.wingman.clothingshopmanagement.view.MainFrame;
import com.wingman.clothingshopmanagement.view.components.CustomPanel;
import com.wingman.clothingshopmanagement.view.panel.message.SuccessPanel;
import com.wingman.clothingshopmanagement.view.panel.message.WarningPanel;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import lombok.Getter;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author Administrator
 */
@Getter
public class EditUserPanel extends CustomPanel {
    private final UserManagementPanel panel;
    private final User user;
    private boolean isChangedAvatar = false;

    /**
     * Creates new form UserCreatePanel
     *
     * @param panel
     * @param user
     */
    public EditUserPanel(UserManagementPanel panel, User user) {
        initComponents();
        this.panel = panel;
        this.user = user;

        if (user.getAvatar() != null) {
            imgLabel.setIcon(ImageUtil.resize(user.getAvatar().getImage(), 166, 166));
        } else {
            imgLabel.setIcon(ImageUtil.resize(new ImageIcon(getClass().getResource("/images/user_color.png")), 166, 166));
        }

        emailTextField.setText(user.getEmail());
        emailTextField.setEditable(false);

        fullNameTextField.setText(user.getFullName());

        permissionDropdown.setSelectedItem(user.getPermission().getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        fullNameTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        jLabel3 = new javax.swing.JLabel();
        chooseImgBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        jLabel4 = new javax.swing.JLabel();
        permissionDropdown = new com.wingman.clothingshopmanagement.view.components.CustomComboBox();
        jPanel1 = new javax.swing.JPanel();
        cancelBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        saveBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        jLabel5 = new javax.swing.JLabel();
        passwordField = new com.wingman.clothingshopmanagement.view.components.CustomPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorderColor(java.awt.Color.lightGray);
        setRadius(16);

        imgLabel.setPreferredSize(new java.awt.Dimension(128, 128));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.darkGray);
        jLabel2.setText("Email");

        emailTextField.setBoderColor(java.awt.Color.lightGray);
        emailTextField.setHint("Enter email");
        emailTextField.setPreferredSize(new java.awt.Dimension(124, 32));
        emailTextField.setRadius(12);

        fullNameTextField.setBoderColor(java.awt.Color.lightGray);
        fullNameTextField.setHint("Enter full name");
        fullNameTextField.setPreferredSize(new java.awt.Dimension(124, 32));
        fullNameTextField.setRadius(12);
        fullNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.darkGray);
        jLabel3.setText("Full name");

        chooseImgBtn.setForeground(new java.awt.Color(171, 112, 242));
        chooseImgBtn.setText("Choose Image");
        chooseImgBtn.setBorderColor(new java.awt.Color(171, 112, 242));
        chooseImgBtn.setColorClick(new java.awt.Color(251, 255, 255));
        chooseImgBtn.setColorOver(new java.awt.Color(255, 255, 255));
        chooseImgBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chooseImgBtn.setRadius(12);
        chooseImgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImgBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.darkGray);
        jLabel4.setText("Permission");

        permissionDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Moderator" }));
        permissionDropdown.setBorderColor(java.awt.Color.lightGray);
        permissionDropdown.setRadius(12);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cancelBtn.setForeground(new java.awt.Color(171, 112, 242));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorderColor(new java.awt.Color(171, 112, 242));
        cancelBtn.setColorClick(new java.awt.Color(251, 255, 255));
        cancelBtn.setColorOver(new java.awt.Color(255, 255, 255));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelBtn.setRadius(12);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(125, 44, 224));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorderColor(new java.awt.Color(125, 44, 224));
        saveBtn.setColor(new java.awt.Color(125, 44, 224));
        saveBtn.setColorClick(new java.awt.Color(75, 3, 163));
        saveBtn.setColorOver(new java.awt.Color(96, 33, 173));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveBtn.setRadius(12);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74)
                .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.darkGray);
        jLabel5.setText("Password");

        passwordField.setEditable(false);
        passwordField.setText("Password");
        passwordField.setBorderColor(java.awt.Color.lightGray);
        passwordField.setRadius(12);

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(chooseImgBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fullNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(permissionDropdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox1)
                                .addGap(219, 219, 219))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jCheckBox1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chooseImgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permissionDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fullNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameTextFieldActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (!validdateTextField(emailTextField, "Email is empty!")) {
            return;
        }

        if (!validdateTextField(fullNameTextField, "Full name is empty!")) {
            return;
        }

        if (!validdateTextField(passwordField, "Password is empty!")) {
            return;
        }

        String fullName = fullNameTextField.getText();
        String password = new String(passwordField.getPassword());
        Permission permission = Permission.valueOf(((String) permissionDropdown.getSelectedItem()).toUpperCase());

        user.setFullName(fullName);
        user.setPermission(permission);

        if (jCheckBox1.isSelected() && !password.equals(user.getHashedPassword())) {
            user.setHashedPassword(BCryptUtil.hash(password));
        }

        UserDAO userDAO = DAOManager.getInstance().getUserDAO();
        ImageDAO imageDAO = DAOManager.getInstance().getImageDAO();

        MainFrame.getInstance().getLoading().showLoading();
        userDAO.update(user).thenAcceptAsync((t) -> {
            if (!isChangedAvatar) {
                return;
            }
            if (user.getAvatar() == null) {
                Image image = new Image();
                image.setImage((ImageIcon) imgLabel.getIcon());
                imageDAO.save(image).join();
            } else {
                Image image = user.getAvatar();
                image.setImage((ImageIcon) imgLabel.getIcon());
                imageDAO.update(image).join();
            }
            SuccessPanel.show("User saved successfully.");
        }).whenComplete((t, u) -> {
            MainFrame.getInstance().getLoading().hideLoading();
            GlassPanePopup.closePopup("editUser");
            panel.refreshData();
            if (u != null) {
                u.printStackTrace();
                throw new RuntimeException(u);
            }
        });


    }//GEN-LAST:event_saveBtnActionPerformed

    private void chooseImgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            imgLabel.setIcon(ImageUtil.resize(imageIcon, 166, 166));
            isChangedAvatar = true;
        }
    }//GEN-LAST:event_chooseImgBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        GlassPanePopup.closePopup("editUser");
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            passwordField.setEditable(true);
            passwordField.setText("");
            passwordField.requestFocus();
        } else {
            passwordField.setEditable(false);
            passwordField.setText("Password");
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private boolean validdateTextField(JTextField field, String message) {
        if (field.getText().isBlank()) {
            WarningPanel.show(message);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.CustomButton cancelBtn;
    private com.wingman.clothingshopmanagement.view.components.CustomButton chooseImgBtn;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField emailTextField;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField fullNameTextField;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.wingman.clothingshopmanagement.view.components.CustomPasswordField passwordField;
    private com.wingman.clothingshopmanagement.view.components.CustomComboBox permissionDropdown;
    private com.wingman.clothingshopmanagement.view.components.CustomButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
