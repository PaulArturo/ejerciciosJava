package POO_ruleta_rusa;

import java.util.Random;

public class Pistola {
    private Integer posicioBalaActual;
    private Integer posicioBala;
    private static Random ran;

    public Pistola(){
        this.ran = new Random();
        this.posicioBala = ran.nextInt(6);
    }

    public void rodar_tambor(){
        System.out.println("PREPARATE, TE TOCA >:)");
        this.posicioBalaActual = ran.nextInt(6);
    }

    public Boolean disparar(){
        System.out.println("BANG!!!");
        return posicioBala.equals(posicioBalaActual);
    }

    public String toString(){
        return this.posicioBala+" "+this.posicioBalaActual;
    }

    public static Random setRan(){
        return ran==null ? new Random() : ran;
    }
}
