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
 * Classe Player que representa o jogador
 * @author diogo
 */
public class Player extends Element{
    
    protected int coordX, coordY;
    protected Image image;
    
    // Método para carregar uma imagem de um recurso
    public final Image loadImage(String resourceName) {
        try {
            // input stream para o recurso
            InputStream in = getClass().getResourceAsStream(resourceName);
            // le a imagem e retornaa o objeto
            return ImageIO.read(in);
        } catch (IOException ex) {
            return null;
        }

    }
    
    // implementação do método draw para desenhar o jogador
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        // carrega a imagem do jogador
        image = loadImage("/resources/player.png");
        if (image != null) {
            // desenha a imagem do jogador
            gr.drawImage(image, px, py, width, height, null);
        } else {
            // caso a imagem nao seja carregada corretamente
            
            //interior
            gr.setColor(myColor);
            gr.fillOval(px, py, width, height);
        
            //limite do player
            gr.setColor(Color.BLACK);
            gr.drawOval(px, py, width, height);
        }
    }
    
    // Construtor com as coordenadas do jogador
    public Player(int x, int y){
        this.coordX = x;
        this.coordY = y;
    }
    
    // método para mover o jogador nas coordenadas X e Y
    public void moveXY(int dx, int dy){
        coordX += dx;
        coordY += dy;
    }

    //getters e setters das coordenadas X e Y
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
