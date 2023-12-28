package Estructura_de_Datos;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

public class Teclado {

    private LinkedList<Character> lletres;
    private ListIterator<Character> pointer;
    private static Map<Character, OpTeclado> opMap = new HashMap<>(Map.of(
            '+', (teclado) -> {
                if(!teclado.lletres.isEmpty())
                    teclado.pointer = teclado.lletres.listIterator(teclado.lletres.size()-1);
                },
            '-', (teclado)->{teclado.pointer = teclado.lletres.listIterator();},
            '3', (teclado)->{
                if(teclado.lletres.size() > teclado.pointer.nextIndex()){
                    teclado.pointer.next();
                    teclado.pointer.remove();
                }
            },
            '*', (teclado)->{
                teclado.pointer.next();
            }
        ));

    public Teclado(){
        lletres = new LinkedList<>();
        pointer = lletres.listIterator();
    }

    public void proceso(char input){
        if(opMap.containsKey(input)){
            opMap.get(input).hacer(this);
        }else{
            pointer.add(input);
        }
    }

    public String toString(){
        StringBuilder resultat = new StringBuilder();
        lletres.listIterator().forEachRemaining((lletra)->{
            resultat.append(lletra);
        });
        return resultat.toString();
    }

    public interface OpTeclado {
        public void hacer(Teclado teclado);
    }

    public static void proceso(){
        Teclado teclado = new Teclado();
        Scanner entrada = new Scanner(System.in);

        for (char CharArray : entrada.nextLine().toCharArray()) {
            teclado.proceso(CharArray);
        }
        System.out.println(teclado.toString());
        entrada.close();
    }
}

