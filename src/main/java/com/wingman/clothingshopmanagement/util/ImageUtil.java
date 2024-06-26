package com.wingman.clothingshopmanagement.util;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * The ImageUtil class provides utility methods for working with images,
 * particularly for resizing ImageIcon objects.
 *
 * @author ADMIN
 */
public class ImageUtil {

    /**
     * Resizes the given ImageIcon to the specified width and height.
     *
     * @param icon the ImageIcon to be resized
     * @param width the desired width of the resized image
     * @param height the desired height of the resized image
     * @return a new ImageIcon with the specified dimensions
     */
    public static ImageIcon resize(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public static ImageIcon resize(ImageIcon icon, Dimension dimension) {
        return resize(icon, (int) dimension.getHeight(), (int) dimension.getHeight());
    }

    public static byte[] convertImageToByteArray(Image image) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2.setComposite(AlphaComposite.Src);
        g2.drawImage(image, null, null);
        g2.dispose();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", outStream);
        return outStream.toByteArray();
    }
}
