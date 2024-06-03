/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.revenue;

import com.wingman.clothingshopmanagement.model.dao.DAOManager;
import com.wingman.clothingshopmanagement.model.dao.OrderDAO;
import com.wingman.clothingshopmanagement.util.DateFormatter;
import com.wingman.clothingshopmanagement.util.NumberFormatter;
import com.wingman.clothingshopmanagement.view.MainFrame;
import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import javax.swing.SwingUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import raven.chart.ModelChart;
import raven.datetime.component.date.DatePicker;


public class RevenuePanel extends javax.swing.JPanel {

    private final DatePicker datePicker;

    /**
     * Creates new form RevenuePanel
     */
    public RevenuePanel() {
        initComponents();
        fetchData();
        
        curveLineChart.setTitle("Revenue over the past 12 months");
        curveLineChart.addLegend("Revenue", Color.decode("#0099F7"), Color.decode("#F11712"));
        
        setupChart();

        datePicker = new DatePicker();
        datePicker.setEditor(datePickerEditor);
        datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED);
        datePicker.setUsePanelOption(true);
        datePicker.addDateSelectionListener((de) -> {
            fetchData();
        });
        datePickerEditor.setVisible(false);
    }

    private void fetchData() {
        OrderDAO orderDAO = DAOManager.getInstance().getOrderDAO();
        
        MainFrame.getInstance().getLoading().showLoading();

        CompletableFuture.runAsync(() -> {
            Date fromDate = getViewRange()[0];
            Date toDate = getViewRange()[1];

            viewRangeDateLabel.setText(DateFormatter.formatDate(fromDate) + " - " + DateFormatter.formatDate(toDate));
            
            Double revenue = orderDAO.getRevenue(fromDate, toDate).join();
            totalRevenueLabel.setText(NumberFormatter.format(revenue == null ? 0 : revenue));
            
            Long orderedProduct = orderDAO.getOrderedProducts(fromDate, toDate).join();
            orderedProductLabel.setText(NumberFormatter.format(orderedProduct == null ? 0 : orderedProduct));
        }).whenComplete((t, u) -> {
            MainFrame.getInstance().getLoading().hideLoading();
            if (u != null) {
                u.printStackTrace();
                throw new RuntimeException(u);
            }
        });
    }

    private void setupChart() {
        OrderDAO orderDAO = DAOManager.getInstance().getOrderDAO();
        orderDAO.getRevenueChartData().thenAccept((t) -> {
            showChart(t);
        }).whenComplete((t, u) -> {
            if (u != null) {
                u.printStackTrace();
                throw new RuntimeException(u);
            }
        });
    }

    private Date[] getViewRange() {
        Optional<ViewRange> optionalVR = ViewRange.parse((String) viewRangeCombobox.getSelectedItem());
        if (optionalVR.isEmpty()) {
            throw new IllegalArgumentException("Invalid ViewRange");
        }

        ViewRange vr = optionalVR.get();
        LocalDate today = LocalDate.now();

        switch (vr) {
            case TODAY -> {
                LocalDateTime todayMidnight = LocalDateTime.of(today, LocalTime.MIDNIGHT);
                return new Date[]{Date.from(todayMidnight.atZone(ZoneId.systemDefault()).toInstant()), new Date()};
            }
            case WEEK -> {
                LocalDate monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
                LocalDateTime mondayMidnight = LocalDateTime.of(monday, LocalTime.MIDNIGHT);
                return new Date[]{Date.from(mondayMidnight.atZone(ZoneId.systemDefault()).toInstant()), new Date()};
            }
            case MONTH -> {
                LocalDate firstDayOfMonth = today.withDayOfMonth(1);
                LocalDateTime firstDayOfMonthMidnight = LocalDateTime.of(firstDayOfMonth, LocalTime.MIDNIGHT);
                return new Date[]{Date.from(firstDayOfMonthMidnight.atZone(ZoneId.systemDefault()).toInstant()), new Date()};
            }
            case THREE_MONTHS -> {
                LocalDate firstDay = LocalDate.now();
                for (int i = 0; i < 3; i++) {
                    firstDay = firstDay.minusMonths(i).withDayOfMonth(1);
                }
                LocalDateTime firstDayMidnight = LocalDateTime.of(firstDay, LocalTime.MIDNIGHT);
                System.out.println(firstDayMidnight);
                return new Date[]{Date.from(firstDayMidnight.atZone(ZoneId.systemDefault()).toInstant()), new Date()};
            }
            case YEAR -> {
                LocalDate firstDayOfYear = today.withDayOfYear(1);
                LocalDateTime firstDayOfYearMidnight = LocalDateTime.of(firstDayOfYear, LocalTime.MIDNIGHT);
                return new Date[]{Date.from(firstDayOfYearMidnight.atZone(ZoneId.systemDefault()).toInstant()), new Date()};
            }
            case TOTAL -> {
                return new Date[]{new Date(0), new Date()};
            }
            case CUSTOM -> {
                LocalDate[] dates = datePicker.getSelectedDateRange();
                if (dates == null) {
                    LocalDateTime todayMidnight = LocalDateTime.of(today, LocalTime.MIDNIGHT);
                    return new Date[]{Date.from(todayMidnight.atZone(ZoneId.systemDefault()).toInstant()), new Date()};
                }

                Date from = Date.from(dates[0].atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date to = Date.from(dates[1].plusDays(1).atStartOfDay(ZoneId.systemDefault()).minusSeconds(1).toInstant());
                return new Date[]{from, to};

            }
            default ->
                throw new AssertionError();
        }
    }

    private void showChart(RevenueChartData data) {
        Collections.reverse(data.getData());
        for (RevenueMonthy monthy: data.getData()) {
            curveLineChart.addData(new ModelChart(
                    monthy.getMonthOfYear() + "/" + monthy.getYear(),
                    new double[]{monthy.getRevenue()}));
        }
        curveLineChart.start();
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
        jLabel2 = new javax.swing.JLabel();
        viewRangeCombobox = new com.wingman.clothingshopmanagement.view.components.CustomComboBox();
        jLabel3 = new javax.swing.JLabel();
        viewRangeDateLabel = new javax.swing.JLabel();
        customPanel1 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalRevenueLabel = new javax.swing.JLabel();
        customPanel2 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        orderedProductLabel = new javax.swing.JLabel();
        chart = new javax.swing.JPanel();
        curveLineChart = new raven.chart.CurveLineChart();
        customPanel3 = new com.wingman.clothingshopmanagement.view.components.CustomPanel();
        datePickerEditor = new com.wingman.clothingshopmanagement.view.components.CustomFormattedField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Revenue");
        jLabel1.setPreferredSize(new java.awt.Dimension(75, 32));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 246, -1));

        jLabel2.setText("View shop's revenue here.");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 38, -1, -1));

        viewRangeCombobox.setBackground(new java.awt.Color(207, 177, 242));
        viewRangeCombobox.setForeground(new java.awt.Color(107, 46, 182));
        viewRangeCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Today", "Week", "Month", "3 Months", "Year", "Total", "Custom" }));
        viewRangeCombobox.setBorderColor(new java.awt.Color(207, 177, 242));
        viewRangeCombobox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewRangeCombobox.setRadius(16);
        viewRangeCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRangeComboboxActionPerformed(evt);
            }
        });
        add(viewRangeCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 103, 136, 38));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(125, 44, 224));
        jLabel3.setText("View range:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 72, -1, -1));

        viewRangeDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewRangeDateLabel.setForeground(java.awt.Color.darkGray);
        viewRangeDateLabel.setText("dd/MM/yyyy - dd/MM/yyyy");
        add(viewRangeDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 74, -1, -1));

        customPanel1.setBorderColor(new java.awt.Color(125, 44, 224));
        customPanel1.setRadius(16);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profits.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Revenue");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText(" ₫");

        totalRevenueLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalRevenueLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalRevenueLabel.setText("1000000000000");

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addComponent(totalRevenueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalRevenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        add(customPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 159, -1, -1));

        customPanel2.setBorderColor(new java.awt.Color(125, 44, 224));
        customPanel2.setRadius(16);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trolley.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Ordered Products");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("product(s)");

        orderedProductLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        orderedProductLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        orderedProductLabel.setText("1000000000000");

        javax.swing.GroupLayout customPanel2Layout = new javax.swing.GroupLayout(customPanel2);
        customPanel2.setLayout(customPanel2Layout);
        customPanel2Layout.setHorizontalGroup(
            customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addComponent(orderedProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                    .addGroup(customPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        customPanel2Layout.setVerticalGroup(
            customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(customPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderedProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        add(customPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 159, -1, -1));

        curveLineChart.setBackground(new java.awt.Color(255, 255, 255));
        curveLineChart.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout chartLayout = new javax.swing.GroupLayout(chart);
        chart.setLayout(chartLayout);
        chartLayout.setHorizontalGroup(
            chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curveLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        chartLayout.setVerticalGroup(
            chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curveLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 352, 960, 320));

        customPanel3.setBorderColor(new java.awt.Color(125, 44, 224));
        customPanel3.setRadius(16);

        datePickerEditor.setBorderColor(new java.awt.Color(125, 44, 224));
        datePickerEditor.setRadius(16);
        datePickerEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerEditorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel3Layout = new javax.swing.GroupLayout(customPanel3);
        customPanel3.setLayout(customPanel3Layout);
        customPanel3Layout.setHorizontalGroup(
            customPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel3Layout.createSequentialGroup()
                .addContainerGap(764, Short.MAX_VALUE)
                .addComponent(datePickerEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        customPanel3Layout.setVerticalGroup(
            customPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datePickerEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        add(customPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 970, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void viewRangeComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRangeComboboxActionPerformed
        if (((String) viewRangeCombobox.getSelectedItem()).equals("Custom")) {
            datePickerEditor.setVisible(true);
            SwingUtilities.updateComponentTreeUI(this);
        } else {
            datePickerEditor.setVisible(false);
            SwingUtilities.updateComponentTreeUI(this);
        }
        fetchData();
        
    }//GEN-LAST:event_viewRangeComboboxActionPerformed

    private void datePickerEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerEditorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datePickerEditorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chart;
    private raven.chart.CurveLineChart curveLineChart;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel1;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel2;
    private com.wingman.clothingshopmanagement.view.components.CustomPanel customPanel3;
    private com.wingman.clothingshopmanagement.view.components.CustomFormattedField datePickerEditor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel orderedProductLabel;
    private javax.swing.JLabel totalRevenueLabel;
    private com.wingman.clothingshopmanagement.view.components.CustomComboBox viewRangeCombobox;
    private javax.swing.JLabel viewRangeDateLabel;
    // End of variables declaration//GEN-END:variables
}
