/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;

/**
 * Classe abstrata Element com métodos usados pelos componentes do jogo
 * @author diogo
 */
public abstract class Element extends JComponent{

    protected Color myColor = Color.GRAY;
    
    // construtor por defeito que inicializa a cor do elemento a vermelho
    public Element(){
        this(Color.RED);
    }
    
    // construtor que inicializa a cor do elemento com a cor fornecida
    public Element(Color color){
        this.myColor = color;
    }

    // getter da cor
    public Color getMyColor(){
        return myColor;
    }
    
    // setter da cor
    public void setMyColor(Color color){
        this.myColor = color;
    }
    
    // método abstrato que deve ser implementado pelas subclasses para desenhar o elemento
    public abstract void draw(Graphics gr, int px, int py, int width, int height);
    
    // método para pintar o componente (dá Override ao painComponent de JComponent)
    @Override
    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
            // chama o método draw para desenhar o elemento
	    draw(gr, 0, 0, getWidth()-1, getHeight()-1);
    }
}
