package Herencia.clases;

import Herencia.Interface.Informacion;

public abstract class Vehiculos implements Informacion{
    protected String terreno;
    protected String combustible;

    Vehiculos(String terreno, String combustible){
        this.combustible=combustible;
        this.terreno=terreno;
    }
    @Override
    public String getInfo(){
        return terreno+" "+combustible;
    }
    @Override
    public void printInfo(){
        System.out.println(this.getInfo());
    }
}