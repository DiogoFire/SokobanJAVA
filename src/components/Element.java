/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;

/**
 *
 * @author diogo
 */
public abstract class Element extends JComponent{

    protected Color myColor = Color.GRAY;
    
    public Element(){
        this(Color.RED);
    }
    
    public Element(Color color){
        this.myColor = color;
    }

    public Color getMyColor(){
        return myColor;
    }

    public void setMyColor(Color color){
        this.myColor = color;
    }
    
    public abstract void draw(Graphics gr, int px, int py, int width, int height);
    
    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
	    draw(gr, 0, 0, getWidth()-1, getHeight()-1);
    }
}
