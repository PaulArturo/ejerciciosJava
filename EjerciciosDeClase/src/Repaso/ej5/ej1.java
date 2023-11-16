package Repaso.ej5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ej1 {

    interface Subprograma {
        void ejecutar();
    }

    public static void proceso() throws Exception{

        var source = new FileReader("text.txt");
        var endSources = new FileWriter("endtext.txt");
        var subprogramas = new HashMap<Integer, Subprograma>();
        var scanner = new Scanner(System.in);
        var ran = new Random();

        subprogramas.put(1, ()->programa1());
        subprogramas.put(2, ()->programa2(ran));
        subprogramas.put(3, ()->programa3(ran, scanner));
        subprogramas.put(4, ()->programa4(source, endSources));


        boolean completed=false;
        while (!completed) {
            try{
                logica(scanner, subprogramas);
                completed = true;
            }catch(NullPointerException e){
                System.out.println("Hubo un error vuelvelo a intentar");
            }
        }

        System.out.println("Saliendo del programa.");
        source.close();
        endSources.close();
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n---- Menú de Subprogramas ----");
        System.out.println("1. Subprograma 1");
        System.out.println("2. Subprograma 2");
        System.out.println("3. Subprograma 3");
        System.out.println("4. Subprograma 4");
        System.out.println("0. Salir");
    }

    public static void logica(Scanner scanner,Map<Integer, Subprograma> subprogramas){

        Stream.generate(()->{
            mostrarMenu();
            System.out.print("Elige el programa :");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        })
        .takeWhile(opcion->opcion!=0)
        .forEach(op->subprogramas.get(op).ejecutar());
    }

    public static void programa1(){
        IntStream.rangeClosed(1, 100)
            .filter(num->num%2!=0)
            .filter(num->num!=33 && num!=44 && num!=77)
            .filter(num->num%5!=0)
            .filter(num->num<70 || num>90)
            .forEach(System.out::println);
    }

    public static void programa2(Random num){
        Double result = IntStream
            .rangeClosed(1, 1000)
            .map(newnumber->newnumber=num.nextInt(11))
            .summaryStatistics()
            .getAverage();
        System.out.println(result);
    }

    public static void programa3(Random num, Scanner scanner){
        int ran = num.nextInt(101);

        Stream.generate(() -> scanner.nextInt())
            .peek(op -> {
                if (op != ran) {
                    String message = op < ran ? "Muy pequeño" : "Muy grande";
                    System.out.println(message);
                }
            })
            .takeWhile(op -> op != ran)
            .count();

    }

    public static void programa4(FileReader source, FileWriter endSources){
        var fileR = new BufferedReader(source);
        var fileW = new BufferedWriter(endSources);
        var solution = new HashMap<String, Integer>();
        
        solution.put("leters", 0);
        solution.put("words", 0);
        solution.put("lines",0);

        fileR.lines()
            .peek(line -> solution.put("lines", solution.getOrDefault("lines", 0) + 1))
            .flatMap(line -> Arrays.stream(line.split("\\s+")))
            .peek(word -> solution.put("leters", solution.getOrDefault("leters", 0) + word.length()))
            .forEach(word -> solution.put("words", solution.getOrDefault("words", 0) + 1));

        solution.forEach((key, value)->{
            String message = "Hay "+value+" de "+key;
            try{
                fileW.write(message+'\n');
            }catch(IOException e){
                System.out.println("Error de escritura");
            }
            System.out.println(message);
        });
        try{
            fileR.close();
            fileW.close();
        }catch(IOException e){
            System.out.println("Error al cerrar recursos");
        }
    }
}

