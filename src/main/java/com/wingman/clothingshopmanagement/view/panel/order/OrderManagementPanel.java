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
import com.wingman.clothingshopmanagement.model.order.OrderDetailId;
import com.wingman.clothingshopmanagement.util.DateFormatter;
import com.wingman.clothingshopmanagement.util.NumberFormatter;
import com.wingman.clothingshopmanagement.view.MainFrame;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import lombok.Getter;
import raven.datetime.component.date.DateEvent;
import raven.datetime.component.date.DatePicker;
import raven.datetime.component.date.DateSelectionListener;

/**
 *
 * @author Administrator
 */
@Getter
public class OrderManagementPanel extends javax.swing.JPanel {

    private final Map<Long, Order> orderMap = new HashMap<>();
    private DatePicker datePicker;

    /**
     * Creates new form OrderManagementPanel
     */
    public OrderManagementPanel() {
        initComponents();
        
        setupTableProperties();
        
        setupSearchBox();
        
        setupDateChooser();
        
        prepareData();
    }
    
    private void setupTableProperties() {
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(rowSorter);
    }
    
    private void setupDateChooser() {
        datePicker = new DatePicker();
        datePicker.setEditor(customFormattedField1);
        datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED);
        datePicker.setUsePanelOption(true);
        datePicker.addDateSelectionListener((DateEvent de) -> {
            filterRows();
        });
    }
    
    private void setupSearchBox() {
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

    private void prepareData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        OrderDAO orderDAO = DAOManager.getInstance().getOrderDAO();
        OrderDetailDAO orderDetailDAO = DAOManager.getInstance().getOrderDetailDAO();

        MainFrame.getInstance().getLoading().showLoading();

        orderDAO.getAll().thenAccept((t) -> {
            orderMap.clear();
            for (Order order : t) {
                double total = orderDetailDAO.getTotal(order).join();
                model.addRow(new Object[]{
                    order.getOrderId(), 
                    DateFormatter.formatDateAndTime(order.getOrderDate()), 
                    order.getName(), 
                    order.getPhone(), 
                    NumberFormatter.format(total)
                });
                orderMap.put(order.getOrderId(), order);
            }
        }).whenComplete((t, u) -> {
            MainFrame.getInstance().getLoading().hideLoading();
            if (u != null) {
                u.printStackTrace();
                throw new RuntimeException(u);
            }
        });
    }
    
    private void filterRows() {
        String searchText = searchBox.getText();
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for (int i = 0; i < model.getColumnCount(); i++) {
                    if (entry.getStringValue(i).toLowerCase().contains(searchText.toLowerCase())) {
                        LocalDate[] dates = datePicker.getSelectedDateRange();
                        if (dates == null || dates.length == 1) {
                            return true;
                        }
                        Date from = Date.from(dates[0].atStartOfDay(ZoneId.systemDefault()).toInstant());
                        Date to = Date.from(dates[1].plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
                        Date orderDate;
                        try {
                            orderDate = DateFormatter.parseDateAndTime(entry.getStringValue(1));
                        } catch (ParseException ex) {
                            return true;
                        }
                        return orderDate.getTime() >= from.getTime() && orderDate.getTime() < to.getTime();
                    }
                }
                return false;
            }
        };
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
        infoBtn = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        removeButton = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customFormattedField1 = new com.wingman.clothingshopmanagement.view.components.CustomFormattedField();
        searchBox = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Order Management");
        jLabel1.setPreferredSize(new java.awt.Dimension(75, 32));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Order Date", "Customer Name", "Customer Phone", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        addBtn.setBackground(new java.awt.Color(75, 174, 79));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus_24.png"))); // NOI18N
        addBtn.setBorderColor(new java.awt.Color(75, 174, 79));
        addBtn.setColor(new java.awt.Color(75, 174, 79));
        addBtn.setColorClick(new java.awt.Color(53, 123, 55));
        addBtn.setColorOver(new java.awt.Color(53, 123, 55));
        addBtn.setPreferredSize(new java.awt.Dimension(38, 38));
        addBtn.setRadius(16);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        infoBtn.setBackground(new java.awt.Color(38, 161, 244));
        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info_24.png"))); // NOI18N
        infoBtn.setBorderColor(new java.awt.Color(38, 161, 244));
        infoBtn.setColor(new java.awt.Color(38, 161, 244));
        infoBtn.setColorClick(new java.awt.Color(30, 127, 193));
        infoBtn.setColorOver(new java.awt.Color(30, 127, 193));
        infoBtn.setPreferredSize(new java.awt.Dimension(38, 38));
        infoBtn.setRadius(16);
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(244, 67, 54));
        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_24.png"))); // NOI18N
        removeButton.setBorderColor(new java.awt.Color(244, 67, 54));
        removeButton.setColor(new java.awt.Color(244, 67, 54));
        removeButton.setColorClick(new java.awt.Color(193, 52, 42));
        removeButton.setColorOver(new java.awt.Color(193, 52, 42));
        removeButton.setPreferredSize(new java.awt.Dimension(38, 38));
        removeButton.setRadius(16);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        customFormattedField1.setBorderColor(new java.awt.Color(125, 44, 224));
        customFormattedField1.setRadius(16);

        searchBox.setBoderColor(new java.awt.Color(125, 44, 224));
        searchBox.setHint("Search");
        searchBox.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-interface-symbol.png"))); // NOI18N
        searchBox.setRadius(16);

        jLabel2.setText("Add, view, delete order here.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customFormattedField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(infoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customFormattedField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        MainFrame.getInstance().getDashboardPanel().setConentPanel(new OrderPanel());
    }//GEN-LAST:event_addBtnActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        int rawRow = jTable1.getSelectedRow();
        if (rawRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select the order you want to view!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = jTable1.getRowSorter().convertRowIndexToModel(rawRow);

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Order order = orderMap.get((long) model.getValueAt(row, 0));
        if (order == null) {
            System.out.println("Order is null");
            return;
        }
        JDialog dialog = new JDialog(MainFrame.getInstance(), "Order info", true);
        dialog.setContentPane(new OrderInfoPanel(order));
        dialog.pack();
        dialog.setLocationRelativeTo(MainFrame.getInstance());
        dialog.setVisible(true);
        dialog.setResizable(false);
    }//GEN-LAST:event_infoBtnActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int rawRow = jTable1.getSelectedRow();
        if (rawRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select the order you want to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int row = jTable1.getRowSorter().convertRowIndexToModel(rawRow);

        int response = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Do you want to delete this order?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Order order = orderMap.get((long) model.getValueAt(row, 0));
            if (order == null) {
                return;
            }
            OrderDAO orderDAO = DAOManager.getInstance().getOrderDAO();
            OrderDetailDAO orderDetailDAO = DAOManager.getInstance().getOrderDetailDAO();
            
            MainFrame.getInstance().getLoading().showLoading();
            
            orderDetailDAO.getAll(order).thenAcceptAsync((t) -> {
                for (OrderDetail od: t) {
                    orderDetailDAO.delete(new OrderDetailId(od.getOrder().getOrderId(), od.getProduct().getProductId())).join();
                }
                orderDAO.delete(order.getOrderId()).join();
                MainFrame.getInstance().getLoading().hideLoading();
                JOptionPane.showMessageDialog(this, "Order deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                prepareData();
            }).whenComplete((t, u) -> {
                MainFrame.getInstance().getLoading().hideLoading();
                if (u != null) {
                    u.printStackTrace();
                    throw new RuntimeException(u);
                }
            });
        }
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.CustomButton addBtn;
    private com.wingman.clothingshopmanagement.view.components.CustomFormattedField customFormattedField1;
    private com.wingman.clothingshopmanagement.view.components.CustomButton infoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.wingman.clothingshopmanagement.view.components.CustomButton removeButton;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField searchBox;
    // End of variables declaration//GEN-END:variables
}
