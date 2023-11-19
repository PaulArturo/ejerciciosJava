package POO_ruleta_rusa;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Juego {
    private Jugador[] jugadors;
    private Pistola pistola;
    private Integer ronda;
    private static String[] noms={"Joan", "Miquel", "Maria", "Bàrbara", "Toni", "Xisca"};
    private static Integer Min=2;
    private static Integer Max=noms.length;

    private interface comparaNum {
        public Integer compara(Integer num);
    }

    comparaNum op = num -> Math.min(Math.max(num, Min), Max);

    public Juego(Integer nomDeJugadors){  
        nomDeJugadors = op.compara(nomDeJugadors);
        this.jugadors = new Jugador[nomDeJugadors];
        this.pistola = new Pistola();
        
        IntStream
            .range(0, nomDeJugadors)
            .forEach(num->{
                jugadors[num]= new Jugador(noms[num]);
            });
    }

    public Boolean fiDeJoc(){
        return Arrays
            .stream(jugadors)
            .allMatch(J -> J.esViu());
    }

    public void ronda(){
        
        //Presentacio
        Arrays.stream(this.jugadors)
            .forEach(J->System.out.println(J.toString()));
        
        //Matense
        this.ronda = Stream
            .generate(()->{
            return (int)Arrays
                .stream(jugadors)
                .takeWhile(J->{
                    System.out.println("_________________________________________________________________");
                    J.torn(this.pistola);
                    System.out.println("_________________________________________________________________");
                    return J.esViu();
                })
                .count();
            })
            .takeWhile(I->fiDeJoc())
            .reduce(0,Integer::sum);
    }

    public Integer getRonda(){
        return this.ronda;
    }
}
