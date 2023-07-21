package es26.zoo.concrete;    // bisognerebbe modificare i package x fare in modo di non partire dalla root dle es 26 ma solo da astratte e concrete mettendo il main insieme allo stesso livello delle 2 cartelle

public class main {
    public static void main(String[] args) {
        Leone leone = new Leone("emanuele");

        String specie = leone.getSpecieAnimale();
        String ordine = leone.getOrdineAnimale();
        String nomeProprio = leone.getNomeProprioAnimale();
        leone.print();
        System.out.println("/n fatto nella classe " + specie + " " + ordine+ " " + nomeProprio);
    }

}
