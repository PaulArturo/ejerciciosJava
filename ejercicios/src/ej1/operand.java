/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;
import java.lang.*;
/**
 *
 * @author Usuario
 */
public enum operand {
    ADD("+"), SUB("-"), MULT("*"), DIV("/"), POW("^"), RES("%");
  
    private String operand;

    private operand(String operand){

      this.operand = operand;

    }

    public int operated(int numA, int numB){

      switch(this.operand){

        case("+"): return numA+numB;
        case("-"): return numA-numB;
        case("*"): return numA*numB;
        case("^"): return (int)Math.pow(numA,numB);
        case("/"): return numA/numB;
        case("%"): return numA%numB;
        default: return 0;


      }

    }
    
    public String getName(){
        return operand;
    }
    
    public static void options(){
        System.out.println("ADD | SUB | MULT | DIV | POW | RES");
    }
}
