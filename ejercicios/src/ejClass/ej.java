/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejClass;
import java.lang.Readable;
import java.lang.Math;
/**
 *
 * @author Usuario
 */
public class ej implements Runnable{
    
    private int[] enteros;
    private final int Range=100;
    
    public ej(int [] enteros){
        this.enteros = new int[enteros.length];
        for(int i=0; i<enteros.length; i++){
            this.enteros[i]=enteros[i];
        }
    }
    private void ordenacio(){
        int aux, j;
        for(int i= enteros.length-2; i>=0; i--){
            aux=enteros[i];
            j=i;
            while(enteros[j+i]<aux){
                enteros[j]=enteros[j-1];
                j++;
            }
            enteros[j]=aux;
        }
    }
    @Override
    public void run(){
        int[] list = new int[100];
        for(int i : list){
            i=(int)Math.random()*(Range+1);
        }
        ej ordenable = new ej(list);
        ordenable.ordenacio();
        String out="";
        for(int i : ordenable.enteros){
            out=out+i+" ";
        }
        System.out.println(out);
    }
}
