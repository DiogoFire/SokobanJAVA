/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author diogo
 */
public class Goal extends Clear{
    
    protected Image image;

    public Goal() {
        super(Color.CYAN);
        image = loadImage("/resources/goal.png");
    }

    public final Image loadImage(String resourceName) {
        try {
            //input stream para o recurso
            InputStream in = getClass().getResourceAsStream(resourceName);
            //ler a imagem e retornar o objeto
            return ImageIO.read(in);
        } catch (IOException ex) {
            return null;
        }

    }
    
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        if (image != null) {
            gr.drawImage(image, px, py, width, height, null);
        } else {
            gr.setColor(myColor);
            int size = Math.min(width, height)/3;
            gr.fillRect(px+size, py+size, width - 2 * size, height - 2 * size);
            gr.setColor(Color.BLACK);
            gr.drawRect(px+size, py+size, width - 2 * size, height - 2 * size);
            gr.setColor(Color.DARK_GRAY);
            gr.drawRect(px, py, width, height);
        }
    }
}
