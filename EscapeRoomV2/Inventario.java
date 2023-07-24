package EscapeRoomV2;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Oggetto> oggetti;

    public Inventario() {
        this.oggetti = new ArrayList<>();
    }

    public void aggiungiOggetto(Oggetto oggetto) {
        this.oggetti.add(oggetto);
    }

    public void rimuoviOggetto(Oggetto oggetto) {
        this.oggetti.remove(oggetto);
    }
}
