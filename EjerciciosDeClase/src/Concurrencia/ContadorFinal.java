package Concurrencia;

public class ContadorFinal implements Runnable{
    private final Contador contador;
    private int ID;
    private static int numbers=0;
    private static int threads_treballant = 0;
    private static final int MAX_THREADS = 5;

    public ContadorFinal(Contador contador){
        this.contador = contador;
        ID = ++numbers;
    }

    @Override
    public void run(){
        try{
            synchronized(contador){
                while (threads_treballant>=MAX_THREADS) {
                    contador.wait();
                }
                threads_treballant++;
            }

            Thread.sleep(3000);

            synchronized(contador){
                contador.incrementar();
                contador.pintar();
                contador.notify();
            }
        }catch(InterruptedException e){

        }
    }


}
