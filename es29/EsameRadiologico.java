package es29;

public class EsameRadiologico extends Esame {
    public boolean ossaRotte;
    public int numeroOssaRotte;

    public EsameRadiologico(String codiceIdentificativoEsame, String tipoEsame, int priorita, String dettagli,
            boolean ossaRotte, int numeroOssaRotte) {
        super(codiceIdentificativoEsame, tipoEsame, priorita, dettagli);
        this.ossaRotte = ossaRotte;
        this.numeroOssaRotte = numeroOssaRotte;
    }

    public int getNumeroOssaRotte() {
        return numeroOssaRotte;
    }

    public boolean isOssaRotte() {
        return ossaRotte;
    }
    @Override
     public void visualizzaDettagli(){
        System.out.println(this.codiceIdentificativoEsame + this.dettagli + this.priorita + this.tipoEsame + this.numeroOssaRotte + this.ossaRotte);
     }
}
