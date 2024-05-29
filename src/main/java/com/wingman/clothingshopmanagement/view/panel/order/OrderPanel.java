/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.order;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.OrderDAO;
import com.wingman.clothingshopmanagement.model.dao.OrderDetailDAO;
import com.wingman.clothingshopmanagement.model.order.Order;
import com.wingman.clothingshopmanagement.model.order.OrderDetail;
import com.wingman.clothingshopmanagement.model.order.OrderProduct;
import com.wingman.clothingshopmanagement.model.product.Product;
import com.wingman.clothingshopmanagement.util.ImageUtil;
import com.wingman.clothingshopmanagement.util.NumberFormatter;
import com.wingman.clothingshopmanagement.view.MainFrame;
import com.wingman.clothingshopmanagement.view.components.CustomPanel;
import com.wingman.clothingshopmanagement.view.panel.message.ConfirmPanel;
import com.wingman.clothingshopmanagement.view.panel.message.SuccessPanel;
import com.wingman.clothingshopmanagement.view.panel.message.WarningPanel;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author Administrator
 */
@Getter
public class OrderPanel extends CustomPanel {

    private final Map<Long, OrderProduct> orderProductMap = new HashMap<>();

    /**
     * Creates new form OrderPanel
     */
    public OrderPanel() {
        initComponents();

        jTable1.setRowHeight(64);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            if (i == 0 || i == 2) {
                continue;
            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void addProduct(OrderProduct orderProduct) {
        Product product = orderProduct.getProduct();
        double price = orderProduct.getUnitPrice();
        int quantity = orderProduct.getQuantity();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        ImageIcon rawImage = product.getProductImage() != null
                ? product.getProductImage().getImage()
                : new ImageIcon(getClass().getResource("/images/no-pictures.png"));
        ImageIcon image = ImageUtil.resize(rawImage, 64, 64);

        long id = product.getProductId();
        String name = product.getName();
        String size = product.getSize();
        String color = product.getColor();
        double total = price * quantity;

        model.addRow(new Object[]{image, id, name, size, color, NumberFormatter.format(price), quantity, NumberFormatter.format(total)});
        orderProductMap.put(id, orderProduct);

        calculateTotalPrice();
    }

    public void changeProduct(OrderProduct from, OrderProduct to) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int row = 0; row < model.getRowCount(); row++) {
            if ((long) model.getValueAt(row, 1) == from.getProduct().getProductId()) {
                Product product = to.getProduct();
                double price = to.getUnitPrice();
                int quantity = to.getQuantity();
                ImageIcon rawImage = product.getProductImage() != null
                        ? product.getProductImage().getImage()
                        : new ImageIcon(getClass().getResource("/images/no-pictures.png"));
                ImageIcon image = ImageUtil.resize(rawImage, 64, 64);

                long id = product.getProductId();
                String name = product.getName();
                String size = product.getSize();
                String color = product.getColor();
                double total = price * quantity;

                model.setValueAt(image, row, 0);
                model.setValueAt(id, row, 1);
                model.setValueAt(name, row, 2);
                model.setValueAt(size, row, 3);
                model.setValueAt(color, row, 4);
                model.setValueAt(NumberFormatter.format(price), row, 5);
                model.setValueAt(quantity, row, 6);
                model.setValueAt(NumberFormatter.format(total), row, 7);

                orderProductMap.remove(from.getProduct().getProductId());
                orderProductMap.put(id, to);
            }
        }

        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        double total = 0;
        for (OrderProduct op : orderProductMap.values()) {
            total += op.getUnitPrice() * op.getQuantity();
        }
        totalLabel.setText(NumberFormatter.format(total) + "đ");
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customerNameTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        customerPhoneTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        editBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customButton2 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customButton3 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        orderBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorderColor(java.awt.Color.lightGray);
        setRadius(16);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Order");
        jLabel1.setPreferredSize(new java.awt.Dimension(75, 32));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Customer Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Customer Phone");

        customerNameTextField.setBoderColor(new java.awt.Color(125, 44, 224));
        customerNameTextField.setPreferredSize(new java.awt.Dimension(48, 38));
        customerNameTextField.setRadius(16);

        customerPhoneTextField.setBoderColor(new java.awt.Color(125, 44, 224));
        customerPhoneTextField.setRadius(16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(customerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editBtn.setBackground(new java.awt.Color(38, 161, 244));
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pen_24.png"))); // NOI18N
        editBtn.setBorderColor(new java.awt.Color(38, 161, 244));
        editBtn.setColor(new java.awt.Color(38, 161, 244));
        editBtn.setColorClick(new java.awt.Color(30, 127, 193));
        editBtn.setColorOver(new java.awt.Color(30, 127, 193));
        editBtn.setPreferredSize(new java.awt.Dimension(38, 38));
        editBtn.setRadius(16);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        customButton2.setBackground(new java.awt.Color(75, 174, 79));
        customButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus_24.png"))); // NOI18N
        customButton2.setBorderColor(new java.awt.Color(75, 174, 79));
        customButton2.setColor(new java.awt.Color(75, 174, 79));
        customButton2.setColorClick(new java.awt.Color(53, 123, 55));
        customButton2.setColorOver(new java.awt.Color(53, 123, 55));
        customButton2.setPreferredSize(new java.awt.Dimension(38, 38));
        customButton2.setRadius(16);
        customButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton2ActionPerformed(evt);
            }
        });

