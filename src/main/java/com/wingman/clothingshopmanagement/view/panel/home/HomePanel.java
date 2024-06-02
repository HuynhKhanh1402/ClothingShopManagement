/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.home;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.product.Product;
import com.wingman.clothingshopmanagement.model.product.ProductQuantity;
import com.wingman.clothingshopmanagement.model.user.User;
import com.wingman.clothingshopmanagement.model.user.UserSaleData;
import com.wingman.clothingshopmanagement.util.NumberFormatter;
import com.wingman.clothingshopmanagement.view.MainFrame;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrator
 */
public class HomePanel extends javax.swing.JPanel {

    /**
     * Creates new form HomePanel
     */
    public HomePanel() {
        initComponents();
        fetchData();
    }
    
    private void fetchData() {
        MainFrame.getInstance().getLoading().showLoading();
        
        CompletableFuture.runAsync(() -> {
            DAOManager daoManager = DAOManager.getInstance();
            int totalUsers = daoManager.getUserDAO().getAll().join().size();
            int totalProducts = daoManager.getProductDAO().getAll().join().size();
            int totalOrders = daoManager.getOrderDAO().getAll().join().size();
            long totalOrderedProducts = daoManager.getOrderDetailDAO().getTotalOrderedProduct().join();
            
            totalUsersLabel.setText(NumberFormatter.format(totalUsers));
            totalProductsLabel.setText(NumberFormatter.format(totalProducts));
            totalOrdersLabel.setText(NumberFormatter.format(totalOrders));
            totalOrderedProductsLabel.setText(NumberFormatter.format(totalOrderedProducts));
            
            List<ProductQuantity> topSelling = daoManager.getProductDAO().getTopSellingProducts(3).join();
            if (topSelling.size() >= 1) {
                ProductQuantity pq = topSelling.get(0);
                Product product = pq.getProduct();
                long sold = pq.getTotalQuantity();
                if (product.getProductImage() != null) {
                    productImage1.setImageIcon(product.getProductImage().getImage());
                } else {
                    productImage1.setImageIcon(new ImageIcon(getClass().getResource("/images/no-pictures-larger.png")));
                }
                nameLabel1.setText(String.format("<html><p width=\"250px\">%s</p></html>", product.getName()));
                brandLabel1.setText(String.format("<html><p width=\"120px\"><b>Brand: </b>%s</p></html>", product.getBrand()));
                sizeLabel1.setText(String.format("<html><p width=\"120px\"><b>Size: </b>%s</p></html>", product.getSize()));
                colorLabel1.setText(String.format("<html><p width=\"120px\"><b>Color: </b>%s</p></html>", product.getColor()));
                soldLabel1.setText(String.format("<html><p width=\"120px\"><b>Sold: </b>%s</p></html>", NumberFormatter.format(sold)));
            } else {
                productImage1.setVisible(false);
                nameLabel1.setVisible(false);
                brandLabel1.setVisible(false);
                sizeLabel1.setVisible(false);
                soldLabel1.setVisible(false);
                colorLabel1.setVisible(false);
            }
            
            if (topSelling.size() >= 2) {
                ProductQuantity pq = topSelling.get(1);
                Product product = pq.getProduct();
                long sold = pq.getTotalQuantity();
                if (product.getProductImage() != null) {
                    productImage2.setImageIcon(product.getProductImage().getImage());
                } else {
                    productImage2.setImageIcon(new ImageIcon(getClass().getResource("/images/no-pictures-larger.png")));
                }
                nameLabel2.setText(String.format("<html><p width=\"250px\">%s</p></html>", product.getName()));
                brandLabel2.setText(String.format("<html><p width=\"120px\"><b>Brand: </b>%s</p></html>", product.getBrand()));
                sizeLabel2.setText(String.format("<html><p width=\"120px\"><b>Size: </b>%s</p></html>", product.getSize()));
                colorLabel2.setText(String.format("<html><p width=\"120px\"><b>Color: </b>%s</p></html>", product.getColor()));
                soldLabel2.setText(String.format("<html><p width=\"120px\"><b>Sold: </b>%s</p></html>", NumberFormatter.format(sold)));
            } else {
                productImage2.setVisible(false);
                nameLabel2.setVisible(false);
                brandLabel2.setVisible(false);
                sizeLabel2.setVisible(false);
                soldLabel2.setVisible(false);
                colorLabel2.setVisible(false);
            }
            
            if (topSelling.size() >= 3) {
                ProductQuantity pq = topSelling.get(2);
                Product product = pq.getProduct();
                long sold = pq.getTotalQuantity();
                if (product.getProductImage() != null) {
                    productImage3.setImageIcon(product.getProductImage().getImage());
                } else {
                    productImage3.setImageIcon(new ImageIcon(getClass().getResource("/images/no-pictures-larger.png")));
                }
                nameLabel3.setText(String.format("<html><p width=\"250px\">%s</p></html>", product.getName()));
                brandLabel3.setText(String.format("<html><p width=\"120px\"><b>Brand: </b>%s</p></html>", product.getBrand()));
                sizeLabel3.setText(String.format("<html><p width=\"120px\"><b>Size: </b>%s</p></html>", product.getSize()));
                colorLabel3.setText(String.format("<html><p width=\"120px\"><b>Color: </b>%s</p></html>", product.getColor()));
                soldLabel3.setText(String.format("<html><p width=\"120px\"><b>Sold: </b>%s</p></html>", NumberFormatter.format(sold)));
            } else {
                productImage3.setVisible(false);
                nameLabel3.setVisible(false);
                brandLabel3.setVisible(false);
                sizeLabel3.setVisible(false);
                soldLabel3.setVisible(false);
                colorLabel3.setVisible(false);
            }
            
            List<UserSaleData> topSeller = daoManager.getUserDAO().getTopSeller(3).join();
            if (topSeller.size() >= 1) {
                UserSaleData data = topSeller.get(0);
                User user = data.getUser();
                long soldProducts = data.getSoldProductQty();
                double revenue = data.getRevenue();
                
                if (user.getAvatar() != null) {
                    avatar1.setImageIcon(user.getAvatar().getImage());
                } else {
                    avatar1.setImageIcon(new ImageIcon(getClass().getResource("/images/user_color.png")));
                }
                
                fullNameLabel1.setText(String.format("<html><p width=\"250px\">%s</p></html>", user.getFullName()));
                emailLabel1.setText(String.format("<html><p width=\"250px\">%s</p></html>", user.getEmail()));
                soldProductLabel1.setText(String.format("<html><p width=\"250px\"><b>Sold products: </b>%s</p></html>", NumberFormatter.format(soldProducts)));
                revenueLabel1.setText(String.format("<html><p width=\"250px\"><b>Revenue: </b>%sđ</p></html>", NumberFormatter.format(revenue)));
            } else {
                avatar1.setVisible(false);
                fullNameLabel1.setVisible(false);
                emailLabel1.setVisible(false);
                soldProductLabel1.setVisible(false);
                revenueLabel1.setVisible(false);
            }
            
            if (topSeller.size() >= 2) {
                UserSaleData data = topSeller.get(1);
                User user = data.getUser();
                long soldProducts = data.getSoldProductQty();
                double revenue = data.getRevenue();
                
                if (user.getAvatar() != null) {
                    avatar2.setImageIcon(user.getAvatar().getImage());
                } else {
                    avatar2.setImageIcon(new ImageIcon(getClass().getResource("/images/user_color.png")));
                }
                
                fullNameLabel2.setText(String.format("<html><p width=\"250px\">%s</p></html>", user.getFullName()));
                emailLabel2.setText(String.format("<html><p width=\"250px\">%s</p></html>", user.getEmail()));
                soldProductLabel2.setText(String.format("<html><p width=\"250px\"><b>Sold products: </b>%s</p></html>", NumberFormatter.format(soldProducts)));
                revenueLabel2.setText(String.format("<html><p width=\"250px\"><b>Revenue: </b>%sđ</p></html>", NumberFormatter.format(revenue)));
            } else {
                avatar2.setVisible(false);
                fullNameLabel2.setVisible(false);
                emailLabel2.setVisible(false);
                soldProductLabel2.setVisible(false);
                revenueLabel2.setVisible(false);
            }
            
            if (topSeller.size() >= 3) {
                UserSaleData data = topSeller.get(2);
                User user = data.getUser();
                long soldProducts = data.getSoldProductQty();
                double revenue = data.getRevenue();
                
                if (user.getAvatar() != null) {
                    avatar3.setImageIcon(user.getAvatar().getImage());
                } else {
                    avatar3.setImageIcon(new ImageIcon(getClass().getResource("/images/user_color.png")));
                }
                
                fullNameLabel3.setText(String.format("<html><p width=\"250px\">%s</p></html>", user.getFullName()));
                emailLabel3.setText(String.format("<html><p width=\"250px\">%s</p></html>", user.getEmail()));
                soldProductLabel3.setText(String.format("<html><p width=\"250px\"><b>Sold products: </b>%s</p></html>", NumberFormatter.format(soldProducts)));
                revenueLabel3.setText(String.format("<html><p width=\"250px\"><b>Revenue: </b>%sđ</p></html>", NumberFormatter.format(revenue)));
            } else {
                avatar3.setVisible(false);
                fullNameLabel3.setVisible(false);
                emailLabel3.setVisible(false);
                soldProductLabel3.setVisible(false);
                revenueLabel3.setVisible(false);
            }
        }).whenComplete((t, u) -> {
            MainFrame.getInstance().getLoading().hideLoading();
            SwingUtilities.updateComponentTreeUI(this);
            if (u != null) {
                u.printStackTrace();
                throw new RuntimeException(u);
            }
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

        customPanel1 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        totalUsersLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customPanel2 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        totalProductsLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        customPanel3 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        totalOrdersLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        customPanel4 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        totalOrderedProductsLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        customPanel5 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        jLabel13 = new javax.swing.JLabel();
        productImage1 = new com.wingman.clothingshopmanagement.view.components.ImagePanel();
        productImage2 = new com.wingman.clothingshopmanagement.view.components.ImagePanel();
        productImage3 = new com.wingman.clothingshopmanagement.view.components.ImagePanel();
        nameLabel1 = new javax.swing.JLabel();
        brandLabel1 = new javax.swing.JLabel();
        sizeLabel1 = new javax.swing.JLabel();
        colorLabel1 = new javax.swing.JLabel();
        soldLabel1 = new javax.swing.JLabel();
        nameLabel2 = new javax.swing.JLabel();
        brandLabel2 = new javax.swing.JLabel();
        sizeLabel2 = new javax.swing.JLabel();
        soldLabel2 = new javax.swing.JLabel();
        colorLabel2 = new javax.swing.JLabel();
        nameLabel3 = new javax.swing.JLabel();
        brandLabel3 = new javax.swing.JLabel();
        sizeLabel3 = new javax.swing.JLabel();
        soldLabel3 = new javax.swing.JLabel();
        colorLabel3 = new javax.swing.JLabel();
        customPanel6 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        jLabel14 = new javax.swing.JLabel();
        avatar1 = new com.wingman.clothingshopmanagement.view.components.ImagePanel();
        avatar2 = new com.wingman.clothingshopmanagement.view.components.ImagePanel();
        avatar3 = new com.wingman.clothingshopmanagement.view.components.ImagePanel();
        fullNameLabel1 = new javax.swing.JLabel();
        emailLabel1 = new javax.swing.JLabel();
        soldProductLabel1 = new javax.swing.JLabel();
        revenueLabel1 = new javax.swing.JLabel();
        fullNameLabel2 = new javax.swing.JLabel();
        emailLabel2 = new javax.swing.JLabel();
        soldProductLabel2 = new javax.swing.JLabel();
        revenueLabel2 = new javax.swing.JLabel();
        fullNameLabel3 = new javax.swing.JLabel();
        emailLabel3 = new javax.swing.JLabel();
        soldProductLabel3 = new javax.swing.JLabel();
        revenueLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 243, 243));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customPanel1.setBorderColor(new java.awt.Color(255, 255, 255));
        customPanel1.setRadius(20);

        totalUsersLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        totalUsersLabel.setForeground(new java.awt.Color(75, 3, 163));
        totalUsersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalUsersLabel.setText("10");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USERS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(132, 55, 225));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Qty");

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(totalUsersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUsersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(customPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 24, -1, -1));

