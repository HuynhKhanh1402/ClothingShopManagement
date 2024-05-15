package com.wingman.clothingshopmanagement.view.components.render;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class PanelRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JPanel panel) {
            applyJTableAttributes(table, panel, isSelected);
        }
        
        return (Component) value;
    }
    
    private void applyJTableAttributes(JTable table, JPanel container, boolean isSelected) {
        if (isSelected) {
            container.setBackground(table.getSelectionBackground());
        } else {
            container.setBackground(table.getBackground());
        }
        
        for (Component component: container.getComponents()) {
            if (component == null) {
                continue;
            }
            if (component instanceof JPanel panel) {
                applyJTableAttributes(table, panel, isSelected);
            } else {
                if (isSelected) {
                    component.setBackground(table.getSelectionBackground());
                    component.setForeground(table.getSelectionForeground());
                } else {
                    component.setBackground(table.getBackground());
                    component.setForeground(table.getForeground());
                }
            }
        }
    }
        
}