        customButton3.setBackground(new java.awt.Color(244, 67, 54));
        customButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_24.png"))); // NOI18N
        customButton3.setBorderColor(new java.awt.Color(244, 67, 54));
        customButton3.setColor(new java.awt.Color(244, 67, 54));
        customButton3.setColorClick(new java.awt.Color(193, 52, 42));
        customButton3.setColorOver(new java.awt.Color(193, 52, 42));
        customButton3.setPreferredSize(new java.awt.Dimension(38, 38));
        customButton3.setRadius(16);
        customButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Name", "Size", "Color", "Price", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                javax.swing.ImageIcon.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("ID");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Name");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Size");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Color");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Price");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("Quantity");
            jTable1.getColumnModel().getColumn(7).setHeaderValue("Total");
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Total: ");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("0đ");

        orderBtn.setBackground(new java.awt.Color(125, 44, 224));
        orderBtn.setForeground(java.awt.Color.white);
        orderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping-cart-24.png"))); // NOI18N
        orderBtn.setText("Order");
        orderBtn.setBorderColor(new java.awt.Color(125, 44, 224));
        orderBtn.setColor(new java.awt.Color(125, 44, 224));
        orderBtn.setColorClick(new java.awt.Color(75, 3, 163));
        orderBtn.setColorOver(new java.awt.Color(96, 33, 173));
        orderBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        orderBtn.setIconTextGap(8);
        orderBtn.setPreferredSize(new java.awt.Dimension(128, 38));
        orderBtn.setRadius(16);
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Create new order.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLabel))
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void customButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton2ActionPerformed
        GlassPanePopup.showPopup(new SelectProductPanel(this), "selectProduct");
    }//GEN-LAST:event_customButton2ActionPerformed

    private void customButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton3ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            WarningPanel.show("Please select the product you want to delete!");
            return;
        }

        ConfirmPanel.show("Do you want to delete this row?", () -> {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            orderProductMap.remove((long) model.getValueAt(row, 1));
            model.removeRow(row);
            calculateTotalPrice();
        });
    }//GEN-LAST:event_customButton3ActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            WarningPanel.show("Please select the product you want to edit!");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        OrderProduct op = orderProductMap.get((long) model.getValueAt(row, 1));
        if (op == null) {
            System.out.println("OrderProduct is null");
            return;
        }

        GlassPanePopup.showPopup(new SelectProductPanel(this, op), "selectProduct");
    }//GEN-LAST:event_editBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        if (!validdateTextField(customerNameTextField, "Customer name is empty!")) {
            return;
        }

        if (!validdateTextField(customerPhoneTextField, "Customer phone is empty!")) {
            return;
        }

        if (orderProductMap.isEmpty()) {
            WarningPanel.show("Please add products!");
            return;
        }

        ConfirmPanel.show("Are you sure to order these products?", () -> {
            String customerName = customerNameTextField.getText();
            String customerPhone = customerPhoneTextField.getText();

            Order order = new Order();
            order.setName(customerName);
            order.setPhone(customerPhone);
            order.setOrderDate(new Date());

            DAOManager daoManager = DAOManager.getInstance();
            OrderDAO orderDAO = daoManager.getOrderDAO();
            OrderDetailDAO orderDetailDAO = daoManager.getOrderDetailDAO();

            MainFrame.getInstance().getLoading().showLoading();
            orderDAO.save(order).thenRunAsync(() -> {
                CompletableFuture.allOf(orderProductMap.keySet()
                        .stream()
                        .map((id) -> {
                            OrderProduct op = orderProductMap.get(id);
                            OrderDetail od = new OrderDetail();
                            od.setOrder(order);
                            od.setProduct(op.getProduct());
                            od.setQuantity(op.getQuantity());
                            od.setUnitPrice(op.getUnitPrice());
                            return orderDetailDAO.save(od);
                        })
                        .toArray(CompletableFuture[]::new)).join();
            }).thenRun(() -> {
                MainFrame.getInstance().getLoading().hideLoading();
                SuccessPanel.show("Order created successfully.");

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                customerNameTextField.setText("");
                customerPhoneTextField.setText("");
            }).whenComplete((t, u) -> {
                MainFrame.getInstance().getLoading().hideLoading();
                if (u != null) {
                    u.printStackTrace();
                    throw new RuntimeException(u);
                }
            });
        });


    }//GEN-LAST:event_orderBtnActionPerformed

    private boolean validdateTextField(JTextField field, String message) {
        if (field.getText().isBlank()) {
            WarningPanel.show(message);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton2;
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton3;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField customerNameTextField;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField customerPhoneTextField;
    private com.wingman.clothingshopmanagement.view.components.CustomButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.wingman.clothingshopmanagement.view.components.CustomButton orderBtn;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
