/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
/**
 *
 * @author Usuario
 */
public class programa{

  public static String[] leer(String page)throws IOException{

    FileReader file = new FileReader(page);
    BufferedReader read = new BufferedReader(file);
    String line1 = read.readLine();
    String line2 = read.readLine();
    String [] text = {line1, line2};
    return text;

  }

  public static void mostrar(ArrayList<Matcher> filters){
    StringBuilder output = new StringBuilder();
    for(Matcher filter : filters){
      while(filter.find()){
        output.append(filter.group());
        output.append(" ");
      }
      output.append("\n");
      filter.reset();
    }
    System.out.println(output);
  }

  public static void sumar(ArrayList<Matcher> filter){
      //int Integers = 0;
      filter.forEach(f->{
        double sum=0;
        while(f.find()){
            sum = Double.parseDouble(f.group())+sum;
        }
        System.out.println(sum);
        f.reset();
      });    
  }
  
  public static ArrayList<Matcher> filters(String[] text){

    ArrayList<Matcher> filt = new ArrayList<Matcher>();
    Pattern Enteros = Pattern.compile("[-+]?\\d+");
    Pattern Decimales = Pattern.compile("[-+]?\\d*\\.\\d+");
    filt.add(Enteros.matcher(text[0]));
    filt.add(Decimales.matcher(text[1]));
    //System.out.println(text);
    
    return filt;
  }

}
