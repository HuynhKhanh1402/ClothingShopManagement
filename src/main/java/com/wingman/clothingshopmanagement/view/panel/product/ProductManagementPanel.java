/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.product;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.ProductDAO;
import com.wingman.clothingshopmanagement.model.product.Product;
import com.wingman.clothingshopmanagement.view.MainFrame;
import com.wingman.clothingshopmanagement.view.panel.message.ConfirmPanel;
import com.wingman.clothingshopmanagement.view.panel.message.SuccessPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import lombok.Getter;
import raven.glasspanepopup.GlassPanePopup;


@Getter
public class ProductManagementPanel extends javax.swing.JPanel {

    private final List<Product> cachedProducts = new ArrayList<>();
    private final List<ProductPanel> currentProductPanels = new ArrayList<>();

    /**
     * Creates new form ProductManagementPanel
     */
    public ProductManagementPanel() {
        initComponents();
        fetchData();

        searchBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });
        
        deleteAllBtn.setVisible(false);
        
        setScrollSpeed(20);
    }
    
    private  void setScrollSpeed(int speed) {
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(speed);
    }

    public final void fetchData() {
        jPanel2.removeAll();
        cachedProducts.clear();
        
        selectAllCheckBox.setSelected(false);

        MainFrame.getInstance().getLoading().showLoading();

        ProductDAO productDAO = DAOManager.getInstance().getProductDAO();
        productDAO.getAll().thenAccept((t) -> {
            cachedProducts.addAll(t);
            displayProducts(OrderBy.ID, "", false);
        }).whenComplete((t, u) -> {
            MainFrame.getInstance().getLoading().hideLoading();
            if (u != null) {
                u.printStackTrace();
                throw new RuntimeException(u);
            }
        });
    }

    private void displayProducts(OrderBy order, String filter, boolean reverse) {
        String lowercasedFilter = filter.toLowerCase();
        List<Product> products = new ArrayList<>();

        jPanel2.removeAll();
        jPanel2.setPreferredSize(new Dimension(jPanel2.getWidth(), 0));

        for (Product product : cachedProducts) {
            if (String.valueOf(product.getProductId()).contains(lowercasedFilter)
                    || product.getName().toLowerCase().contains(lowercasedFilter)
                    || product.getBrand().toLowerCase().contains(lowercasedFilter)
                    || product.getSize().toLowerCase().contains(lowercasedFilter)
                    || product.getColor().toLowerCase().contains(lowercasedFilter)
                    || String.valueOf(product.getStock()).contains(lowercasedFilter)) {
                products.add(product);
            }
        }

        products.sort((o1, o2) -> {
            return switch (order) {
                case ID ->
                    Long.compare(o1.getProductId(), o2.getProductId());
                case NAME ->
                    o1.getName().compareTo(o2.getName());
                case BRAND ->
                    o1.getBrand().compareTo(o2.getBrand());
                case GENDER ->
                    o1.getGender().toString().compareTo(o2.getGender().toString());
                case STOCK ->
                    Integer.compare(o1.getStock(), o2.getStock());
                default ->
                    Long.compare(o1.getProductId(), o2.getProductId());
            };
        });

        if (reverse) {
            Collections.reverse(products);
        }

        currentProductPanels.clear();
        for (Product product : products) {
            ProductPanel productPanel = new ProductPanel(this, product);
            addProductPanel(productPanel);
            currentProductPanels.add(productPanel);
        }

        SwingUtilities.invokeLater(() -> {
            SwingUtilities.updateComponentTreeUI(this);
        });
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
        customButton1 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        orderByDropbox = new com.wingman.clothingshopmanagement.view.components.CustomComboBox();
        searchBox = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        jPanel1 = new javax.swing.JPanel();
        selectAllCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        deleteAllBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customToggleButton1 = new com.wingman.clothingshopmanagement.view.components.CustomToggleButton();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Product Management");
        jLabel1.setPreferredSize(new java.awt.Dimension(75, 32));

        customButton1.setBackground(new java.awt.Color(125, 44, 224));
        customButton1.setForeground(new java.awt.Color(255, 255, 255));
        customButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        customButton1.setText("Add product");
        customButton1.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton1.setColor(new java.awt.Color(125, 44, 224));
        customButton1.setColorClick(new java.awt.Color(75, 3, 163));
        customButton1.setColorOver(new java.awt.Color(96, 33, 173));
        customButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customButton1.setPreferredSize(new java.awt.Dimension(135, 32));
        customButton1.setRadius(16);
        customButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton1ActionPerformed(evt);
            }
        });

        orderByDropbox.setBackground(new java.awt.Color(207, 177, 242));
        orderByDropbox.setForeground(new java.awt.Color(107, 46, 182));
        orderByDropbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Order by", "ID", "Name", "Brand", "Gender", "Stock" }));
        orderByDropbox.setToolTipText("");
        orderByDropbox.setBorderColor(new java.awt.Color(207, 177, 242));
        orderByDropbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderByDropbox.setRadius(16);
        orderByDropbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderByDropboxActionPerformed(evt);
            }
        });

        searchBox.setBoderColor(new java.awt.Color(125, 44, 224));
        searchBox.setHint("Search");
        searchBox.setPreferredSize(new java.awt.Dimension(64, 32));
        searchBox.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-interface-symbol.png"))); // NOI18N
        searchBox.setRadius(16);
        searchBox.setSelectionColor(new java.awt.Color(155, 50, 255));
        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        selectAllCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllCheckBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.gray);
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.gray);
        jLabel5.setText("Brand");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.gray);
        jLabel6.setText("Gender");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.gray);
        jLabel7.setText("Price");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.gray);
        jLabel8.setText("Stock");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(selectAllCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectAllCheckBox))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(971, 515));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(971, 515));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(971, 515));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(971, 515));
        jPanel2.setMinimumSize(new java.awt.Dimension(971, 515));
        jScrollPane1.setViewportView(jPanel2);

        deleteAllBtn.setBackground(java.awt.Color.red);
        deleteAllBtn.setForeground(java.awt.Color.white);
        deleteAllBtn.setText("Delete selected products");
        deleteAllBtn.setBorderColor(java.awt.Color.red);
        deleteAllBtn.setColor(new java.awt.Color(255, 0, 0));
        deleteAllBtn.setColorClick(new java.awt.Color(139, 0, 0));
        deleteAllBtn.setColorOver(new java.awt.Color(220, 20, 60));
        deleteAllBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteAllBtn.setRadius(16);
        deleteAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllBtnActionPerformed(evt);
            }
        });

        customToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sort-asc.png"))); // NOI18N
        customToggleButton1.setBorderColor(new java.awt.Color(125, 44, 224));
        customToggleButton1.setContentAreaFilled(false);
        customToggleButton1.setRadius(16);
        customToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sort-des.png"))); // NOI18N
        customToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customToggleButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Add, edit, delete product here.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderByDropbox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(orderByDropbox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectAllCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllCheckBoxActionPerformed
        boolean isSelected = selectAllCheckBox.isSelected();
        
        if (isSelected && !currentProductPanels.isEmpty()) {
            deleteAllBtn.setVisible(true);
        } else if (!isSelected) {
            deleteAllBtn.setVisible(false);
        }
        
        for (ProductPanel panel : currentProductPanels) {
            panel.getCheckBox().setSelected(isSelected);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_selectAllCheckBoxActionPerformed

    private void customButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton1ActionPerformed
        GlassPanePopup.showPopup(new AddProductPanel(this), "addProduct");
    }//GEN-LAST:event_customButton1ActionPerformed

    private void orderByDropboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByDropboxActionPerformed
        search();
    }//GEN-LAST:event_orderByDropboxActionPerformed

    private void customToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customToggleButton1ActionPerformed
        search();
    }//GEN-LAST:event_customToggleButton1ActionPerformed

    private void deleteAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllBtnActionPerformed
        ConfirmPanel.show("Do you want to delete this product?", () -> {
            ProductDAO productDAO = DAOManager.getInstance().getProductDAO();

            List<CompletableFuture<Void>> tasks = new ArrayList<>();
            for (ProductPanel productPanel : currentProductPanels) {
                if (productPanel.getCheckBox().isSelected()) {
                    tasks.add(productDAO.delete(productPanel.getProduct().getProductId()));
                }
            }

            MainFrame.getInstance().getLoading().showLoading();

            CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)).thenAccept((t) -> {
                fetchData();
                MainFrame.getInstance().getLoading().hideLoading();
                SuccessPanel.show("Deleted all selected products.");
            }).whenComplete((t, u) -> {
                MainFrame.getInstance().getLoading().hideLoading();
                if (u != null) {
                    u.printStackTrace();
                    throw new RuntimeException(u);
                }
            });
        });
    }//GEN-LAST:event_deleteAllBtnActionPerformed

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxActionPerformed

    private void addProductPanel(JPanel panel) {
        jPanel2.add(panel);

        int width = (int) jPanel2.getPreferredSize().getWidth();
        int height = (int) jPanel2.getPreferredSize().getHeight();

        height += panel.getPreferredSize().getHeight();

        jPanel2.setPreferredSize(new Dimension(width, height));
    }

    private void search() {
        if (orderByDropbox.getSelectedIndex() == 0) {
            displayProducts(OrderBy.ID, searchBox.getText(), customToggleButton1.isSelected());
        } else {
            displayProducts(OrderBy.valueOf(String.valueOf(orderByDropbox.getSelectedItem()).toUpperCase()), searchBox.getText(), customToggleButton1.isSelected());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton1;
    private com.wingman.clothingshopmanagement.view.components.CustomToggleButton customToggleButton1;
    private com.wingman.clothingshopmanagement.view.components.CustomButton deleteAllBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.wingman.clothingshopmanagement.view.components.CustomComboBox orderByDropbox;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField searchBox;
    private javax.swing.JCheckBox selectAllCheckBox;
    // End of variables declaration//GEN-END:variables
}
