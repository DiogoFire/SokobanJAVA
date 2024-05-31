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
public class Player extends Element{
    
    protected int coordX, coordY;
    protected Image image;
    
    public Player(){
        super(Color.BLACK);
        image = loadImage("/resources/sokobanpack/PNG/Default size/Player/player_05.png");
    }
    
    public final Image loadImage(String resourceName) {
        try {
            //input stream para o recurso
            InputStream in = getClass().getResourceAsStream(resourceName);
            //ler a imagem e retornar o objeto
            return ImageIO.read(in);
        } catch (IOException ex) {
            System.out.println("teste");
            return null;
        }

    }
    
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        if (image != null) {
            gr.drawImage(image, px, py, width, height, null);
        } else {
            //interior
            gr.setColor(myColor);
            gr.fillOval(px, py, width, height);
        
            //limite do player
            gr.setColor(Color.BLACK);
            gr.drawOval(px, py, width, height);
        }
    }
    
    public Player(int x, int y){
        this.coordX = x;
        this.coordY = y;
    }
    
    public void moveXY(int dx, int dy){
        coordX += dx;
        coordY += dy;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    
}
