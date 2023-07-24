public class Oggetto {
    private String nomeOggetto;
    public Oggetto(String nomeOggetto) {
       this.nomeOggetto = nomeOggetto;
    }

    public void oggettoUsatoCorrettamente() {
        System.out.println("il " + nomeOggetto + " si è rotto ed è stato usato correttamente");
    }

    public void oggettoUsatoErroneamente() {
        System.out.println("il " + nomeOggetto + " si è rotto ed è stato usato erroneamente");
    }

    public void oggettoRaccolto()
    {
        System.out.println("il " + nomeOggetto + " è stato raccolto");
    }

}
