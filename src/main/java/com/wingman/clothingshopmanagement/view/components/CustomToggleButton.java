package com.wingman.clothingshopmanagement.view.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JToggleButton;


public class CustomToggleButton extends JToggleButton {
    private int radius = 0;
    private int borderSize = 1;
    private Color borderColor = Color.BLACK;
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth() -1 , getHeight() -1, this.radius, this.radius);
        g2d.setColor(getBackground());
        g2d.fill(shape);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(this.borderSize));
        g2d.setColor(borderColor);
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth()-1, getHeight()-1, this.radius, this.radius);
        g2d.draw(shape);
        g2d.setStroke(oldStroke);
    }
    
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }
}
