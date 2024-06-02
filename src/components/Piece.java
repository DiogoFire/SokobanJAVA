/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package components;

/**
 * enum Piece que é usado como uma biblioteca para os diferentes tipos de elementos no jogo
 * @author diogo
 */
public enum Piece {
    WALL('#'),         // parede
    PLAYER('@'),       // jogador
    BLOCK('$'),        // nloco (caixas)
    GOAL('.'),         // objetivo
    BLOCKGOAL('*'),    // bloco no objetivo
    PLAYERGOAL('+'),   // jogador no objetivo
    EMPTY(' ');        // espaço vazio

    
    // caracter associado à peça
    private final char ch;

    // construtor privado que associa um caracter a cada peça
    private Piece(char ch) {
        this.ch = ch;
    }

    // getter do caracter
    public char getChar(){
        return ch;
    }
    
    // metodo que verifica o caracter e retorna o elemento correspondente
    public static Element getElement(char ch){
        if(ch == WALL.ch) return new Wall();
        if(ch == BLOCK.ch) return new Block();
        if(ch == GOAL.ch) return new Goal();
        if(ch == BLOCKGOAL.ch) return new Block(true);
        if(ch == PLAYERGOAL.ch) return new Goal();
        return new Empty();
    }
    
}
