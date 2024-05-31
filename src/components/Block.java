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
public class Block extends Element{
    
    protected Boolean inGoal;
    protected Image image;
    
    public Block(Boolean goal){
         this.inGoal = goal;
         myColor = inGoal ? Color.CYAN : Color.BLUE; //operador ternario
         //image = loadImage("/resources/tileset/tile450.png");
         image = loadImage("/resources/crate.png");
    }
    
    public Block(){
        this(false);
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
        if (inGoal) {
            gr.setColor(new Color(0, 255, 0, 100)); // Semi-transparent green color
            gr.fillRect(px, py, width, height);
            }
        } else {
            //interior
            gr.setColor(myColor);
            gr.fillRect(px, py, width, height);

            //limite da caixa
            gr.setColor(Color.DARK_GRAY);
            gr.drawRect(px, py, width, height);
        
            //traços diagonais da caixa
            gr.setColor(Color.DARK_GRAY);
            gr.drawLine(px, py, px + width, py + height);
            gr.drawLine(px + width, py, px, py + height);
        }
    }
    
    public Boolean getInGoal() {
        return inGoal;
    }
    
    
    
}
     

