package Concurrencia;

public class Contador {
    private int valor;
    
    public Contador() {
        valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void incrementar(){
        valor++;
    }
    public void pintar(){
        System.out.println(valor);
    }
}
