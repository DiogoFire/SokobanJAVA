/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import gui.LevelCompleteDialog;
/**
 *
 * @author diogo
 */
public class Sokoban extends JComponent implements KeyListener{
    
    Element[][] world;
    Player player;
    
    static String defaultPuzzle = 
            """
               ###
              ## # ####
             ##  ###  #
            ## $      #
            #   @$ #  #
            ### $###  #
              #  #..  #
             ## ##.# ##
             #      ##
             #     ##
             #######
            """;
    
    
    // construtor por defeito
    public Sokoban(){
        setPuzzle(defaultPuzzle);
        addKeyListener(this);
        setFocusable(true);
    }
    
    public void setPuzzle(String txt){
        String line[] = txt.split("\n");
        world = new Element[line.length][];
        for (int y = 0; y < line.length; y++) {
            world[y] = new Element[line[y].length()];
            for (int x = 0; x < line[y].length(); x++) {
                world[y][x] = Piece.getElement(line[y].charAt(x));
                if(line[y].charAt(x) == Piece.PLAYER.getChar()){
                    player = new Player(x, y);
                }
            }
        }
        repaint();
    }
    
    public boolean isLevelComplete() {
        for (Element[] row : world) {
            for (Element element : row) {
                if (element instanceof Goal && !(element instanceof Block)) {
                    return false; // There's at least one goal without a block on it
                }
            }
        }
        return true; // All goals have a block on them
    }
    
    public void paintComponent(Graphics gr){
        int w = getWidth() / getColumns();
        int h = getHeight() / getLines();
        for(int y = 0; y < world.length; y++){
            for(int x = 0; x < world[y].length; x++){
                world[y][x].draw(gr, x * w, y* h , w, h );
            }
        }
        player.draw(gr, player.getCoordX() * w, player.getCoordY() * h, w, h);
    }
    
    public int getLines(){
        return world.length;
    }
    
    public int getColumns(){
        int max = 0;
        for(Element[] line : world){
            max = Math.max(max, line.length);
        }
        return max;
    }
    
    public void moveXY(int dx, int dy){
        int newX = player.getCoordX() + dx;
        int newY = player.getCoordY() + dy;
        if (world[newY][newX] instanceof Clear) {
            player.moveXY(dx, dy);
        }
        if (world[newY][newX] instanceof Wall) {
            return;
        }
        else if (world[newY][newX] instanceof Block block) {
            int bx = newX + dx;
            int by = newY + dy;
            if (world[by][bx] instanceof Clear) {
                Boolean newGoal = block.inGoal;
                boolean blockGoal = world[by][bx] instanceof Goal;
                world[newY][newX] = newGoal ? new Goal() : new Empty();
                world[by][bx] = new Block(blockGoal);
                player.moveXY(dx, dy);
            }
        }
        repaint();
    }
   
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                moveXY(0, -1); // CIMA
                break;
            case KeyEvent.VK_A:
                moveXY(-1, 0); // ESQUERDA
                break;
            case KeyEvent.VK_S:
                moveXY(0, 1); // BAIXO
                break;
            case KeyEvent.VK_D:
                moveXY(1, 0); // DIREITA
                break;
        }
        if (isLevelComplete()) {
            LevelCompleteDialog dialog = new LevelCompleteDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
