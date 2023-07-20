package es26.zoo.astratte;

public abstract class Mammifero extends Animale {
    public Mammifero(String nomeProprioAnimale) {
        super(nomeProprioAnimale);
    }
    public String getOrdineAnimale(){
        return "mammifero";
    }
}