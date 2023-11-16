/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repaso.ej1;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class programa {
operand op;
  int numA;
  int numB;

  public programa(operand op, int numA, int numB){

    this.op=op;
    this.numA=numA;
    this.numB=numB;

  }

  public void calc(){

    int result;
    System.out.println(toString());
    result = op.operated(this.numA, this.numB);
    System.out.println(result);

  }
  
  public static programa leer(){
  
      Scanner input;
      programa question;
      int numA;
      int numB;
      String operation;
      operand op;
      
      input = new Scanner(System.in);
      System.out.print("operand A : ");
      numA = input.nextInt();
      System.out.print("operand B : ");
      numB = input.nextInt();
      operand.options();
      operation = input.next().toUpperCase();

      
      op = Enum.valueOf(operand.class, operation);
      question = new programa(op, numA, numB);
      
      input.close();
      
      return question;
  }

@Override
  public String toString(){
    return numA+op.getName()+numB;
  }    
}
