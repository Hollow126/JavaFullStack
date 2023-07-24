public abstract class Oggetto {

    public String nomeOggetto;

    public Oggetto(String nomeOggetto) {
        this.nomeOggetto = nomeOggetto;
    }
    public abstract String oggettoRaccolto();

    public abstract void oggettoUsatoCorrettamente();

    public abstract void oggettoUsatoErroneamente();

    
}
