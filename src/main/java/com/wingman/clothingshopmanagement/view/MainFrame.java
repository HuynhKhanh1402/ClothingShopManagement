/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.view;

import com.wingman.clothingshopmanagement.model.user.User;
import com.wingman.clothingshopmanagement.view.panel.DashboardPanel;
import com.wingman.clothingshopmanagement.view.panel.LoginPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import lombok.Getter;

/**
 *
 * @author Administrator
 */
@Getter
public class MainFrame extends JFrame {
    private static MainFrame instance;
    private final Loading loading;
    private LoginPanel loginPanel;
    private DashboardPanel dashboardPanel;
    private boolean isShowDashboardPanel = false;

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }
    
    private JLabel loadingLabel;
    
    private MainFrame() {
        loading = new Loading(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        setResizable(false);
        setTitle("Clothing Shop Management");
        
        showLoginPanel();
//        showDashboardPanel(null);
        
        setLocationRelativeTo(null);
    }
    
    public void showLoginPanel() {
        loginPanel = new LoginPanel();
        setContentPane(loginPanel);
        isShowDashboardPanel = false;
        pack();
    }
    
    public void showDashboardPanel(User user) {
        dashboardPanel = new DashboardPanel(user);
        setContentPane(dashboardPanel);
        isShowDashboardPanel = true;
        pack();
    }
}
