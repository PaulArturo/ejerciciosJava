/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repaso.ej4;
import Repaso.ej4.operations;
/**
 *
 * @author Usuario
 */
public class programa {

    public static void proces(){
        operations player1 = operations.PIEDRA;
        operations player2 = operations.TIJERAS;

        if (player1.beats(player2)) {
            System.out.println("Player 1 gana.");
        } else if (player2.beats(player1)) {
            System.out.println("Player 2 gana.");
        } else {
            System.out.println("Empate.");
        }    
    }
}
