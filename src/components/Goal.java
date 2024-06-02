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
 * Classe Goal representa os objetivos (local onde as caixas devem ser colocadas) no jogo
 * @author diogo
 */
public class Goal extends Clear{
    
    protected Image image;

    // construtor que inicializa a cor a azul ciano e carrega a imagem do objetivo
    public Goal() {
        super(Color.CYAN);
        image = loadImage("/resources/goal.png");
    }

    // método para carregar a imagem de um recurso
    public final Image loadImage(String resourceName) {
        try {
            // input stream para o recurso
            InputStream in = getClass().getResourceAsStream(resourceName);
            // le a imagem e retorna o objeto
            return ImageIO.read(in);
        } catch (IOException ex) {
            // caso a imagem nao seja carregada, retorna null
            return null;
        }

    }
    
    // metodo draw para desenhar o objetivo
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        if (image != null) {
            // desenha a imagem do objetivo
            gr.drawImage(image, px, py, width, height, null);
        } else {
            // caso a imagem nao tenha sido carregada corretamente
            gr.setColor(myColor);
            int size = Math.min(width, height)/3;
            gr.fillRect(px+size, py+size, width - 2 * size, height - 2 * size);
            // desenha a borda do retângulo
            gr.setColor(Color.BLACK);
            gr.drawRect(px+size, py+size, width - 2 * size, height - 2 * size);
            // desenha a borda exterior
            gr.setColor(Color.DARK_GRAY);
            gr.drawRect(px, py, width, height);
        }
    }
}
