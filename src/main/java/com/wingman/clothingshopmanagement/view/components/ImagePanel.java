package com.wingman.clothingshopmanagement.view.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ImagePanel extends JPanel {
    private ImageIcon imageIcon;
    private int radius;
    private Color borderColor;
    
    public ImagePanel() {
        setOpaque(true);
        this.radius = 0;
        this.borderColor = null;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (imageIcon != null) {
            setOpaque(false);
            
            if (borderColor != null) {
                
            }
            
            if (radius > 0) {
                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    radius, 
                    radius 
                );
                g2d.setClip(roundedRectangle);
            }
            
            g2d.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
        } else {
            setOpaque(true);
        }
        
        g2d.dispose();
    }
    
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        if (imageIcon == null) {
            setOpaque(true);
        } else {
            setOpaque(false);
        }
        revalidate();
        repaint();
    }
}
