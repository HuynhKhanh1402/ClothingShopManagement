/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.view;

import com.wingman.clothingshopmanagement.view.panel.DashboardPanel;
import java.awt.Dimension;
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
    private final DashboardPanel dashboardPanel;

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
        setTitle("Clothing Shop Sale Management");

        dashboardPanel = new DashboardPanel();
        setContentPane(dashboardPanel);
        pack();
        
        setLocationRelativeTo(null);
    }
}
