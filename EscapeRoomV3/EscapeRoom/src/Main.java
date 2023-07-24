package EscapeRoomV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Carica il contenuto del file JSON in una stringa
        String jsonContent = loadJSONFile("dialogues.json");

        // Analizza il contenuto JSON
        JSONObject jsonObject = new JSONObject(jsonContent);
        JSONArray dialoguesArray = jsonObject.getJSONArray("dialogues");



        boolean uscitoDallaStanza = false;
        boolean morto = false;
        boolean nightmareMode = false;
        Scanner tastiera = new Scanner(System.in);
        System.out.println("inserisci la velocita del testo (1 = lenta,2 = media, 3 = veloce, 4 molto veloce)");
        int velocitaTesto; // VELOCITA Testo che verrà passata a tutte le scritte del gioco
        try {
            int velocitaTestoUtente = Integer.parseInt(tastiera.nextLine());
            velocitaTesto = selezionaVelocitaTesto(velocitaTestoUtente); // metodo con il quale si creà la velocita
                                                                         // testo nel momento in cui l'utente ha scritto
                                                                         // un valore corretto
        } catch (NumberFormatException e) {
            velocitaTesto = 5;
            printAnimated("non hai scelto un valore valido, vbb tieniti il testo molto veloce", velocitaTesto); // se
                                                                                                                // l'utente
                                                                                                                // inserisce
                                                                                                                // un
                                                                                                                // input
                                                                                                                // invalido
                                                                                                                // seleziona
                                                                                                                // questo
        }
        Inventario inventario = new Inventario();
        Map<Integer, String> ListaSceltePreda1 = new HashMap<Integer, String>();

        ListaSceltePreda1.put(1, "vedi un grimaldello affianco a te");
        ListaSceltePreda1.put(2, "una mattonella rotta");
        ListaSceltePreda1.put(3, "un letto ");
        ListaSceltePreda1.put(4, "un muro ombroso ");
        ListaSceltePreda1.put(5, "una fiaccola sul muro ");
        ListaSceltePreda1.put(6, "porta ");
        ListaSceltePreda1.put(7, "bottone ");
        ListaSceltePreda1.put(8, "comodino ");
        ListaSceltePreda1.put(9, "armadio ");
        ListaSceltePreda1.put(10, "specchio ");
        ListaSceltePreda1.put(11, "fessura a forma di cuore");
        ListaSceltePreda1.put(20, "inventario ");
        ListaSceltePreda1.put(30, "fondi oggetti ");
        while (uscitoDallaStanza == false && nightmareMode == false && morto == false) {
            printAnimated(
                    "ti risvegli in una stanza buia illuminata solo dalla luce di una fiaccola mezza spenta \n la stanza nonostante sia in delle condizioni pessime, con del sangue ovunque ha comunque sia un qualcosa di moderno, vedi delle luci in cima ",
                    velocitatesto);
            showScelte(ListaSceltePreda1);
            String inputUtente = tastiera.nextLine();
            switch (inputUtente) {
                case "1": // grimaldello
                    if (ListaSceltePreda1.containsKey(1)) {
                        Oggetto grimaldello = new Grimaldello("grimaldello") {

                        };
                        printAnimated(grimaldello.oggettoRaccolto(), velocitaTesto);
                        inventario.aggiungiOggetto(grimaldello);
                        ListaSceltePreda1.remove(1);
                        break;
                    } else {
                        System.out.println("numero non valido");
                        break;
                    }
                    break;
            }
            tastiera.close();
        }
    }

    private static String loadJSONFile(String string) {
        return null;
    }

    // Metodo VisualizzazioneScelte, questo metodo fa in modo che nel terminale le
    // scelte vengano visualizzate visivamente bene, controllando se sono pari o
    // meno , ed accollandole in modo carine
    public static void showScelte(Map<Integer, String> listaScelte) {
        for (Map.Entry<Integer, String> entry : listaScelte.entrySet()) {
            if (entry.getKey() % 2 == 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " ");
            } else {
                System.out.print(entry.getKey() + ": " + entry.getValue() + "\t");
            }

        }
    }

    // Metodo Velocita Testo

    public static int selezionaVelocitaTesto(int velocitaTestoUtente) throws InterruptedException {
        if (velocitaTestoUtente == 1) {
            velocitaTestoUtente = 100;
            printAnimated("hai scelto testo lento", velocitaTestoUtente);
            return velocitaTestoUtente;
        } else if (velocitaTestoUtente == 2) {
            velocitaTestoUtente = 50;
            printAnimated("hai scelto testo normale", velocitaTestoUtente);
            return velocitaTestoUtente;

        } else if (velocitaTestoUtente == 3) {
            velocitaTestoUtente = 20;
            printAnimated("hai scelto testo veloce", velocitaTestoUtente);
            return velocitaTestoUtente;

        } else {
            velocitaTestoUtente = 5;
            printAnimated("hai scelto testo molto veloce", velocitaTestoUtente);
            return velocitaTestoUtente;
        }
    }

    // Metodo per stampare tutte le cose con la velocità che vuole l'utente
    public static void printAnimated(String action, int time) throws InterruptedException {
        for (char c : action.toCharArray()) {
            System.out.print(c);
            Thread.sleep(time); // aggiunto il tempo tra una riga e l'altra
        }
        System.out.println(); // Stampa una nuova riga alla fine di ogni azione
    }

}
