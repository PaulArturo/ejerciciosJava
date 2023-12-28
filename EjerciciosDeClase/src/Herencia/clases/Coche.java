package Herencia.clases;
import Herencia.Interface.Alquilable;
import Herencia.clases.Vehiculos;

public class Coche extends Vehiculos implements Alquilable{
    private float precioAlquiler;
    Coche(String combustible){
        super("Tierra",combustible);
    }
    public void dibujar(){
        System.out.println("COCHE");
    }
    @Override
    public void alquilar(float precio){
        this.precioAlquiler=precio;
    }
    @Override
    public float getPrecio(){
        return this.precioAlquiler;
    }
}
