package es29;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    public String nome;
    public String identificativo;
    public List<String> idEsami;
    public List<Esame> listaEsami;

    // bisogna trovare un modo per collegare il codice paziente ed il codice
    // esame avendo tutto quanto in qualche modo collegato
    public Persona(String nome, String identificativo) {
        this.nome = nome;
        this.identificativo = identificativo;
        this.idEsami = new ArrayList<>();
        this.listaEsami = new ArrayList<>();
    }

    public void addEsame(Esame esame) {
        this.idEsami.add(esame.codiceIdentificativoEsame);
        this.listaEsami.add(esame);
        System.out.println("al paziente numero " + this.identificativo + " ha fatto questo esame "
                + esame.codiceIdentificativoEsame);

    }

    public void showEsami() {
        this.listaEsami.forEach(x -> System.out
                .println("gli esami del paziente sono " + x.codiceIdentificativoEsame + " " + x.tipoEsame));
    }

    public void visualizzaDettagliEsame() {

        for (Esame esame : listaEsami) {
            esame.visualizzaDettagli();
        }
    }

    public void cercaEsame(String codiceIdentificativoEsame) {
        boolean esameTrovato = false;
        for (Esame esame : listaEsami) {
            if (codiceIdentificativoEsame.equals(esame.codiceIdentificativoEsame)) {
                System.out.println("esame trovato");
                esame.visualizzaDettagli();
                esameTrovato = true;
                break;
            }
        }
        if (esameTrovato) {
            return;
        } else {
            System.out.println("esame " + codiceIdentificativoEsame + " non trovato");
        }

    }

}

// for (Esame esame : listaEsami) {
// if (esame instanceof EsameRadiologico) {
// EsameRadiologico esameRadiologico = (EsameRadiologico) esame;
// int numeroOssaRotte = esameRadiologico.getNumeroOssaRotte();
// boolean ossaRotte = esameRadiologico.isOssaRotte();
// System.out.println("numeroOssaRotte: " + numeroOssaRotte);
// System.out.println("Ossa Rotte: " + ossaRotte);
// }
// else if (esame instanceof EsameSangue)
// {
// EsameSangue esameSangue = (EsameSangue) esame;
// int lvColesterolo = esameSangue.getLvColesterolo();
// boolean diabete = esameSangue.isDiabetico();
// System.out.println("lv colesterollo : " + lvColesterolo);
// System.out.println("diabete :" + diabete);
// }
// }