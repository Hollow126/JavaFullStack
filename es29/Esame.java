package es29;

public abstract class Esame {
    public String codiceIdentificativoEsame;
    public String tipoEsame;
    public int priorita;
    public String dettagli;

    public Esame(String codiceIdentificativoEsame, String tipoEsame, int priorita, String dettagli) {
        this.codiceIdentificativoEsame = codiceIdentificativoEsame;
        this.tipoEsame = tipoEsame;
        this.priorita = priorita;
        this.dettagli = dettagli;
    }

    public abstract void visualizzaDettagli();

}
