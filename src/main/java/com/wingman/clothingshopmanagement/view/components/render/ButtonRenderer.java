package com.wingman.clothingshopmanagement.view.components.render;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class ButtonRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = (Component) value;
        
        if (isSelected) {
            component.setBackground(table.getSelectionBackground());
        } else {
            component.setBackground(table.getBackground());
        }
        
        return component;
    }
}
