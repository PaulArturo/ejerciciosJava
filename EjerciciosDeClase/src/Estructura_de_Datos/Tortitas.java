package Estructura_de_Datos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Tortitas {
    public static void Programa1(){
        boolean fin = false;
        Queue<Integer> pila = new LinkedList<>();
        Scanner input= new Scanner(System.in);
        System.out.println("Hola que tal");
        int[] tortitas;        

        tortitas = IntStream.rangeClosed(1, input.nextInt()).toArray();

        while(!fin){
            System.out.print("Array : ");
            for(int i=0; i<tortitas.length; i++){
                System.out.print(tortitas[i]);
            }System.out.println();

            int element = input.nextInt();
            fin = element==0;
            if(fin){break;}
            int dirE;//Direccion al elemento
            int rango=tortitas.length;

            for(dirE = rango-1; dirE>0 && tortitas[dirE]!=element; dirE--){
                pila.add(tortitas[dirE]);
            }

            if(element<=rango && element>=0){
                pila.add(tortitas[dirE]);
                for(; dirE<rango; dirE++){
                    tortitas[dirE]=pila.remove();

                }
            }

            System.out.print("Array despues de cambios : ");
            for(int i=0; i<tortitas.length; i++){
                System.out.print(tortitas[i]);
            }System.out.println();

        }
    }
}
