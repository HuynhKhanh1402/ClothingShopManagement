/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.product;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.ImageDAO;
import com.wingman.clothingshopmanagement.model.dao.ProductDAO;
import com.wingman.clothingshopmanagement.model.image.Image;
import com.wingman.clothingshopmanagement.model.product.Gender;
import com.wingman.clothingshopmanagement.model.product.Product;
import com.wingman.clothingshopmanagement.util.DateFormatter;
import com.wingman.clothingshopmanagement.util.ImageUtil;
import com.wingman.clothingshopmanagement.view.MainFrame;
import com.wingman.clothingshopmanagement.view.components.CustomTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class EditProductPanel extends javax.swing.JPanel {

    private final JDialog parent;
    private final ProductManagementPanel panel;
    private final Product product;
    private boolean isChangedImage;

    /**
     * Creates new form EditProductPanel
     * @param dialog
     * @param panel
     * @param product
     */
    public EditProductPanel(JDialog dialog, ProductManagementPanel panel, Product product) {
        initComponents();
        this.parent = dialog;
        this.panel = panel;
        this.product = product;
        
        initProductInfo();
    }
    
    private void initProductInfo() {
        if (product.getProductImage() == null) {
            productImage.setIcon(ImageUtil.resize(new ImageIcon(getClass().getResource("/images/no-pictures-larger.png")), 150, 162));
        } else {
            Image image = product.getProductImage();
            productImage.setIcon(ImageUtil.resize(image.getImage(), 150, 162));
        }
        isChangedImage = false;
        
        nameTextField.setText(product.getName());
        priceTextField.setText(String.valueOf(product.getPrice()));
        stockTextField.setText(String.valueOf(product.getStock()));
        brandTextField.setText(product.getBrand());
        sizeTextField.setText(product.getSize());
        colorTextField.setText(product.getColor());
        genderDropdown.setSelectedItem(product.getGender().getValue());
        description.setText(product.getDesciption());
        addedByLabel.setText("Added by: " + (product.getAddedBy() != null ? product.getAddedBy().getEmail() : "No data"));
        addedDateLabel.setText("Added date: " + DateFormatter.formatDateAndTime(product.getAddedDate()));
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
        nameLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();
        brandLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        colorLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        productImage = new javax.swing.JLabel();
        chooseImgBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        descriptionLabel = new javax.swing.JLabel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        cancelBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        createBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        nameTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        stockTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        brandTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        sizeTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        colorTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        priceTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        genderDropdown = new com.wingman.clothingshopmanagement.view.components.CustomComboBox();
        addedByLabel = new javax.swing.JLabel();
        addedDateLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(51, 3, 0));
        nameLabel.setText("Name");

        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(51, 3, 0));
        priceLabel.setText("Price");

        stockLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stockLabel.setForeground(new java.awt.Color(51, 3, 0));
        stockLabel.setText("Stock");

        brandLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        brandLabel.setForeground(new java.awt.Color(51, 3, 0));
        brandLabel.setText("Brand");

        sizeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sizeLabel.setForeground(new java.awt.Color(51, 3, 0));
        sizeLabel.setText("Size");

        colorLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorLabel.setForeground(new java.awt.Color(51, 3, 0));
        colorLabel.setText("Color");

        genderLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(51, 3, 0));
        genderLabel.setText("Gender");

        productImage.setPreferredSize(null);

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

        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(51, 3, 0));
        descriptionLabel.setText("Description");

        description.setColumns(20);
        description.setRows(5);
        descriptionScrollPane.setViewportView(description);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        createBtn.setBackground(new java.awt.Color(125, 44, 224));
        createBtn.setForeground(new java.awt.Color(255, 255, 255));
        createBtn.setText("Save");
        createBtn.setBorderColor(new java.awt.Color(125, 44, 224));
        createBtn.setColor(new java.awt.Color(125, 44, 224));
        createBtn.setColorClick(new java.awt.Color(75, 3, 163));
        createBtn.setColorOver(new java.awt.Color(96, 33, 173));
        createBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        createBtn.setRadius(12);
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74)
                .addComponent(createBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(createBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        nameTextField.setBorder(null);
        nameTextField.setBoderColor(java.awt.Color.lightGray);
        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nameTextField.setPreferredSize(new java.awt.Dimension(320, 28));
        nameTextField.setRadius(12);

        stockTextField.setBorder(null);
        stockTextField.setBoderColor(java.awt.Color.lightGray);
        stockTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        stockTextField.setPreferredSize(new java.awt.Dimension(320, 22));
        stockTextField.setRadius(12);
        stockTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTextFieldActionPerformed(evt);
            }
        });

        brandTextField.setBorder(null);
        brandTextField.setBoderColor(java.awt.Color.lightGray);
        brandTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        brandTextField.setPreferredSize(new java.awt.Dimension(320, 22));
        brandTextField.setRadius(12);
        brandTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandTextFieldActionPerformed(evt);
            }
        });

        sizeTextField.setBorder(null);
        sizeTextField.setBoderColor(java.awt.Color.lightGray);
        sizeTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        sizeTextField.setPreferredSize(new java.awt.Dimension(320, 22));
        sizeTextField.setRadius(12);
        sizeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeTextFieldActionPerformed(evt);
            }
        });

        colorTextField.setBorder(null);
        colorTextField.setBoderColor(java.awt.Color.lightGray);
        colorTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        colorTextField.setPreferredSize(new java.awt.Dimension(320, 22));
        colorTextField.setRadius(12);
        colorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorTextFieldActionPerformed(evt);
            }
        });

        priceTextField.setBorder(null);
        priceTextField.setBoderColor(java.awt.Color.lightGray);
        priceTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        priceTextField.setPreferredSize(new java.awt.Dimension(320, 22));
        priceTextField.setRadius(12);
        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });

        genderDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unisex", "Male", "Female" }));
        genderDropdown.setBorderColor(java.awt.Color.lightGray);
        genderDropdown.setRadius(12);

        addedByLabel.setText("Added by: {added_by}");

        addedDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addedDateLabel.setText("Added date: {added_date}");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chooseImgBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(brandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(brandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(stockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(stockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(sizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(colorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(genderDropdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(descriptionLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(descriptionScrollPane)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addedByLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addedDateLabel)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceLabel)
                            .addComponent(stockLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(brandLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(brandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(sizeLabel)))
                    .addComponent(productImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chooseImgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(colorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(colorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(descriptionLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(genderLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genderDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addedByLabel)
                    .addComponent(addedDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chooseImgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgBtnActionPerformed
        //        JFileChooser fileChooser = new JFileChooser();
        //        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            //            "Image files", "jpg", "jpeg", "png", "gif");
        //        fileChooser.setFileFilter(filter);
        //
        //        int result = fileChooser.showOpenDialog(this);
        //        if (result == JFileChooser.APPROVE_OPTION) {
            //            File selectedFile = fileChooser.getSelectedFile();
            //            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            //            imgLabel.setIcon(ImageUtil.resize(imageIcon, 166, 166));
            //            isChangedAvatar = true;
            //        }
    }//GEN-LAST:event_chooseImgBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        //        parent.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        resetBorder(nameTextField);
        resetBorder(priceTextField);
        resetBorder(stockTextField);
        resetBorder(brandTextField);
        resetBorder(sizeTextField);
        resetBorder(colorTextField);

        if (!validdateTextField(nameTextField, "Product's name is empty!")) {
            return;
        }

        if (!validdateTextField(priceTextField, "Product's price is empty!")) {
            return;
        }

        if (!validdateTextField(stockTextField, "Product's stock is empty!")) {
            return;
        }

        if (!validdateTextField(brandTextField, "Product's brand is empty!")) {
            return;
        }

        if (!validdateTextField(sizeTextField, "Product's size is empty!")) {
            return;
        }

        if (!validdateTextField(colorTextField, "Product's color is empty!")) {
            return;
        }

        if (!validdateNumberField(priceTextField, false, "{number} is invalid number for product  price!")) {
            return;
        }

        if (!validdateNumberField(stockTextField, true, "{number} is invalid number for product  stock!")) {
            return;
        }

        product.setName(nameTextField.getText());
        product.setPrice(Double.parseDouble(priceTextField.getText()));
        product.setStock(Integer.parseInt(stockTextField.getText()));
        product.setBrand(brandTextField.getText());
        product.setSize(sizeTextField.getText());
        product.setColor(colorTextField.getText());
        product.setGender(Gender.valueOf(((String) genderDropdown.getSelectedItem()).toUpperCase()));
        product.setDesciption(description.getText());
        
        ProductDAO productDAO = DAOManager.getInstance().getProductDAO();
        ImageDAO imageDAO = DAOManager.getInstance().getImageDAO();
        
        MainFrame.getInstance().getLoading().showLoading();
        
        productDAO.update(product).thenAcceptAsync((t) -> {
            if (isChangedImage) {
                if (product.getProductId() == null) {
                    Image image = new Image();
                    image.setImage((ImageIcon) productImage.getIcon());
                    imageDAO.save(image).join();
                    product.setProductImage(image);
                } else {
                    Image image = product.getProductImage();
                    image.setImage((ImageIcon) productImage.getIcon());
                    imageDAO.update(image).join();
                    product.setProductImage(image);
                }
                productDAO.update(product).join();
            }
            JOptionPane.showMessageDialog(this, "Product saved successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        }).whenComplete((t, u) -> {
            MainFrame.getInstance().getLoading().hideLoading();
            parent.dispose();
            panel.prepareData();
            if (u != null) {
                u.printStackTrace();
                throw new RuntimeException(u);
            }
        });
        

    }//GEN-LAST:event_createBtnActionPerformed

    private void stockTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTextFieldActionPerformed

    private void brandTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandTextFieldActionPerformed

    private void sizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeTextFieldActionPerformed

    private void colorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorTextFieldActionPerformed

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void resetBorder(CustomTextField textField) {
        textField.setBoderColor(Color.LIGHT_GRAY);
    }

    private boolean validdateTextField(JTextField field, String message) {
        if (field.getText().isBlank()) {
            if (field instanceof CustomTextField ctf) {
                ctf.setBoderColor(Color.RED);
            }
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validdateNumberField(JTextField field, boolean isInteger, String message) {
        String text = field.getText();

        if (isInteger) {
            try {
                Integer.valueOf(text);
                return true;
            } catch (NumberFormatException e) {
                if (field instanceof CustomTextField ctf) {
                    ctf.setBoderColor(Color.RED);
                }
                JOptionPane.showMessageDialog(this, message.replace("{number}", text), "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } else {
            try {
                Double.valueOf(text);
                return true;
            } catch (NumberFormatException e) {
                if (field instanceof CustomTextField ctf) {
                    ctf.setBoderColor(Color.RED);
                }
                JOptionPane.showMessageDialog(this, message.replace("{number}", text), "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addedByLabel;
    private javax.swing.JLabel addedDateLabel;
    private javax.swing.JLabel brandLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField brandTextField;
    private com.wingman.clothingshopmanagement.view.components.CustomButton cancelBtn;
    private com.wingman.clothingshopmanagement.view.components.CustomButton chooseImgBtn;
    private javax.swing.JLabel colorLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField colorTextField;
    private com.wingman.clothingshopmanagement.view.components.CustomButton createBtn;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private com.wingman.clothingshopmanagement.view.components.CustomComboBox genderDropdown;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nameLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField nameTextField;
    private javax.swing.JLabel priceLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField priceTextField;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel sizeLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField sizeTextField;
    private javax.swing.JLabel stockLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField stockTextField;
    // End of variables declaration//GEN-END:variables
}
