/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.user;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.UserDAO;
import com.wingman.clothingshopmanagement.model.user.User;
import com.wingman.clothingshopmanagement.view.MainFrame;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import lombok.Getter;

/**
 *
 * @author Administrator
 */
@Getter
public class UserManagementPanel extends javax.swing.JPanel {

    private final List<User> cachedUsers = new ArrayList<>();

    /**
     * Creates new form UserManagementPanel
     */
    public UserManagementPanel() {
        initComponents();
        
        refreshData();
        
        searchBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                displayUsers(searchBox.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                displayUsers(searchBox.getText());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                displayUsers(searchBox.getText());
            }
        });
    }

    public final void refreshData() {
        jPanel1.removeAll();
        cachedUsers.clear();
        
        MainFrame.getInstance().getLoading().showLoading();

        UserDAO userDAO = DAOManager.getInstance().getUserDAO();

        userDAO.getAll().thenAccept((users) -> {
            cachedUsers.addAll(users);
        }).thenRun(() -> {
            displayUsers("");
        }).whenComplete((result, e) -> {
            MainFrame.getInstance().getLoading().hideLoading();
            if (e != null) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });
    }

    private void displayUsers(String filter) {
        int count = 0;
        jPanel1.removeAll();
        for (User user : cachedUsers) {
            if (user.getEmail().toLowerCase().contains(filter.toLowerCase()) || 
                user.getFullName().toLowerCase().contains(filter.toLowerCase()) ||
                user.getPermission().getText().toLowerCase().contains(filter.toLowerCase())) {
                addUserPanel(new UserPanel(this, user));
                count++;
            }
        }
        userCountLabel.setText(String.valueOf(count));
        SwingUtilities.invokeLater(() -> {
            SwingUtilities.updateComponentTreeUI(this);
        });
    }

    private void addUserPanel(JPanel panel) {
        jPanel1.add(panel);

        int width = (int) jPanel1.getPreferredSize().getWidth();
        int height = (int) jPanel1.getPreferredSize().getHeight();

        height += panel.getHeight();

        jPanel1.setPreferredSize(new Dimension(width, height));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userManagementLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userCountLabel = new javax.swing.JLabel();
        addUserBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        searchBox = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        jPanel2 = new javax.swing.JPanel();
        userNameLabel = new javax.swing.JTextField();
        permissionLabel = new javax.swing.JTextField();
        lastActiveLabel = new javax.swing.JTextField();
        dateAddedLabel = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        userManagementLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userManagementLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userManagementLabel.setText("User Management");
        userManagementLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Manage users and their permissions here.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("All users");

        userCountLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userCountLabel.setForeground(java.awt.Color.gray);
        userCountLabel.setText("1");

        addUserBtn.setBackground(new java.awt.Color(125, 44, 224));
        addUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        addUserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        addUserBtn.setText("Add user");
        addUserBtn.setBorderColor(new java.awt.Color(125, 44, 224));
        addUserBtn.setColor(new java.awt.Color(125, 44, 224));
        addUserBtn.setColorClick(new java.awt.Color(75, 3, 163));
        addUserBtn.setColorOver(new java.awt.Color(96, 33, 173));
        addUserBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addUserBtn.setIconTextGap(12);
        addUserBtn.setPreferredSize(new java.awt.Dimension(118, 36));
        addUserBtn.setRadius(16);
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        searchBox.setBoderColor(new java.awt.Color(125, 44, 224));
        searchBox.setHint("Search");
        searchBox.setPreferredSize(new java.awt.Dimension(64, 36));
        searchBox.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-interface-symbol.png"))); // NOI18N
        searchBox.setRadius(16);
        searchBox.setSelectionColor(new java.awt.Color(155, 50, 255));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        userNameLabel.setEditable(false);
        userNameLabel.setBackground(new java.awt.Color(250, 250, 250));
        userNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userNameLabel.setForeground(java.awt.Color.gray);
        userNameLabel.setText("User");
        userNameLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        userNameLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameLabelActionPerformed(evt);
            }
        });

        permissionLabel.setEditable(false);
        permissionLabel.setBackground(new java.awt.Color(250, 250, 250));
        permissionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        permissionLabel.setForeground(java.awt.Color.gray);
        permissionLabel.setText("Permission");
        permissionLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lastActiveLabel.setEditable(false);
        lastActiveLabel.setBackground(new java.awt.Color(250, 250, 250));
        lastActiveLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lastActiveLabel.setForeground(java.awt.Color.gray);
        lastActiveLabel.setText("Last active");
        lastActiveLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        dateAddedLabel.setEditable(false);
        dateAddedLabel.setBackground(new java.awt.Color(250, 250, 250));
        dateAddedLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateAddedLabel.setForeground(java.awt.Color.gray);
        dateAddedLabel.setText("Date added");
        dateAddedLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permissionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastActiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateAddedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(userNameLabel)
                .addComponent(permissionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addComponent(lastActiveLabel)
                .addComponent(dateAddedLabel))
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(971, 515));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(971, 515));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(971, 515));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(971, 515));
        jPanel1.setMinimumSize(new java.awt.Dimension(971, 515));
        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 425, Short.MAX_VALUE)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userManagementLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userManagementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        JDialog dialog = new JDialog(MainFrame.getInstance(), "Add user", true);
        dialog.setContentPane(new AddUserPanel(dialog, this));
        dialog.pack();
        dialog.setLocationRelativeTo(MainFrame.getInstance());
        dialog.setVisible(true);
        dialog.setResizable(false);
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void userNameLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameLabelActionPerformed

    }//GEN-LAST:event_userNameLabelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.CustomButton addUserBtn;
    private javax.swing.JTextField dateAddedLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastActiveLabel;
    private javax.swing.JTextField permissionLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField searchBox;
    private javax.swing.JLabel userCountLabel;
    private javax.swing.JLabel userManagementLabel;
    private javax.swing.JTextField userNameLabel;
    // End of variables declaration//GEN-END:variables
}
