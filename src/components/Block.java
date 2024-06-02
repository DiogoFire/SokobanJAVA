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
 * Classe Block que representa as caixas no jogo
 * @author diogo
 */
public class Block extends Element{
    
    protected Boolean inGoal;
    protected Image image;
    
    // construtor que inicializa o bloco com base se está no objetivo ou não
    public Block(Boolean goal){
         this.inGoal = goal;
         // define a cor com base se está no objetivo (operador ternário)
         myColor = inGoal ? Color.CYAN : Color.BLUE;
         image = loadImage("/resources/crate.png");
    }
    
    // construtor por defeito que inicializa o bloco como não estando no objetivo
    public Block(){
        this(false);
    }
    
    // método para carregar a imagem de um recurso
    public final Image loadImage(String resourceName) {
        try {
            // input stream para o recurso
            InputStream in = getClass().getResourceAsStream(resourceName);
            // le a imagem e retorna o objeto
            return ImageIO.read(in);
        } catch (IOException ex) {
            // Em caso de erro, retorna null
            return null;
        }

    }
    
    // metodo para desenhar o bloco
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        if (image != null) {
            // desenhar a imagem
            gr.drawImage(image, px, py, width, height, null);
        if (inGoal) {
            // quando está no objetivo, é aplicada uma cor verde semi-transparente
            gr.setColor(new Color(0, 255, 0, 100)); 
            gr.fillRect(px, py, width, height);
            }
        } else {
            // caso a imagem não seja carregada
            
            // interior
            gr.setColor(myColor);
            gr.fillRect(px, py, width, height);

            // limite da caixa
            gr.setColor(Color.DARK_GRAY);
            gr.drawRect(px, py, width, height);
        
            // traços diagonais da caixa
            gr.setColor(Color.DARK_GRAY);
            gr.drawLine(px, py, px + width, py + height);
            gr.drawLine(px + width, py, px, py + height);
        }
    }
    
    // getter para obter o estado, se o bloco está ou não no objetivo
    public Boolean getInGoal() {
        return inGoal;
    }
     
}
     

