/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.user;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.UserDAO;
import com.wingman.clothingshopmanagement.model.image.Image;
import com.wingman.clothingshopmanagement.model.user.User;
import com.wingman.clothingshopmanagement.util.DateFormatter;
import com.wingman.clothingshopmanagement.util.ImageUtil;
import com.wingman.clothingshopmanagement.view.MainFrame;
import com.wingman.clothingshopmanagement.view.panel.message.ConfirmPanel;
import com.wingman.clothingshopmanagement.view.panel.message.SuccessPanel;
import lombok.Getter;
import raven.glasspanepopup.GlassPanePopup;


@Getter
public class UserPanel extends javax.swing.JPanel {

    private final UserManagementPanel panel;


    private final User user;
    
    public UserPanel(UserManagementPanel panel, User user) {
        this.panel = panel;
        this.user = user;
        initComponents();
        
        Image avatar = user.getAvatar();
        if (avatar != null) {
            userAvatar.setIcon(ImageUtil.resize(avatar.getImage(), 64, 64));
        }
        
        emailLabel.setText(user.getEmail());
        fullNameLabel.setText(user.getFullName());
        permissionLabel.setText(user.getPermission().getText());
        
        if (user.getLastActive() != null) {
            User currentUser = MainFrame.getInstance().getDashboardPanel().getUser();
            if (currentUser != null && currentUser.getEmail().equalsIgnoreCase(user.getEmail())) {
                lastActiveLabel.setText("Now");
            } else {
                lastActiveLabel.setText(DateFormatter.formatDate(user.getLastActive()));
            }
        } else {
            lastActiveLabel.setText("No data");
        }
        
        if (user.getAddedDate()!= null) {
            addedDateLabel.setText(DateFormatter.formatDate(user.getAddedDate()));
        } else {
            addedDateLabel.setText("No data");
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

        jSeparator1 = new javax.swing.JSeparator();
        userAvatar = new javax.swing.JLabel();
        fullNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        permissionLabel = new javax.swing.JLabel();
        lastActiveLabel = new javax.swing.JLabel();
        addedDateLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        editBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        deleteBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(java.awt.Color.gray);

        userAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_color.png"))); // NOI18N

        fullNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fullNameLabel.setText("Username");

        emailLabel.setText("email");

        permissionLabel.setText("Administrator");

        lastActiveLabel.setText("01/01/2024");

        addedDateLabel.setText("01/01/2024");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(122, 64));

        editBtn.setBorder(null);
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil .png"))); // NOI18N
        editBtn.setBorderColor(new java.awt.Color(255, 255, 255));
        editBtn.setColorClick(new java.awt.Color(255, 255, 255));
        editBtn.setColorOver(new java.awt.Color(255, 255, 255));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBorder(null);
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete .png"))); // NOI18N
        deleteBtn.setBorderColor(new java.awt.Color(255, 255, 255));
        deleteBtn.setColorClick(new java.awt.Color(255, 255, 255));
        deleteBtn.setColorOver(new java.awt.Color(255, 255, 255));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userAvatar)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(permissionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lastActiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addedDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userAvatar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(emailLabel))
                            .addComponent(permissionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lastActiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addedDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        GlassPanePopup.showPopup(new EditUserPanel(panel, user), "editUser");
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        ConfirmPanel.show("Do you want to delete this user?", () -> {
            UserDAO userDAO = DAOManager.getInstance().getUserDAO();
            userDAO.delete(user.getEmail()).thenAcceptAsync((t) -> {
                panel.refreshData();
                SuccessPanel.show("User deleted successfully!");
            });
        });
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addedDateLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomButton deleteBtn;
    private com.wingman.clothingshopmanagement.view.components.CustomButton editBtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lastActiveLabel;
    private javax.swing.JLabel permissionLabel;
    private javax.swing.JLabel userAvatar;
    // End of variables declaration//GEN-END:variables
}