        customPanel2.setBorderColor(new java.awt.Color(255, 255, 255));
        customPanel2.setRadius(20);

        totalProductsLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        totalProductsLabel.setForeground(new java.awt.Color(75, 3, 163));
        totalProductsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalProductsLabel.setText("10");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PRODUCTS");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(132, 55, 225));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Qty");

        javax.swing.GroupLayout customPanel2Layout = new javax.swing.GroupLayout(customPanel2);
        customPanel2.setLayout(customPanel2Layout);
        customPanel2Layout.setHorizontalGroup(
            customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(totalProductsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customPanel2Layout.setVerticalGroup(
            customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalProductsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(customPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 24, -1, -1));

        customPanel3.setBorderColor(new java.awt.Color(255, 255, 255));
        customPanel3.setRadius(20);

        totalOrdersLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        totalOrdersLabel.setForeground(new java.awt.Color(75, 3, 163));
        totalOrdersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOrdersLabel.setText("10");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(32, 32, 32));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ORDERS");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(132, 55, 225));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Qty");

        javax.swing.GroupLayout customPanel3Layout = new javax.swing.GroupLayout(customPanel3);
        customPanel3.setLayout(customPanel3Layout);
        customPanel3Layout.setHorizontalGroup(
            customPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(totalOrdersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customPanel3Layout.setVerticalGroup(
            customPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalOrdersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(customPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 24, -1, -1));

        customPanel4.setBorderColor(new java.awt.Color(255, 255, 255));
        customPanel4.setRadius(20);

        totalOrderedProductsLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        totalOrderedProductsLabel.setForeground(new java.awt.Color(75, 3, 163));
        totalOrderedProductsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOrderedProductsLabel.setText("10");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(32, 32, 32));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ORDERED PRODUCTS");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(132, 55, 225));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Qty");

        javax.swing.GroupLayout customPanel4Layout = new javax.swing.GroupLayout(customPanel4);
        customPanel4.setLayout(customPanel4Layout);
        customPanel4Layout.setHorizontalGroup(
            customPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(totalOrderedProductsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customPanel4Layout.setVerticalGroup(
            customPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalOrderedProductsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(customPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 24, -1, -1));

        customPanel5.setBorderColor(new java.awt.Color(255, 255, 255));
        customPanel5.setRadius(16);
        customPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(132, 55, 225));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("TOP SELLING");
        customPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 406, -1));

        productImage1.setRadius(16);

        javax.swing.GroupLayout productImage1Layout = new javax.swing.GroupLayout(productImage1);
        productImage1.setLayout(productImage1Layout);
        productImage1Layout.setHorizontalGroup(
            productImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        productImage1Layout.setVerticalGroup(
            productImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        customPanel5.add(productImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 43, -1, -1));

        productImage2.setRadius(16);

        javax.swing.GroupLayout productImage2Layout = new javax.swing.GroupLayout(productImage2);
        productImage2.setLayout(productImage2Layout);
        productImage2Layout.setHorizontalGroup(
            productImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        productImage2Layout.setVerticalGroup(
            productImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        customPanel5.add(productImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 161, -1, -1));

        productImage3.setRadius(16);

        javax.swing.GroupLayout productImage3Layout = new javax.swing.GroupLayout(productImage3);
        productImage3.setLayout(productImage3Layout);
        productImage3Layout.setHorizontalGroup(
            productImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        productImage3Layout.setVerticalGroup(
            productImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        customPanel5.add(productImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 279, -1, -1));

        nameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel1.setText("Name");
        nameLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        customPanel5.add(nameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 43, 290, 40));

        brandLabel1.setText("Brand:");
        customPanel5.add(brandLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 130, -1));

        sizeLabel1.setText("Size:");
        customPanel5.add(sizeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 160, -1));

        colorLabel1.setText("Color: ");
        customPanel5.add(colorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 120, -1));

        soldLabel1.setText("Sold");
        customPanel5.add(soldLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 160, -1));

        nameLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel2.setText("Name");
        nameLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        customPanel5.add(nameLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 290, 40));

        brandLabel2.setText("Brand:");
        customPanel5.add(brandLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 130, -1));

        sizeLabel2.setText("Size:");
        customPanel5.add(sizeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 160, -1));

        soldLabel2.setText("Sold");
        customPanel5.add(soldLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 160, -1));

        colorLabel2.setText("Color: ");
        customPanel5.add(colorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 120, -1));

        nameLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel3.setText("Name");
        nameLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        customPanel5.add(nameLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 290, 40));

        brandLabel3.setText("Brand:");
        customPanel5.add(brandLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 130, -1));

        sizeLabel3.setText("Size:");
        customPanel5.add(sizeLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 160, -1));

        soldLabel3.setText("Stock: ");
        customPanel5.add(soldLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 160, -1));

        colorLabel3.setText("Color: ");
        customPanel5.add(colorLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 120, -1));

        add(customPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 220, 418, 390));

        customPanel6.setBorderColor(new java.awt.Color(255, 255, 255));
        customPanel6.setRadius(16);
        customPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(132, 55, 225));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("TOP SELLER");
        customPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 406, -1));

        avatar1.setBackground(new java.awt.Color(230, 230, 230));
        avatar1.setRadius(100);

        javax.swing.GroupLayout avatar1Layout = new javax.swing.GroupLayout(avatar1);
        avatar1.setLayout(avatar1Layout);
        avatar1Layout.setHorizontalGroup(
            avatar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        avatar1Layout.setVerticalGroup(
            avatar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        customPanel6.add(avatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 43, 100, 100));

        avatar2.setRadius(100);

        javax.swing.GroupLayout avatar2Layout = new javax.swing.GroupLayout(avatar2);
        avatar2.setLayout(avatar2Layout);
        avatar2Layout.setHorizontalGroup(
            avatar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        avatar2Layout.setVerticalGroup(
            avatar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        customPanel6.add(avatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 161, -1, -1));

        avatar3.setRadius(100);

        javax.swing.GroupLayout avatar3Layout = new javax.swing.GroupLayout(avatar3);
        avatar3.setLayout(avatar3Layout);
        avatar3Layout.setHorizontalGroup(
            avatar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        avatar3Layout.setVerticalGroup(
            avatar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        customPanel6.add(avatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 279, -1, -1));

        fullNameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullNameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fullNameLabel1.setText("Full Name");
        customPanel6.add(fullNameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 290, 40));

        emailLabel1.setText("Email");
        customPanel6.add(emailLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 290, -1));

        soldProductLabel1.setText("Sold product: ");
        customPanel6.add(soldProductLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 290, -1));

        revenueLabel1.setText("Revenue");
        customPanel6.add(revenueLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 290, -1));

        fullNameLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullNameLabel2.setText("Full Name");
        customPanel6.add(fullNameLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 290, 40));

        emailLabel2.setText("Email");
        customPanel6.add(emailLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 290, -1));

        soldProductLabel2.setText("Sold product: ");
        customPanel6.add(soldProductLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 290, -1));

        revenueLabel2.setText("Revenue");
        customPanel6.add(revenueLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 290, -1));

        fullNameLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullNameLabel3.setText("Full Name");
        fullNameLabel3.setToolTipText("");
        customPanel6.add(fullNameLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 290, 40));

        emailLabel3.setText("Email");
        customPanel6.add(emailLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 290, -1));

        soldProductLabel3.setText("Sold product: ");
        customPanel6.add(soldProductLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 290, -1));

        revenueLabel3.setText("Revenue");
        customPanel6.add(revenueLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 290, -1));

        add(customPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 218, 418, 390));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.ImagePanel avatar1;
    private com.wingman.clothingshopmanagement.view.components.ImagePanel avatar2;
    private com.wingman.clothingshopmanagement.view.components.ImagePanel avatar3;
    private javax.swing.JLabel brandLabel1;
    private javax.swing.JLabel brandLabel2;
    private javax.swing.JLabel brandLabel3;
    private javax.swing.JLabel colorLabel1;
    private javax.swing.JLabel colorLabel2;
    private javax.swing.JLabel colorLabel3;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel1;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel2;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel3;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel4;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel5;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel6;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JLabel emailLabel2;
    private javax.swing.JLabel emailLabel3;
    private javax.swing.JLabel fullNameLabel1;
    private javax.swing.JLabel fullNameLabel2;
    private javax.swing.JLabel fullNameLabel3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JLabel nameLabel3;
    private com.wingman.clothingshopmanagement.view.components.ImagePanel productImage1;
    private com.wingman.clothingshopmanagement.view.components.ImagePanel productImage2;
    private com.wingman.clothingshopmanagement.view.components.ImagePanel productImage3;
    private javax.swing.JLabel revenueLabel1;
    private javax.swing.JLabel revenueLabel2;
    private javax.swing.JLabel revenueLabel3;
    private javax.swing.JLabel sizeLabel1;
    private javax.swing.JLabel sizeLabel2;
    private javax.swing.JLabel sizeLabel3;
    private javax.swing.JLabel soldLabel1;
    private javax.swing.JLabel soldLabel2;
    private javax.swing.JLabel soldLabel3;
    private javax.swing.JLabel soldProductLabel1;
    private javax.swing.JLabel soldProductLabel2;
    private javax.swing.JLabel soldProductLabel3;
    private javax.swing.JLabel totalOrderedProductsLabel;
    private javax.swing.JLabel totalOrdersLabel;
    private javax.swing.JLabel totalProductsLabel;
    private javax.swing.JLabel totalUsersLabel;
    // End of variables declaration//GEN-END:variables
}
