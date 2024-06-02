/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package other;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Classe ImageResizer que redimensiona imagens
 * @author diogo
 */
public class ImageResizer {
    public static ImageIcon resizeImage(String imagePath, int width, int height) {
        // cria um ImageIcon
        ImageIcon icon = new ImageIcon(ImageResizer.class.getResource(imagePath));
        // transforma a imagem
        Image image = icon.getImage();
        // redimensiona a imagem 
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        // transforma de volta para ImageIcon
        return new ImageIcon(newimg);
    }
    
}
