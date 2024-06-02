/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classe PlayGame que inicializa a primeira form e aplica o tema FlatDarkLaf 
 * https://www.formdev.com/flatlaf/
 * 
 * @author diogo
 */

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PlayGame {

    public static void main(String[] args) {
        try {
            // aplica o tema FlatDarkLaf
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Cria e apresenta a form SokobanMenu
        SwingUtilities.invokeLater(() -> {
            new gui.SokobanMenu().setVisible(true);
        });
    }
}


