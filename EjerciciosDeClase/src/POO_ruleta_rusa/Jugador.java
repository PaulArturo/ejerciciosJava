package POO_ruleta_rusa;

public class Jugador {
    private Integer id;
    private String nom;
    private Boolean esViu;
    private static Integer nomJugadors;

    public Jugador(String nom){
        this.nom=nom;
        this.id = (this.nomJugadors==null) ? 1 : ++this.nomJugadors;
        this.nomJugadors=this.id;
        this.esViu = true;
    }

    public String toString(){
        String mesage="El ID del jugador es "+id+" y su nombre es "+nom+" y esta "+(esViu ? "vivo" : "muerto ");
        return mesage;
    }

    public static int getTotal_jugadors(){
        return nomJugadors==null ? 0 : nomJugadors;
    }

    public boolean esViu(){
        return this.esViu;
    }

    public void torn(Pistola p){
        System.out.println(this.toString());
        p.rodar_tambor();
        this.esViu = !p.disparar();
        System.out.println(this.toString());
    }
}
