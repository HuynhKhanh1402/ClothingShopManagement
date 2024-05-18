/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.wingman.clothingshopmanagement;

import com.formdev.flatlaf.FlatLightLaf;
import com.wingman.clothingshopmanagement.util.HibernateUtil;
import com.wingman.clothingshopmanagement.view.MainFrame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrator
 */
public class Bootstrap {

    public static void main(String[] args) {
        try {
            FlatLightLaf.setup();
            
            HibernateUtil.getSessionFactory();

            SwingUtilities.invokeLater(() -> {
                MainFrame.getInstance().setVisible(true);
            });
        } catch (Exception e) {
            JFrame frame = new JFrame();
            showErrorDialog(frame, e);
        }
    }
    
    /**
     * Displays an error dialog containing the exception details.
     *
     * @param parent the parent JFrame for the dialog
     * @param ex the exception to display
     */
    private static void showErrorDialog(JFrame parent, Exception ex) {
        StringBuilder sb = new StringBuilder();
        collectExceptionInfo(ex, sb);
        JOptionPane.showMessageDialog(parent, sb.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Collects the details of the exception and appends them to the
     * StringBuilder.
     *
     * @param ex the exception to collect details from
     * @param sb the StringBuilder to append the details to
     */
    private static void collectExceptionInfo(Throwable ex, StringBuilder sb) {
        sb.append(ex.toString()).append("\n");

        for (StackTraceElement element : ex.getStackTrace()) {
            sb.append("\t").append(element.toString()).append("\n");
        }

        if (ex.getCause() != null) {
            sb.append("\nCaused by: ");
            collectExceptionInfo(ex.getCause(), sb);
        }
    }
}
