package Herencia.clases;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;
import java.lang.reflect.Method;

import Herencia.clases.*;

public class Proceso {
    public static void principal(){
        var vehiculos = getVehiculos();
        pintarVehiculos(vehiculos);
        alquilar(vehiculos);

    }
    public static Vehiculos[] getVehiculos(){
        Vehiculos[] valor = {new Coche("gasolina"),
                             new Moto("AceiteGirasol"),
                             new Barco(true),
                             new Avion()};
        return valor;
    }
    public static void pintarVehiculos(Vehiculos[] vehiculos){
        Arrays.stream(vehiculos)
            .forEach(v->{
                v.printInfo();
                v.dibujar();
            });
    }

    public static void alquilar(Vehiculos[] vehiculos){
        HashSet<String> clasesAlquilables = new HashSet<>();
        clasesAlquilables.add(Coche.class.getSimpleName());
        clasesAlquilables.add(Moto.class.getSimpleName());

        Arrays.stream(vehiculos)
            .forEach(v->{
                Class<?> clase = v.getClass();
                if (clasesAlquilables.contains(clase.getSimpleName())){
                    try{
                    Method alquilar = clase.getMethod("alquilar", float.class);
                    alquilar.invoke(v, (float)5);
                    System.out.println("Hecho"+clase.getSimpleName());
                    }catch(Exception e){
                        System.out.println("Error al ejecutar \"Alquilar()\"");
                    }
                }

            });
    }
}
