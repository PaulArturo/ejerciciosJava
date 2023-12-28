package Estructura_de_Datos;
import java.util.HashSet;
import java.util.Scanner;

public class Calcetines {
    public static void principal(){
        int [] calcetines = calcetines();
        int maxSize = procesar(calcetines);
        System.out.println("El tamaño maximo es : " + maxSize);
    }
    public static int[] calcetines(){
        Scanner input = new Scanner(System.in);
        int[] calcetines;

        System.out.println("Ingrese la cantidad de calcetines : ");
        int cantidad = input.nextInt();

        System.out.println("Ingrese los calcetines : ");
        calcetines = new int[cantidad];
        for(int i=0; i<cantidad; i++){
            calcetines[i] = input.nextInt();
        }
        input.nextLine();
        input.close();
        return calcetines;
    }

    public static int procesar(int [] calcetines){
        int maxSize=0;

        HashSet<Integer> mesa = new HashSet<>();
        for(int i=0; i<calcetines.length; i++){
            if(!mesa.add(calcetines[i])){
                mesa.remove(calcetines[i]);
            }else{
                maxSize = mesa.size() > maxSize ? mesa.size() : maxSize;
            }
        }

        return maxSize;
    }
}
