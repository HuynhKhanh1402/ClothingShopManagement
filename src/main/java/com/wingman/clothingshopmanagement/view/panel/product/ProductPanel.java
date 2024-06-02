/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.product;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.ProductDAO;
import com.wingman.clothingshopmanagement.model.product.Product;
import com.wingman.clothingshopmanagement.util.ImageUtil;
import com.wingman.clothingshopmanagement.util.NumberFormatter;
import com.wingman.clothingshopmanagement.view.panel.message.ConfirmPanel;
import com.wingman.clothingshopmanagement.view.panel.message.SuccessPanel;
import javax.swing.SwingUtilities;
import lombok.Getter;
import raven.glasspanepopup.GlassPanePopup;


@Getter
public class ProductPanel extends javax.swing.JPanel {

    private final ProductManagementPanel panel;
    private final Product product;

    /**
     * Creates new form ProductPanel
     *
     * @param panel
     * @param product
     */
    public ProductPanel(ProductManagementPanel panel, Product product) {
        initComponents();
        this.panel = panel;
        this.product = product;

        if (product.getProductImage() != null) {
            imgLabel.setIcon(ImageUtil.resize(product.getProductImage().getImage(), 64, 64));
        }

        idLabel.setText(String.valueOf(product.getProductId()));
        nameLabel.setText(String.format("<html><p width=\"150px\">%s</p></html>", product.getName()));
        colorAndSizeLabel.setText(String.format("Color: %s | Size: %s", product.getColor(), product.getSize()));
        brandLabel.setText(String.format("<html><p width=\"80px\">%s</p></html>", product.getBrand()));
        genderLabel.setText(product.getGender().getValue());
        priceLabel.setText(NumberFormatter.format(product.getPrice()));
        stockLabel.setText(NumberFormatter.format(product.getStock()));
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
        checkBox = new javax.swing.JCheckBox();
        imgLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        editBtn1 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        deleteBtn1 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        brandLabel = new javax.swing.JLabel();
        colorAndSizeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(java.awt.Color.gray);

        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        imgLabel.setBackground(new java.awt.Color(102, 255, 102));
        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/no-pictures.png"))); // NOI18N

        idLabel.setText("1000000");

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setText("<html><p width=\\\"150px\\\">Name</p></html>");
        nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        genderLabel.setText("Gender");

        priceLabel.setText("Price");

        stockLabel.setText("Stock");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(122, 64));

        editBtn1.setBorder(null);
        editBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil .png"))); // NOI18N
        editBtn1.setBorderColor(new java.awt.Color(255, 255, 255));
        editBtn1.setColorClick(new java.awt.Color(255, 255, 255));
        editBtn1.setColorOver(new java.awt.Color(255, 255, 255));
        editBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn1ActionPerformed(evt);
            }
        });

        deleteBtn1.setBorder(null);
        deleteBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete .png"))); // NOI18N
        deleteBtn1.setBorderColor(new java.awt.Color(255, 255, 255));
        deleteBtn1.setColorClick(new java.awt.Color(255, 255, 255));
        deleteBtn1.setColorOver(new java.awt.Color(255, 255, 255));
        deleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        brandLabel.setText("Brand");

        colorAndSizeLabel.setText("Color | Size");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(checkBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colorAndSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(checkBox)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(stockLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(colorAndSizeLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(genderLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(brandLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn1ActionPerformed
        GlassPanePopup.showPopup(new EditProductPanel(panel, product), "editProduct");
    }//GEN-LAST:event_editBtn1ActionPerformed

    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn1ActionPerformed
        ConfirmPanel.show("Do you want to delete this product?", () -> {
            ProductDAO productDAO = DAOManager.getInstance().getProductDAO();
            productDAO.delete(product.getProductId()).thenAccept((t) -> {
                panel.fetchData();
                GlassPanePopup.closePopup("confirm");
                SuccessPanel.show("Product deleted successfully.");
            });
        });
    }//GEN-LAST:event_deleteBtn1ActionPerformed

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        if (!checkBox.isSelected()) {
            panel.getSelectAllCheckBox().setSelected(false);
            SwingUtilities.updateComponentTreeUI(this);
        } 
        
        boolean flag = false;
        for (ProductPanel productPanel: panel.getCurrentProductPanels()) {
            if (productPanel.getCheckBox().isSelected()) {
                flag = true;
                break;
            }
        }
        if (flag) {
            panel.getDeleteAllBtn().setVisible(true);
        } else {
            panel.getDeleteAllBtn().setVisible(false);
        }
        
        SwingUtilities.updateComponentTreeUI(panel);
    }//GEN-LAST:event_checkBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandLabel;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JLabel colorAndSizeLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomButton deleteBtn1;
    private com.wingman.clothingshopmanagement.view.components.CustomButton editBtn1;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel stockLabel;
    // End of variables declaration//GEN-END:variables
}
