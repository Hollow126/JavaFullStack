package es26.zoo.concrete;

import es26.zoo.astratte.Mammifero;

public class Leone extends Mammifero {
    public Leone(String nomeProprio) {
        super(nomeProprio);
    }

    public String getSpecieAnimale() {
        return "leone";
    }

}
