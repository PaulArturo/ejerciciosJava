package Concurrencia;
import Concurrencia.ConcurrenciaContadorR;
import Concurrencia.Contador;

public class index {

    public static void iniciar() throws InterruptedException{
    
    Contador contador = new Contador();

    Thread[] hilos = new Thread[10];

    for(Thread hilo : hilos){
        hilo = new Thread(new ContadorFinal(contador));
        hilo.start();
        hilo.join();
    }

    }
}