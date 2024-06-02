/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe Empty que representa um elemento vazio
 * @author diogo
 */
public class Empty extends Clear{
    
    // construtor da classe Empty que inicializa a cor a branco
    public Empty(){
        super(Color.WHITE);
    }
    
    // Método vazio, pois este elemento não tem nada para desenhar
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        }
    }

