/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.message;

import com.wingman.clothingshopmanagement.view.components.CustomPanel;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author Administrator
 */
public class SuccessPanel extends CustomPanel {

    /**
     * Creates new form InfoMessagePanel
     * @param message
     */
    public SuccessPanel(String message) {
        initComponents();
         content.setText(String.format("<html><p style='text-align: center; width: 190px;'>%s</p></html>", message));
    }
    
    public static void show(String mesage) {
        GlassPanePopup.showPopup(new SuccessPanel(mesage), "success");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        content = new javax.swing.JLabel();
        okayBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorderColor(java.awt.Color.lightGray);
        setRadius(16);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(75, 174, 79));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Success!");
        jLabel1.setFocusable(false);

        content.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        content.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        content.setText("<html><p style='text-align: center; width: 160px;'>Đây là nội dung của JLabel.</p></html>");

        okayBtn.setBackground(new java.awt.Color(75, 174, 79));
        okayBtn.setForeground(new java.awt.Color(255, 255, 255));
        okayBtn.setText("OKAY");
        okayBtn.setBorderColor(new java.awt.Color(75, 174, 79));
        okayBtn.setColor(new java.awt.Color(75, 174, 79));
        okayBtn.setColorClick(new java.awt.Color(53, 123, 55));
        okayBtn.setColorOver(new java.awt.Color(91, 212, 96));
        okayBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        okayBtn.setRadius(16);
        okayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okayBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel2)
                        .addGap(0, 161, Short.MAX_VALUE))
                    .addComponent(content, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okayBtnActionPerformed
        GlassPanePopup.closePopup("success");
    }//GEN-LAST:event_okayBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.wingman.clothingshopmanagement.view.components.CustomButton okayBtn;
    // End of variables declaration//GEN-END:variables
}
