package es28;

import java.util.ArrayList;
import java.util.List;
/**
 * Fattoria
 */
public class Fattoria {
    private List<Animale> animali;

    public Fattoria(){
        this.animali = new ArrayList<>();
    }

    public void aggiungiAnimale(Animale amimale){
        this.animali.add(amimale);
    }
    public void faRumore(){
        for (Animale animale : animali) {
            animale.faRumore(); 
        }
    }
}