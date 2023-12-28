package Estructura_de_Datos;
import java.util.HashSet;
import java.util.Scanner;

public class Colgado {  
    
    public static String Procesar(){
        Scanner scan = new Scanner(System.in);
        HashSet<Character> Word = new HashSet<>();
        HashSet<Character> trying = new HashSet<>();

        String hidenWord = scan.nextLine().toUpperCase();

        for(char leter : hidenWord.toCharArray()){
            Word.add(leter);
        }
        System.out.println(Word.toString());
        String tryingWord = scan.nextLine().toUpperCase();

        for(char leter : tryingWord.toCharArray()){
            if(!trying.add(leter)){
                continue;
            }
            if(Word.contains(leter)){
                Word.remove(leter);
            }
            if(Word.isEmpty()){
                return "Salvado";
            }
            if(trying.size() > 7){
                return "Ahorcado";
            }
        }
        System.out.println(trying.toString());
        System.out.println(Word.toString());
        return "Colgado";
    }
}
