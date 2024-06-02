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
 * Classe que representa uma parede no jogo Sokoban
 * @author diogo
 */
public class Wall extends Element{

    protected Image image;
    
    // Construtor que carrega a imagem
    public Wall() {
        image = loadImage("/resources/parede.png");
    }
    
    // método para carregar uma imagem a partir de um recurso
    public final Image loadImage(String resourceName) {
        try {
            // input stream para o recurso
            InputStream in = getClass().getResourceAsStream(resourceName);
            // le a imagem e retorna o objeto
            return ImageIO.read(in);
        } catch (IOException ex) {
            return null; // retorna null em caso de erro
        }

    }

    // método para desenhar a parede
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        if (image != null) {
            // desenha a imagem da parede
            gr.drawImage(image, px, py, width, height, null);
        } else {
            // caso a imagem nao seja carregada corretamente
            gr.setColor(myColor);
            gr.fillRect(px, py, width, height);
            gr.setColor(Color.DARK_GRAY);
            gr.drawRect(px, py, width, height);
        }
    }
}

