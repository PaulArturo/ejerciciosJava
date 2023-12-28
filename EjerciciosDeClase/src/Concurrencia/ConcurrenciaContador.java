package Concurrencia;
import Concurrencia.Contador;

public class ConcurrenciaContador extends Thread{
    private final Contador contador;

    public ConcurrenciaContador(Contador contador){
        this.contador = contador;
    }    

    public void run(){
        contador.incrementar();
        contador.pintar();
    }
}
