package com.example;

import java.util.Comparator;
import java.util.List;

public class Combattimento {

    public void inizioCombattimento(List<EntitaGiocante> personaggi) {
        boolean fineCombattimento = false;
        int turni = 0;
        while (fineCombattimento == false) {
            showPersonaggi(personaggi); // fa la lista della tua swuadra e suadra nemiga
            List<EntitaGiocante> pgInVeloxOrder = putInVeloxOrder(personaggi);
            showVeloxOrder(pgInVeloxOrder);
            turni++;
            break;
        }

    }

    // metodo creato per fare in modo che all'inizio di ogni turno si possa vedere i
    // membri della tua squadra e i membri della squadra avversaria
    // cicla 2 volte tutta la lista, nel primo ciclo stampa il tuo team controllando
    // se il valore isAlley è true stampando il nome e la vita
    // la seconda volta controlla se il valore e falso stampando il team nemico con
    // nome e vita

    private void showPersonaggi(List<EntitaGiocante> personaggi) {
        System.out.println("la tua squadra è: \n");
        for (EntitaGiocante personaggio : personaggi) {
            if (personaggio.isAlley == true) {
                System.out.println(personaggio.getNome() + "" + "la sua vita è " + personaggio.getVita() + "\n");
            }
        }
        System.out.println("i nemici sono: \n");
        for (EntitaGiocante personaggio : personaggi) {
            if (personaggio.isAlley == false) {
                System.out.println(personaggio.getNome() + "" + "la sua vita è " + personaggio.getVita() + "\n");
            }
        }
    }

    // metodo che passandogli in input la lista di personaggi,riordina la lista in modo che il primo elemento della lista sia i personaggio con la velocità più alta,
    // e procede a restituire la nuova lista in ordine di velocità 

    private List<EntitaGiocante> putInVeloxOrder(List<EntitaGiocante> personaggi) {
        personaggi.sort(Comparator.comparingInt(EntitaGiocante::getVelocita).reversed());
        return personaggi;
    }

    // metodo che stampa la nuova lista con l'ordine di velocità
    public void showVeloxOrder(List<EntitaGiocante> pgInVeloxOrder) {
        int i= 1;
        for (EntitaGiocante pgVelox : pgInVeloxOrder) {
            System.out.println(pgVelox.getNome() + "valore velocità: " + pgVelox.getVelocita() + " e il " + i+ " ad attaccare " );
            i++;
        }
    }
}
