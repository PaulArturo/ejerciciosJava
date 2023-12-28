package Herencia.clases;
import Herencia.clases.Vehiculos;

public class Avion extends Vehiculos{
    private Integer numPasajeros;
    public Avion(){
        super("Aire","Queroseno");
    }
    @Override
    public String getInfo(){
        return super.combustible+" "+super.terreno+" "+this.numPasajeros;
    }
    @Override
    public void printInfo(){
        System.out.println(this.getInfo());
    }
    @Override
    public void dibujar(){
        System.out.println("AVION");
    }
}
