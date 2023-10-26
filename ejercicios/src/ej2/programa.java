/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;
import java.lang.Math;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class programa {
    
    private static int range = 4;
    
    public static String generate(){
    
        int ran = (int)(Math.random()*range);
        switch(ran){
         case(0): return "asdf";
         case(1): return "paod";
         case(2): return "jkwl";
         case(3): return "powf";
         default: return "";
        }
    }
    
    public static void read(String password){
    
        Scanner input = new Scanner(System.in);
        int result;
        
        result = 1;
        
        for(int i=0; i<3 && result !=0 ; i++){
            result = input.nextLine().compareTo(password);        
        }
        
        if(result!=0)System.out.println("faild");
        else{System.out.println("true");}
        
        System.out.println(password);
    }
}
