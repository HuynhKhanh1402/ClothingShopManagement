/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel;

import com.formdev.flatlaf.FlatLightLaf;
import com.wingman.clothingshopmanagement.view.panel.user.UserManagementPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lombok.Getter;

/**
 *
 * @author Administrator
 */
@Getter
public class DashboardPanel extends javax.swing.JPanel {
    private JPanel contentPanel;
    /**
     * Creates new form Temp
     */
    public DashboardPanel() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        customButton2 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customPanel1 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        customButton1 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customButton3 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customButton4 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customButton5 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customButton6 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customButton7 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customButton9 = new com.wingman.clothingshopmanagement.view.components.CustomButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(244, 243, 243));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(125, 44, 224));
        jLabel1.setText("Clothing Shop Management");

        customButton2.setBackground(new java.awt.Color(125, 44, 224));
        customButton2.setBorder(null);
        customButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        customButton2.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton2.setColor(new java.awt.Color(125, 44, 224));
        customButton2.setColorClick(new java.awt.Color(125, 44, 224));
        customButton2.setColorOver(new java.awt.Color(125, 44, 224));
        customButton2.setPreferredSize(new java.awt.Dimension(36, 36));
        customButton2.setRadius(100);
        customButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 956, Short.MAX_VALUE)
                .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        customPanel1.setBackground(new java.awt.Color(125, 44, 224));
        customPanel1.setBorderColor(new java.awt.Color(244, 243, 243));
        customPanel1.setColor(new java.awt.Color(125, 44, 224));
        customPanel1.setPreferredSize(new java.awt.Dimension(249, 686));
        customPanel1.setRadius(16);

        customButton1.setBackground(new java.awt.Color(125, 44, 224));
        customButton1.setForeground(new java.awt.Color(255, 255, 255));
        customButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        customButton1.setText("Home");
        customButton1.setActionCommand("  Home");
        customButton1.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton1.setColor(new java.awt.Color(125, 44, 224));
        customButton1.setColorClick(new java.awt.Color(75, 3, 163));
        customButton1.setColorOver(new java.awt.Color(96, 33, 173));
        customButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        customButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton1.setIconTextGap(12);
        customButton1.setPreferredSize(new java.awt.Dimension(112, 44));
        customButton1.setRadius(10);
        customButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton1ActionPerformed(evt);
            }
        });

        customButton3.setBackground(new java.awt.Color(125, 44, 224));
        customButton3.setForeground(new java.awt.Color(255, 255, 255));
        customButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        customButton3.setText("Manage User");
        customButton3.setActionCommand("  Home");
        customButton3.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton3.setColor(new java.awt.Color(125, 44, 224));
        customButton3.setColorClick(new java.awt.Color(75, 3, 163));
        customButton3.setColorOver(new java.awt.Color(96, 33, 173));
        customButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        customButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton3.setIconTextGap(12);
        customButton3.setPreferredSize(new java.awt.Dimension(112, 44));
        customButton3.setRadius(10);
        customButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton3ActionPerformed(evt);
            }
        });

        customButton4.setBackground(new java.awt.Color(125, 44, 224));
        customButton4.setForeground(new java.awt.Color(255, 255, 255));
        customButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clothes-hanger.png"))); // NOI18N
        customButton4.setText("Manage Products");
        customButton4.setActionCommand("  Home");
        customButton4.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton4.setColor(new java.awt.Color(125, 44, 224));
        customButton4.setColorClick(new java.awt.Color(75, 3, 163));
        customButton4.setColorOver(new java.awt.Color(96, 33, 173));
        customButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        customButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton4.setIconTextGap(12);
        customButton4.setPreferredSize(new java.awt.Dimension(112, 44));
        customButton4.setRadius(10);

        customButton5.setBackground(new java.awt.Color(125, 44, 224));
        customButton5.setForeground(new java.awt.Color(255, 255, 255));
        customButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping-cart.png"))); // NOI18N
        customButton5.setText("Order");
        customButton5.setActionCommand("  Home");
        customButton5.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton5.setColor(new java.awt.Color(125, 44, 224));
        customButton5.setColorClick(new java.awt.Color(75, 3, 163));
        customButton5.setColorOver(new java.awt.Color(96, 33, 173));
        customButton5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        customButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton5.setIconTextGap(12);
        customButton5.setPreferredSize(new java.awt.Dimension(112, 44));
        customButton5.setRadius(10);

        customButton6.setBackground(new java.awt.Color(125, 44, 224));
        customButton6.setForeground(new java.awt.Color(255, 255, 255));
        customButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard.png"))); // NOI18N
        customButton6.setText("Manage Orders");
        customButton6.setActionCommand("  Home");
        customButton6.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton6.setColor(new java.awt.Color(125, 44, 224));
        customButton6.setColorClick(new java.awt.Color(75, 3, 163));
        customButton6.setColorOver(new java.awt.Color(96, 33, 173));
        customButton6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        customButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton6.setIconTextGap(12);
        customButton6.setPreferredSize(new java.awt.Dimension(112, 44));
        customButton6.setRadius(10);

        customButton7.setBackground(new java.awt.Color(125, 44, 224));
        customButton7.setForeground(new java.awt.Color(255, 255, 255));
        customButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money-tag.png"))); // NOI18N
        customButton7.setText("Revenue");
        customButton7.setActionCommand("  Home");
        customButton7.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton7.setColor(new java.awt.Color(125, 44, 224));
        customButton7.setColorClick(new java.awt.Color(75, 3, 163));
        customButton7.setColorOver(new java.awt.Color(96, 33, 173));
        customButton7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        customButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton7.setIconTextGap(12);
        customButton7.setPreferredSize(new java.awt.Dimension(112, 44));
        customButton7.setRadius(10);
        customButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton7ActionPerformed(evt);
            }
        });

        customButton9.setBackground(new java.awt.Color(125, 44, 224));
        customButton9.setForeground(new java.awt.Color(255, 255, 255));
        customButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        customButton9.setText("Log out");
        customButton9.setActionCommand("  Home");
        customButton9.setAlignmentY(0.0F);
        customButton9.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton9.setColor(new java.awt.Color(125, 44, 224));
        customButton9.setColorClick(new java.awt.Color(75, 3, 163));
        customButton9.setColorOver(new java.awt.Color(96, 33, 173));
        customButton9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        customButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton9.setIconTextGap(12);
        customButton9.setPreferredSize(new java.awt.Dimension(112, 44));
        customButton9.setRadius(10);
        customButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(customButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(customButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(customPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 54, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void customButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customButton2ActionPerformed

    private void customButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton7ActionPerformed
        
    }//GEN-LAST:event_customButton7ActionPerformed

    private void customButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton9ActionPerformed

    }//GEN-LAST:event_customButton9ActionPerformed

    private void customButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customButton1ActionPerformed

    private void customButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton3ActionPerformed
        setConentPanel(new UserManagementPanel());
    }//GEN-LAST:event_customButton3ActionPerformed
    
    public void setConentPanel(JPanel panel) {
        if (contentPanel != null) {
            remove(contentPanel);
        }
        contentPanel = panel;
        add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 55, 1006, 684));
        revalidate();
    }
    
    public static void main(String[] args) {
        FlatLightLaf.setup();
        JFrame frame = new JFrame();
        frame.add(new DashboardPanel());
        frame.pack();
        frame.setVisible(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton1;
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton2;
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton3;
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton4;
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton5;
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton6;
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton7;
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton9;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
