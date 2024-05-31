/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class CustomLabel extends JLabel {
    private int radius = 0;
    
    @Override
    protected void paintComponent(Graphics g) {
        if (getIcon() != null) {
            Graphics2D graphics2d = (Graphics2D) g;
            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            graphics2d.setColor(getBackground());
            graphics2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

            graphics2d.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, radius, radius));
            graphics2d.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, null);

            graphics2d.dispose();
        }
        else {
            super.paintComponent(g);
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
