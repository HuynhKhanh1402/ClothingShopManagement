/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.user;

import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JTable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
public class CellButton extends JButton {
    private Consumer<JTable> consumer;
    
    public CellButton(String text, Consumer<JTable> consumer) {
        super(text);
        this.consumer = consumer;
    }
}
