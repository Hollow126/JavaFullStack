public class Grimaldello extends Oggetto {

    public Grimaldello(String nomeOggetto) {
        super(nomeOggetto);
    }

    @Override
    public void oggettoUsatoCorrettamente() {
        System.out.println("il grimaldello si è rotto ed è stato usato correttamente");
    }

    @Override
    public void oggettoUsatoErroneamente() {
        System.out.println("il grimaldello si è rotto ed è stato usato erroneamente");
    }

    @Override
    public String oggettoRaccolto() {
        System.out.println("raccogli il grimaldello da terra");

    }
}
