/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repaso.ej3;
import java.util.stream.Stream;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class ej4 {
 
    public static void proceso()throws Exception{
        String[] lines = programa.leer("text.txt");
        ArrayList filters = programa.filters(lines);
        programa.mostrar(filters);
        programa.sumar(filters);
    
    }
    
}