/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package components;

/**
 *
 * @author diogo
 */
public enum Piece {
    WALL('#'),
    PLAYER('@'),
    BLOCK('$'),
    GOAL('.'),
    BLOCKGOAL('*'),
    PLAYERGOAL('+'),
    EMPTY(' ');

    private final char ch;

    private Piece(char ch) {
        this.ch = ch;
    }

    public char getChar(){
        return ch;
    }
    
    public static Element getElement(char ch){
        if(ch == WALL.ch) return new Wall();
        if(ch == BLOCK.ch) return new Block();
        if(ch == GOAL.ch) return new Goal();
        if(ch == BLOCKGOAL.ch) return new Block(true);
        if(ch == PLAYERGOAL.ch) return new Goal();
        return new Empty();
    }
    
}
