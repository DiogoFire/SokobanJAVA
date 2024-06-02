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
 * Classe Sokoban que representa o jogo (componente dentro do SokobanMain)
 * @author diogo
 */
public class Sokoban extends JComponent implements KeyListener{
    
    // mapa do jogo representado por uma matriz
    Element[][] world;
    Player player;
    
    // nivel padrão
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
    
    // método para definir o puzzle do jogo
    public void setPuzzle(String txt){
        // divide em linhas
        String line[] = txt.split("\n");
        // define o tamanho horizontal
        world = new Element[line.length][];
        // loop para percorrer cada linha
        for (int y = 0; y < line.length; y++) {
            world[y] = new Element[line[y].length()];
            // loop para percorrer cada caracter
            for (int x = 0; x < line[y].length(); x++) {
                // cria um elemento com base no caractere correspondente
                world[y][x] = Piece.getElement(line[y].charAt(x));
                // verifica se o caracter corresponde ao jogador
                // se sim, define a sua posição
                if(line[y].charAt(x) == Piece.PLAYER.getChar()){
                    player = new Player(x, y);
                }
            }
        }
        // volta a pintar o componente
        repaint();
    }
    // verifica se o nível está completo
    public boolean isLevelComplete() {
        // loop para percorrer todas as linhas do mundo do jogo
        for (Element[] row : world) {
            // loop para percorrer cada elemento na linha
            for (Element element : row) {
                // Verifica se o elemento é um objetivo e não tem um bloco sobre ele
                if (element instanceof Goal && !(element instanceof Block)) {
                    return false; // há pelo menos um objetivo sem um bloco sobre ele
                }
            }
        }
        return true; // todos os objetivos têm um bloco sobre eles
    }
    
    // método para desenhar o componente
    public void paintComponent(Graphics gr){
        int w = getWidth() / getColumns();
        int h = getHeight() / getLines();
        // loop para percorrer todas as linhas do mundo do jogo
        for(int y = 0; y < world.length; y++){
            // loop para percorrer cada elemento na linha
            for(int x = 0; x < world[y].length; x++){
                // desenha o elemento na posição correspondente
                world[y][x].draw(gr, x * w, y* h , w, h );
            }
        }
        // desenha o jogador na posição atual no mundo do jogo
        player.draw(gr, player.getCoordX() * w, player.getCoordY() * h, w, h);
    }
    
    // getter para o numero de linhas
    public int getLines(){
        return world.length;
    }
    
    // getter para o numero de colunas
    public int getColumns(){
        int max = 0;
        for(Element[] line : world){
            max = Math.max(max, line.length);
        }
        return max;
    }
    
    // método para mover o jogador nas coordenadas X e Y
    public void moveXY(int dx, int dy){
        // calcula as novas coordenadas do jogador
        int newX = player.getCoordX() + dx;
        int newY = player.getCoordY() + dy;
        // verifica se não há colisão com uma célula vazia
        if (world[newY][newX] instanceof Clear) {
            // move o jogador para as novas coordenadas
            player.moveXY(dx, dy);
        }
        // verifica se há colisão com uma parede
        if (world[newY][newX] instanceof Wall) {
            return;
        }
        // verifica se há colisão com um bloco
        else if (world[newY][newX] instanceof Block block) {
            // calcula as coordenadas do bloco após o movimento
            int bx = newX + dx;
            int by = newY + dy;
            // verifica se não há colisão com uma célula vazia após o movimento
            if (world[by][bx] instanceof Clear) {
                // move o bloco para as novas coordenadas
                Boolean newGoal = block.inGoal;
                boolean blockGoal = world[by][bx] instanceof Goal;
                world[newY][newX] = newGoal ? new Goal() : new Empty();
                world[by][bx] = new Block(blockGoal);
                // move o jogador para as novas coordenadas
                player.moveXY(dx, dy);
            }
        }
        // volta a pintar
        repaint();
    }
   
    // método chamado quando uma tecla é pressionada
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
        // Verifica se o nível está completo e mostra o Dialog LevelCompleteDialog se for o caso
        if (isLevelComplete()) {
            LevelCompleteDialog dialog = new LevelCompleteDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
        }
    }
    
    // Métodos não utilizados, mas necessários para implementar a interface KeyListener
    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
