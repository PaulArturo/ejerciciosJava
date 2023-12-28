package Concurrencia;
import Concurrencia.Contador;

public class ConcurrenciaContadorR implements Runnable{
    private final Contador contador;
    
    public ConcurrenciaContadorR(Contador contador){
        this.contador = contador;
    }
    
    public void run(){
        contador.incrementar();
        contador.pintar();
    }
}
