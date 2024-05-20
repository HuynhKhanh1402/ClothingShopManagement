package com.wingman.clothingshopmanagement.view.panel.product;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxExample extends JFrame {
    private JCheckBox selectAllCheckBox;
    private JCheckBox[] checkBoxes;
    
    public CheckBoxExample() {
        // Tạo frame
        setTitle("Select All Checkbox Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo panel để chứa các checkbox
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // Tạo checkbox "Chọn tất cả"
        selectAllCheckBox = new JCheckBox("Select All");
        panel.add(selectAllCheckBox);

        // Tạo các checkbox con
        checkBoxes = new JCheckBox[5];
        for (int i = 0; i < 5; i++) {
            checkBoxes[i] = new JCheckBox("Checkbox " + (i + 1));
            panel.add(checkBoxes[i]);
        }

        // Thêm sự kiện cho checkbox "Chọn tất cả"
        selectAllCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isSelected = selectAllCheckBox.isSelected();
                for (JCheckBox checkBox : checkBoxes) {
                    checkBox.setSelected(isSelected);
                }
            }
        });

        // Thêm sự kiện cho các checkbox con để cập nhật trạng thái của checkbox "Chọn tất cả"
        for (JCheckBox checkBox : checkBoxes) {
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!checkBox.isSelected()) {
                        selectAllCheckBox.setSelected(false);
                    } else {
                        boolean allSelected = true;
                        for (JCheckBox cb : checkBoxes) {
                            if (!cb.isSelected()) {
                                allSelected = false;
                                break;
                            }
                        }
                        selectAllCheckBox.setSelected(allSelected);
                    }
                }
            });
        }

        // Thêm panel vào frame
        add(panel);

        // Hiển thị frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CheckBoxExample();
            }
        });
    }
}
