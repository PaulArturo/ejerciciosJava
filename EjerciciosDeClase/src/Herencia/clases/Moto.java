package Herencia.clases;
import Herencia.clases.Vehiculos;
import Herencia.Interface.Alquilable;

public class Moto extends Vehiculos implements Alquilable{
    private float precioAlquiler;
    public Moto(String combustible){
        super("Tierra",combustible);
    }
    public void dibujar(){
        System.out.println("MOTO");
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
