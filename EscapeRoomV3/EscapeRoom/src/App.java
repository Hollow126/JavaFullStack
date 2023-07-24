import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean uscitoDallaStanza = false;
        boolean morto = false;
        boolean nightmareMode = false;
        Scanner tastiera = new Scanner(System.in);

        String lingua = selezioneLingua();
        int velocitaTesto = selezionaVelocitaTesto();

        // Carica il contenuto del file JSON
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(
                "C:/Users/Java/Documents/java-Local/java-FullStack-Assignement/EscapeRoomV3/EscapeRoom/src/dialogues.json"));
        // "./dialogues.json"));

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
            printAnimated(selezionaTestoDaJSON(jsonObject, "plot_text", lingua, 1), velocitaTesto);
            showScelte(ListaSceltePreda1);
            String inputUtente = tastiera.nextLine();
            switch (inputUtente) {
                case "1": // grimaldello
                    if (ListaSceltePreda1.containsKey(1)) {
                        Oggetto grimaldello = new Oggetto("grimaldello");
                        printAnimated(selezionaTestoDaJSON(jsonObject,"environmental_dialogues",lingua, 3), velocitaTesto);
                        inventario.aggiungiOggetto(grimaldello);
                        ListaSceltePreda1.remove(1);
                        break;
                    } else {
                        System.out.println("numero non valido");
                        break;
                    }
            }

        }
        tastiera.close();
    }

    // Metodo al quale si passa un oggetto Json, una categoria nella quale cercare
    // l'oggetto, una lingua dal quale scegliere ed infine un ID
    // ritorna il testo dalla categoria che si vuole, nella lingua selezionata
    public static String selezionaTestoDaJSON(JSONObject oggettoJson, String categoriaSelezionata,
            String linguaSelezionata, int idSelezionato) {
        JSONArray selectedCategoryArray = (JSONArray) oggettoJson.get(categoriaSelezionata);
        for (Object textObj : selectedCategoryArray) {
            JSONObject text = (JSONObject) textObj;
            int id = ((Long) text.get("id")).intValue();
            JSONObject translations = (JSONObject) text.get("text");
            String textContent = (String) translations.get(linguaSelezionata);

            if (id == idSelezionato) {
                // System.out.println(character + ": " + text);
                return textContent;
            } else {
                return " dialogo non trovato";
            }
        }
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

    // Metodo Selezione Lingua
    public static String selezioneLingua() {
        Scanner tastiera = new Scanner(System.in);

        try {
            String lingua = tastiera.nextLine();
            if (lingua == "it") {
                System.out.print("hai selezionato Italiano");
                tastiera.close();
                return "it";
            } else if (lingua == "en") {
                System.out.print("you selected english");
                tastiera.close();
                return "en";
            } else {
                System.out.print("hai selezionato predefinito italiano");
                tastiera.close();
                return "it";
            }
        } catch (NumberFormatException e) {
            System.out.print("hai selezionato predefinito italiano");
            tastiera.close();
            return "it";
            // se
            // l'utente
            // inserisce
            // un
            // input
            // invalido
            // seleziona
            // questo
        }
    }

    // Metodo selezione Velocita Testo
    // metodo con il quale si creà la velocita
    // testo nel momento in cui l'utente ha scritto
    // un valore corretto
    public static int selezionaVelocitaTesto() throws InterruptedException {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("inserisci la velocita del testo (1 = lenta,2 = media, 3 = veloce, 4 molto veloce)");
        try {

            int velocitaTestoInput = Integer.parseInt(tastiera.nextLine());
            if (velocitaTestoInput == 1) {
                velocitaTestoInput = 100;
                tastiera.close();
                printAnimated("hai scelto testo lento", velocitaTestoInput);
                return velocitaTestoInput;
            } else if (velocitaTestoInput == 2) {
                velocitaTestoInput = 50;
                printAnimated("hai scelto testo normale", velocitaTestoInput);
                tastiera.close();
                return velocitaTestoInput;
            } else if (velocitaTestoInput == 3) {
                velocitaTestoInput = 20;
                printAnimated("hai scelto testo veloce", velocitaTestoInput);
                tastiera.close();
                return velocitaTestoInput;
            } else {
                velocitaTestoInput = 5;
                printAnimated("hai scelto testo molto veloce", velocitaTestoInput);
                tastiera.close();
                return velocitaTestoInput;
            }
        } catch (Exception e) {
            printAnimated("hai scelto testo molto veloce", 5);
            tastiera.close();
            return 5;
            // se
            // l'utente
            // inserisce
            // un
            // input
            // invalido
            // seleziona
            // questo
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