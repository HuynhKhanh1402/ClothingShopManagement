package com.wingman.clothingshopmanagement.view;
import javax.swing.*;
import java.awt.*;

public class Loading {
    private final JDialog loadingDialog;

    public Loading(JFrame parentFrame) {
        loadingDialog = new JDialog(parentFrame, true);
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

        JLabel loadingLabel = new JLabel(new ImageIcon(getClass().getResource("/gifs/loading.gif")));
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