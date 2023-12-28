package Herencia.clases;
import Herencia.clases.Vehiculos;

public class Barco extends Vehiculos {
    private boolean vela;
    
    public Barco(boolean vela){
        super("Agua", "Diesel");
        this.vela=vela;
    }
    @Override
    public String getInfo(){
        return super.combustible+" "+super.terreno+" "+this.vela;
    }
    @Override
    public void printInfo(){
        System.out.println(this.getInfo());
    }
    @Override
    public void dibujar(){
        System.out.println("BARCO");
    }
}
