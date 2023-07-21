package es29;

public class EsameSangue extends Esame{
    public boolean diabete;
    public int lvColesterolo;

    public EsameSangue(String codiceIdentificativoEsame, String tipoEsame, int priorita, String dettagli,boolean diabete, int lvColesterolo) {
        super(codiceIdentificativoEsame, tipoEsame, priorita, dettagli);
        this.diabete = diabete;
        this.lvColesterolo = lvColesterolo;
    }
     public int getLvColesterolo() {
         return lvColesterolo;
     }
     public boolean isDiabetico(){
        return diabete;
     }

    @Override
     public void visualizzaDettagli(){
        System.out.println(this.codiceIdentificativoEsame + this.dettagli + this.priorita + this.tipoEsame + this.lvColesterolo + this.diabete);
     }
}
