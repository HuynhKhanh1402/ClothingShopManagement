/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.order;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.ProductDAO;
import com.wingman.clothingshopmanagement.model.order.OrderProduct;
import com.wingman.clothingshopmanagement.model.product.Product;
import com.wingman.clothingshopmanagement.util.ImageUtil;
import com.wingman.clothingshopmanagement.util.NumberFormatter;
import com.wingman.clothingshopmanagement.view.MainFrame;
import com.wingman.clothingshopmanagement.view.components.CustomTextField;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Administrator
 */
public class SelectProductPanel extends javax.swing.JPanel {

    private final OrderPanel orderPanel;
    private final Map<Long, Product> productMap = new HashMap<>();
    private final JDialog dialog;
    private final boolean isEditMode;
    private final OrderProduct editProduct;

    /**
     * Creates new form SelectProductPanel
     *
     * @param orderPanel
     * @param dialog
     */
    public SelectProductPanel(OrderPanel orderPanel, JDialog dialog) {
        initComponents();
        this.orderPanel = orderPanel;
        this.dialog = dialog;
        this.isEditMode = false;
        this.editProduct = null;
        initTableData();
    }

    public SelectProductPanel(OrderPanel orderPanel, JDialog dialog, OrderProduct orderProduct) {
        initComponents();
        this.orderPanel = orderPanel;
        this.dialog = dialog;
        this.isEditMode = true;
        this.editProduct = orderProduct;
        addBtn.setText("Save");

        initTableData();

        priceTextField.setText(String.valueOf(orderProduct.getUnitPrice()));
        quantitySpinner.setValue(orderProduct.getQuantity());

        SwingUtilities.updateComponentTreeUI(this);
    }

    private void initTableData() {
        productMap.clear();

        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = jTable1.getSelectionModel();

        selectionModel.addListSelectionListener((e) -> {
            handleTableSelectEvent(e);
        });

        addSearchBoxListener();

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            if (i == 0 || i == 2) {
                continue;
            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(rowSorter);

        jTable1.setRowHeight(64);

        MainFrame.getInstance().getLoading().showLoading();

        ProductDAO productDAO = DAOManager.getInstance().getProductDAO();

        productDAO.getAll().thenAccept((t) -> {
            for (Product product : t) {
                if (!orderPanel.getOrderProductMap().containsKey(product.getProductId())
                        || (editProduct != null && (long) editProduct.getProduct().getProductId() == product.getProductId())) {
                    ImageIcon rawImage = product.getProductImage() != null
                            ? product.getProductImage().getImage()
                            : new ImageIcon(getClass().getResource("/images/no-pictures.png"));
                    ImageIcon image = ImageUtil.resize(rawImage, 64, 64);

                    long id = product.getProductId();
                    String name = product.getName();
                    String size = product.getSize();
                    String color = product.getColor();
                    String brand = product.getBrand();
                    int stock = product.getStock();
                    String formattedPrice = NumberFormatter.format(product.getPrice());

                    model.addRow(new Object[]{image, id, name, size, color, brand, stock, formattedPrice});

                    productMap.put(id, product);

                }
            }

            if (isEditMode) {
                for (int row = 0; row < model.getRowCount(); row++) {
                    long id = (long) model.getValueAt(row, 1);
                    if (id == editProduct.getProduct().getProductId()) {
                        jTable1.setRowSelectionInterval(row, row);
                    }
                }
            }
        }).whenComplete((t, u) -> {
            MainFrame.getInstance().getLoading().hideLoading();
            if (u != null) {
                u.printStackTrace();
                throw new RuntimeException(u);
            }
        });
    }

    private void handleTableSelectEvent(ListSelectionEvent e) {
        int rawRow = jTable1.getSelectedRow();
        if (rawRow == -1) {
            return;
        }

        int row = jTable1.getRowSorter().convertRowIndexToModel(rawRow);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        Product product = productMap.get((long) model.getValueAt(row, 1));
        if (product == null) {
            return;
        }

        priceTextField.setText(NumberFormatter.formatWithoutComma(product.getPrice()));
        quantitySpinner.setValue(1);
    }

    private void addSearchBoxListener() {
        searchBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterRows();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterRows();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterRows();
            }

        });
    }

    private void filterRows() {
        String searchText = searchBox.getText();
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + Pattern.quote(searchText), 2);
        ((TableRowSorter<DefaultTableModel>) jTable1.getRowSorter()).setRowFilter(rowFilter);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        searchBox = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        jLabel2 = new javax.swing.JLabel();
        priceTextField = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        jLabel3 = new javax.swing.JLabel();
        quantitySpinner = new com.wingman.clothingshopmanagement.view.components.CustomSpinner();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Select Product");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Name", "Size", "Color", "Brand", "Stock", "Price"
            }
        ) {
            Class[] types = new Class [] {
                javax.swing.ImageIcon.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        addBtn.setBackground(new java.awt.Color(125, 44, 224));
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.setBorderColor(new java.awt.Color(125, 44, 224));
        addBtn.setColor(new java.awt.Color(125, 44, 224));
        addBtn.setColorClick(new java.awt.Color(75, 3, 163));
        addBtn.setColorOver(new java.awt.Color(96, 33, 173));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setPreferredSize(new java.awt.Dimension(112, 38));
        addBtn.setRadius(16);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        searchBox.setBoderColor(new java.awt.Color(125, 44, 224));
        searchBox.setHint("Search");
        searchBox.setPreferredSize(new java.awt.Dimension(64, 32));
        searchBox.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-interface-symbol.png"))); // NOI18N
        searchBox.setRadius(16);
        searchBox.setSelectionColor(new java.awt.Color(155, 50, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Price");

        priceTextField.setBoderColor(new java.awt.Color(125, 44, 224));
        priceTextField.setPreferredSize(new java.awt.Dimension(124, 32));
        priceTextField.setRadius(16);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Quantity");

        quantitySpinner.setBorderColor(new java.awt.Color(125, 44, 224));
        quantitySpinner.setRadius(16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(443, Short.MAX_VALUE)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(444, 444, 444))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(quantitySpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(181, 181, 181))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantitySpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        int rawRow = jTable1.getSelectedRow();
        if (rawRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select the product you want to add!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int row = jTable1.getRowSorter().convertRowIndexToModel(jTable1.getSelectedRow());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        Product product = productMap.get((long) model.getValueAt(row, 1));
        if (product == null) {
            return;
        }

        String priceText = priceTextField.getText();

        if (priceText.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please input price of pruduct!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
//                if (field instanceof CustomTextField ctf) {
//                    ctf.setBoderColor(Color.RED);
//                }
            JOptionPane.showMessageDialog(this, String.format("%s is invalid number for product  price", priceText), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ((int) quantitySpinner.getValue() < 1) {
            JOptionPane.showMessageDialog(this, "Please choose a product quantity greater than 0!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (isEditMode) {
            OrderProduct orderProduct = new OrderProduct(product, price, (int) quantitySpinner.getValue());
            orderPanel.changeProduct(editProduct, orderProduct);
        } else {
            OrderProduct orderProduct = new OrderProduct(product, price, (int) quantitySpinner.getValue());
            orderPanel.addProduct(orderProduct);
        }

        dialog.dispose();
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.CustomButton addBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField priceTextField;
    private com.wingman.clothingshopmanagement.view.components.CustomSpinner quantitySpinner;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField searchBox;
    // End of variables declaration//GEN-END:variables
}
