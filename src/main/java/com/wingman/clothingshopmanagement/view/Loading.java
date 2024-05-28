package com.wingman.clothingshopmanagement.view;
import javax.swing.*;
import java.awt.*;

public class Loading {
    private final MainFrame mainFrame;
    private final JDialog loadingDialog;
    private final JLabel loadingLabel;

    public Loading(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        
        loadingDialog = new JDialog(mainFrame, true);
        loadingDialog.setUndecorated(true);
        loadingDialog.setSize(100, 100);
        
        loadingDialog.setBackground(new Color(0, 0, 0, 0));
        
        JPanel contentPane = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 0));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setOpaque(false);

        loadingLabel = new JLabel(new ImageIcon(getClass().getResource("/gifs/DualRing.gif")));
        contentPane.add(loadingLabel, BorderLayout.CENTER);
        loadingDialog.setContentPane(contentPane);
        loadingDialog.pack();
    }

    public void showLoading() {
        SwingUtilities.invokeLater(() -> {
            if (loadingDialog != null && !loadingDialog.isShowing()) {
                JFrame parentFrame = (JFrame) loadingDialog.getParent();
                int parentWidth = parentFrame.getWidth();
                int parentHeight = parentFrame.getHeight();
                int dialogWidth = loadingDialog.getWidth();
                int dialogHeight = loadingDialog.getHeight();
                int x = parentFrame.getX() + (parentWidth - dialogWidth) / 2;
                int y = parentFrame.getY() + (parentHeight - dialogHeight) / 2;
                
                if (mainFrame.isShowDashboardPanel()) {
                    x += 261 / 2;
                    y += 62 / 2;
                }
                
                loadingDialog.setLocation(x, y);
                loadingDialog.setVisible(true);
            }
        });
    }

    public void hideLoading() {
        SwingUtilities.invokeLater(() -> {
            if (loadingDialog != null && loadingDialog.isShowing()) {
                loadingDialog.setVisible(false);
            }
        });
    }

}