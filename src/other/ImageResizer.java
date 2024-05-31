/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package other;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author diogo
 */
public class ImageResizer {
    public static ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(ImageResizer.class.getResource(imagePath));
        Image image = icon.getImage(); // Transform the image
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // Scale the image smoothly
        return new ImageIcon(newimg);  // Transform back
    }
    
}
