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
public class Wall extends Element{

    protected Image image;
    
    public Wall() {
        image = loadImage("/resources/tileset/tile101.png");
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
            gr.fillRect(px, py, width, height);
            gr.setColor(Color.DARK_GRAY);
            gr.drawRect(px, py, width, height);
        }
    }
}

