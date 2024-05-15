/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.user;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class UserManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserManagementPanel
     */
    public UserManagementPanel() {
        initComponents();
        
        jPanel1.setPreferredSize(new Dimension(971, 1000));
        
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        addUserPanel(new UserPanelDesign());
        

        
//        initTable();
    }
    
    private void addUserPanel(JPanel panel) {
        jPanel1.add(panel);
        
        int width = (int) jPanel1.getPreferredSize().getWidth();
        int height = (int) jPanel1.getPreferredSize().getHeight();
        
        height += panel.getHeight();
        
        jPanel1.setPreferredSize(new Dimension(width, height));
    }
    
//    private void initTable() {
//        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
//        
//        jTable1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                setBorder(null);
//                setBackground(new Color(250, 250, 250));
//                return this;
//            }
//        });
//        
//        jTable1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int row = jTable1.rowAtPoint(e.getPoint());
//                int col = jTable1.columnAtPoint(e.getPoint());
//                if (row >= 0 && col >= 0) {
//                    if (jTable1.getValueAt(row, col) instanceof CellButton button) {
//                        button.getConsumer().accept(jTable1);
//                    }
//                }
//            }
//        });
//        
//        jTable1.setRowHeight(50);
//        jTable1.getColumnModel().getColumn(0).setCellRenderer(new PanelRenderer());
//        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
//        jTable1.getColumnModel().getColumn(4).setMaxWidth(30);
//        jTable1.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
//        jTable1.getColumnModel().getColumn(5).setMaxWidth(30);
//        
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        
//        JButton button = new CellButton("", (t) -> {
//            System.out.println("Hello"); 
//        });
//        button.setBorder(new EmptyBorder(3, 3, 3, 3));
//        button.setIcon(new ImageIcon(getClass().getResource("/images/delete.png")));
//        
//       
//        JButton button1 = new CellButton("", (t) -> {
//            System.out.println("Hello2"); 
//        });
//        button1.setBorder(new EmptyBorder(3, 3, 3, 3));
//        button1.setIcon(new ImageIcon(getClass().getResource("/images/pencil.png")));
//
//        model.addRow(new Object [] {getUserColumPanel("Huynh Quoc Khanh", "admin@mail.com"), "Administrator", "13/05/2024", "13/05/2024", button, button1});       
//        model.addRow(new Object [] {getUserColumPanel("Huynh Quoc Khanh", "admin@mail.com"), "Administrator", "13/05/2024", "13/05/2024", button, button1});
//    }
//    
//    private JPanel getUserColumPanel(String fullName, String email) {
//        JPanel centerPanel = new JPanel();
//        centerPanel.setLayout(new GridLayout(2, 1));
//        centerPanel.setBackground(jTable1.getBackground());
//        
//        JLabel fullNameLabel = new JLabel(fullName);
//        fullNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        JLabel emailLabel = new JLabel(email);
//        
//        centerPanel.add(fullNameLabel);
//        centerPanel.add(emailLabel);
//        
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//        mainPanel.setBackground(jTable1.getBackground());
//        
//        ImageIcon icon = new ImageIcon(getClass().getResource("/images/user_color.png"));
//        JLabel iconLabel = new JLabel(ImageUtil.resize(icon, 32, 32));
//        iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
//        mainPanel.add(iconLabel, BorderLayout.WEST);
//        
//        mainPanel.add(centerPanel, BorderLayout.CENTER);
//        
//        return mainPanel;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userManagementLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customButton1 = new com.wingman.clothingshopmanagement.view.components.CustomButton();
        customTextField2 = new com.wingman.clothingshopmanagement.view.components.CustomTextField();
        jPanel2 = new javax.swing.JPanel();
        userNameLabel = new javax.swing.JTextField();
        permissionLabel = new javax.swing.JTextField();
        lastActiveLabel = new javax.swing.JTextField();
        dateAddedLabel = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        userManagementLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userManagementLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userManagementLabel.setText("User Management");
        userManagementLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Manage users and their permissions here.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("All users");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.gray);
        jLabel3.setText("1");

        customButton1.setBackground(new java.awt.Color(125, 44, 224));
        customButton1.setForeground(new java.awt.Color(255, 255, 255));
        customButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        customButton1.setText("Add user");
        customButton1.setBorderColor(new java.awt.Color(125, 44, 224));
        customButton1.setColor(new java.awt.Color(125, 44, 224));
        customButton1.setColorClick(new java.awt.Color(75, 3, 163));
        customButton1.setColorOver(new java.awt.Color(96, 33, 173));
        customButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customButton1.setIconTextGap(12);
        customButton1.setPreferredSize(new java.awt.Dimension(118, 36));
        customButton1.setRadius(16);

        customTextField2.setBoderColor(new java.awt.Color(125, 44, 224));
        customTextField2.setHint("Search");
        customTextField2.setPreferredSize(new java.awt.Dimension(64, 36));
        customTextField2.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-interface-symbol.png"))); // NOI18N
        customTextField2.setRadius(16);
        customTextField2.setSelectionColor(new java.awt.Color(155, 50, 255));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        userNameLabel.setEditable(false);
        userNameLabel.setBackground(new java.awt.Color(250, 250, 250));
        userNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userNameLabel.setForeground(java.awt.Color.gray);
        userNameLabel.setText("User");
        userNameLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        permissionLabel.setEditable(false);
        permissionLabel.setBackground(new java.awt.Color(250, 250, 250));
        permissionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        permissionLabel.setForeground(java.awt.Color.gray);
        permissionLabel.setText("Permission");
        permissionLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lastActiveLabel.setEditable(false);
        lastActiveLabel.setBackground(new java.awt.Color(250, 250, 250));
        lastActiveLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lastActiveLabel.setForeground(java.awt.Color.gray);
        lastActiveLabel.setText("Last active");
        lastActiveLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        dateAddedLabel.setEditable(false);
        dateAddedLabel.setBackground(new java.awt.Color(250, 250, 250));
        dateAddedLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateAddedLabel.setForeground(java.awt.Color.gray);
        dateAddedLabel.setText("Date added");
        dateAddedLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permissionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastActiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateAddedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(userNameLabel)
                .addComponent(permissionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addComponent(lastActiveLabel)
                .addComponent(dateAddedLabel))
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(971, 515));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(971, 515));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(971, 515));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(971, 515));
        jPanel1.setMinimumSize(new java.awt.Dimension(971, 515));
        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 425, Short.MAX_VALUE)
                        .addComponent(customTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userManagementLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userManagementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        FlatLightLaf.setup();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.add(new UserManagementPanel());
        frame.pack();
        frame.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wingman.clothingshopmanagement.view.components.CustomButton customButton1;
    private com.wingman.clothingshopmanagement.view.components.CustomTextField customTextField2;
    private javax.swing.JTextField dateAddedLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastActiveLabel;
    private javax.swing.JTextField permissionLabel;
    private javax.swing.JLabel userManagementLabel;
    private javax.swing.JTextField userNameLabel;
    // End of variables declaration//GEN-END:variables
}
