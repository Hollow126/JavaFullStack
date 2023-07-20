package es26.zoo.astratte;

public abstract class Animale {
    private String ordineAnimale; // mammifero, rettile, pesce ecc
    private String specieAnimale;   // cane, gatto, cane ecc ecc
    private String nomeProprioAnimale; // gianni, franco, elisa 

    public Animale(String nomeProprioAnimale) {
        this.nomeProprioAnimale = nomeProprioAnimale;
    }

    public String getNomeProprioAnimale() {
        return nomeProprioAnimale;
    }

    public abstract String getOrdineAnimale();
    public abstract String getSpecie();


    public void print(){
        System.out.println("ordine " + getOrdineAnimale() + "specie " + getSpecie() + "nome proprio " + getNomeProprioAnimale());
    }
}