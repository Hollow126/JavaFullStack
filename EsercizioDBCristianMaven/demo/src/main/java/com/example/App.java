package com.example;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// PER SISTEMARE IL PROBLEMA CON GLI IMPORT AGGIUNGERE IN BAASSO A SINISTRA IN REFERENCED LIBRARY IL FILE DEI DOWNLOAD 
public class App {
    public static void main(String[] args) throws Exception {
        boolean uscitoDallaStanza = false;
        boolean morto = false;
        boolean nightmareMode = false;
        Scanner tastiera = new Scanner(System.in);

        esercizioDB();

        // Creo una connessione al database
        String nomeDatabase = " defaultDb ";

        String url = "jdbc:sqlite:" + nomeDatabase + ".db";

        System.out.println("Connessione a SQLite stabilita.");

        Database database = new Database(url);

        database.createDatabase();
        Inventario inventario = new Inventario();
        Oggetto grimaldello1 = new Oggetto("grimaldello");

        Guerriero personaggio1 = new Guerriero(1, "Personaggio1", 5, 100, false, 100.0, 20, 10, 50);
        Guerriero personaggio2 = new Guerriero(2, "Personaggio2", 8, 200, true, 150.0, 30, 15, 70);

        Magia pallaDiFuoco = new Magia("palla di fuoco ", "prova", 5);
        Magia pallaDiGhiaccio = new Magia("palla di ghiaccio ", "prova",
                30);
        personaggio1.listaMagie.add(pallaDiFuoco);
        personaggio2.listaMagie.add(pallaDiFuoco);
        database.creaPersonaggioInDB(personaggio1);
        database.creaPersonaggioInDB(personaggio2);
        database.creaPersonaggioInDB(personaggio2);

        database.creaMagiaPerPersonaggioSeNonEsisteDB(personaggio1, pallaDiFuoco);
        database.creaMagiaPerPersonaggioSeNonEsisteDB(personaggio2, pallaDiFuoco);
        database.creaMagiaPerPersonaggioSeNonEsisteDB(personaggio1, pallaDiFuoco);
        database.creaMagiaPerPersonaggioSeNonEsisteDB(personaggio1, pallaDiGhiaccio);
        database.creaMagiaPerPersonaggioSeNonEsisteDB(personaggio2, pallaDiGhiaccio);
        database.creaMagiaPerPersonaggioSeNonEsisteDB(personaggio2, pallaDiGhiaccio);

        List<EntitaGiocante> listaEntitaGiocanti = new ArrayList<>();
        listaEntitaGiocanti.add(new Guerriero(2, "Personaggio2", 8, 200, true, 150.0, 30, 15, 70));
        listaEntitaGiocanti.add(new Guerriero(3, "Personaggio3", 10, 300, false, 200.0, 25, 12, 60));
        listaEntitaGiocanti.add(new Guerriero(4, "Personaggio4", 3, 50, true, 80.0, 15, 8, 40));
        listaEntitaGiocanti.add(new Guerriero(5, "Personaggio5", 12, 500, false, 250.0, 35, 20, 80));
        listaEntitaGiocanti.add(new Guerriero(6, "Personaggio6", 7, 150, true, 120.0, 25, 13, 55));
        listaEntitaGiocanti.add(new Guerriero(7, "Personaggio7", 2, 30, false, 70.0, 12, 6, 35));
        listaEntitaGiocanti.add(new Guerriero(8, "Personaggio8", 15, 800, true, 300.0, 40, 25, 90));
        listaEntitaGiocanti.add(new Guerriero(9, "Personaggio9", 9, 250, false, 180.0, 30, 15, 65));
        listaEntitaGiocanti.add(new Guerriero(10, "Personaggio10", 6, 120, true, 110.0, 22, 11, 48));
        listaEntitaGiocanti.add(new Guerriero(11, "Personaggio11", 14, 700, false, 280.0, 38, 23, 85));
        listaEntitaGiocanti.add(new Guerriero(12, "Personaggio12", 11, 400, true, 230.0, 33, 18, 75));
        listaEntitaGiocanti.add(new Guerriero(13, "Personaggio13", 4, 70, false, 90.0, 18, 9, 45));
        listaEntitaGiocanti.add(new Guerriero(14, "Personaggio14", 13, 600, true, 260.0, 36, 22, 82));
        listaEntitaGiocanti.add(new Guerriero(15, "Personaggio15", 10, 350, false, 210.0, 32, 17, 68));
        listaEntitaGiocanti.add(new Guerriero(16, "Personaggio16", 1, 10, true, 60.0, 10, 5, 30));
        listaEntitaGiocanti.add(new Guerriero(17, "Personaggio17", 18, 1000, false, 350.0, 45, 28, 95));
        listaEntitaGiocanti.add(new Guerriero(18, "Personaggio18", 16, 900, true, 320.0, 42, 26, 92));
        listaEntitaGiocanti.add(new Guerriero(19, "Personaggio19", 17, 950, false, 340.0, 44, 27, 94));
        listaEntitaGiocanti.add(new Guerriero(20, "Personaggio20", 19, 1100, true, 380.0, 48, 30, 98));

        for (EntitaGiocante personaggio : listaEntitaGiocanti) {
            database.creaPersonaggioInDB(personaggio);

        }

        Combattimento evento1 = new Combattimento();
        evento1.inizioCombattimento(listaEntitaGiocanti);

        // System.out.println("inserisci il nuovo nome del personaggio");
        // personaggio3.setNome(tastiera.nextLine());
        // database.modificaPersonaggio(personaggio3);

        // personaggio1.aggiungiMagia(pallaDiFuoco);
        // personaggio1.aggiungiOggetto(grimaldello1);
        String lingua = selezioneLingua();
        int velocitaTesto = selezionaVelocitaTesto();

        Map<Integer, String> ListaSceltePreda1 = new HashMap<Integer, String>();

        ListaSceltePreda1.put(1,

                selezionaTestoDaJSON("choiches.json", "choiches", lingua, 1));
        ListaSceltePreda1.put(2, selezionaTestoDaJSON("choiches.json", "choiches", lingua, 2));
        ListaSceltePreda1.put(3, selezionaTestoDaJSON("choiches.json", "choiches", lingua, 3));
        ListaSceltePreda1.put(4, selezionaTestoDaJSON("choiches.json", "choiches", lingua, 4));
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
            printAnimated(selezionaTestoDaJSON("plot_texts.json", "plot_texts", lingua, 1), velocitaTesto);
            showScelte(ListaSceltePreda1);
            String inputUtente = tastiera.nextLine();
            switch (inputUtente) {
                case "1": // grimaldello
                    if (ListaSceltePreda1.containsKey(1)) {
                        Oggetto grimaldello = new Oggetto("grimaldello");
                        printAnimated(
                                selezionaTestoDaJSON("environmental_dialogues.json", "environmental_dialogues", lingua,
                                        1),
                                velocitaTesto);
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

    private static void esercizioDB() {
        Scanner tastiera = new Scanner(System.in);

        boolean continua = true;

        String scelta = "";
        Database database;
        String nomeDatabase;
        System.out.println("come vuoi chiamare db ");
        try {
            nomeDatabase = tastiera.nextLine();
        } catch (Exception e) {
            nomeDatabase = " defaultDb ";
        }

        String urlEsercizio = "jdbc:sqlite:" + nomeDatabase + ".db";

        System.out.println("Connessione a SQLite stabilita.");
        database = new Database(urlEsercizio);
        database.createDatabase();
        System.out.println("database creato");
        while (continua) {
            System.out.println(
                    "1 x creare un altro database, 2 x inserire un personaggio, 3 per creare Csv, 4 x cambiare Database , 5 per terminare ");
            scelta = tastiera.nextLine();
            switch (scelta) {
                case "1":
                    String nomeNuovoDatabase;
                    System.out.println("come vuoi chiamare db ");
                    try {
                        nomeNuovoDatabase = tastiera.nextLine();
                    } catch (Exception e) {
                        nomeNuovoDatabase = " defaultDb ";
                    }

                    String urlNuovoDB = "jdbc:sqlite:" + nomeNuovoDatabase + ".db";

                    System.out.println("Connessione a SQLite stabilita.");
                    database = new Database(urlNuovoDB);
                    database.createDatabase();
                    System.out.println("database " + urlNuovoDB + " creato");
                    break;
                case "2":
                    try {
                        System.out.println("digita ID");
                        int idprova = Integer.parseInt(tastiera.nextLine());
                        System.out.println("digita nome");
                        String nome = tastiera.nextLine();
                        System.out.println("digita livello");
                        int livello = Integer.parseInt(tastiera.nextLine());
                        System.out.println("digita esp");
                        int esp = Integer.parseInt(tastiera.nextLine());
                        boolean alleato = true;
                        System.out.println("digita vita");
                        int vita = Integer.parseInt(tastiera.nextLine());
                        System.out.println("digita atk");
                        int atk = Integer.parseInt(tastiera.nextLine());
                        System.out.println("digita difesa");
                        int difesa = Integer.parseInt(tastiera.nextLine());
                        System.out.println("digita velocita");
                        int velocita = Integer.parseInt(tastiera.nextLine());
                        Guerriero pppp = new Guerriero(idprova, nome, livello, esp, alleato, vita, atk, difesa,
                                velocita);
                        database.creaPersonaggioInDB(pppp);
                    } catch (Exception e) {
                        System.out.println("valore non valido");
                        break;
                    }
                    break;
                case "3":
                    try {
                        String sqlPersonaggi = "SELECT (*) FROM personaggi"; 
                        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlPersonaggi);
            statement.execute(sqlMagie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
                        FileWriter csvWriter = new FileWriter("prodotti.csv");
                        csvWriter.append("id");
                        csvWriter.append(",");
                        csvWriter.append("nome");
                        csvWriter.append(",");
                        csvWriter.append("livello");
                        csvWriter.append(",");
                        csvWriter.append("esp");
                        csvWriter.append(",");
                        csvWriter.append("vita");
                        csvWriter.append(",");
                        csvWriter.append("atk");
                        csvWriter.append(",");
                        csvWriter.append("difesa");
                        csvWriter.append(",");
                        csvWriter.append("velocita");
                        csvWriter.append(",");
                        while () {
                            
                        }
                    } catch (Exception e) {
                        System.out.println("problemi col csv");
                    }
                    break;
                case "4":
                    continua = false;
                    break;
                default:
                    break;
            }
        }
    }
    // Metodo al quale si passa una categoria nella quale cercare
    // l'oggetto, una lingua dal quale scegliere ed infine un ID
    // ritorna il testo dalla categoria che si vuole, nella lingua selezionata

    public static String selezionaTestoDaJSON(String fileName, String selectedCategory, String selectedLanguage,
            int selectedId) throws Exception {
        // Carica il contenuto del file JSON
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(
                "C:/Users/Java/Documents/java-Local/java-FullStack-Assignement/MavenProva5/demo/src/main/java/com/example/JsonFiles/"
                        + fileName));
        JSONArray selectedCategoryArray = (JSONArray) jsonObject.get(selectedCategory);

        for (Object textObj : selectedCategoryArray) {
            JSONObject text = (JSONObject) textObj;
            int id = ((Long) text.get("id")).intValue();
            JSONObject translations = (JSONObject) text.get("text");
            String textContent = (String) translations.get(selectedLanguage);

            if (id == selectedId) {
                return textContent;
            }
        }

        // Se non viene trovato alcun testo con l'ID selezionato, restituisce una
        // stringa vuota.
        return "dialogo non trovato";
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
        System.out.println("select your language 1 = italiano, 2 = english");
        try {

            System.out.println(" ");
            int numeroLingua = Integer.parseInt(tastiera.nextLine());
            if (numeroLingua == 1) {
                System.out.print("hai selezionato Italiano");
                return "it";
            } else if (numeroLingua == 2) {
                System.out.print("you selected english");
                return "en";
            } else {
                System.out.print("hai selezionato predefinito italiano");
                return "it";
            }
        } catch (NumberFormatException e) {
            System.out.print("hai selezionato predefinito italiano");
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
                printAnimated("hai scelto testo lento", velocitaTestoInput);
                return velocitaTestoInput;
            } else if (velocitaTestoInput == 2) {
                velocitaTestoInput = 50;
                printAnimated("hai scelto testo normale", velocitaTestoInput);
                return velocitaTestoInput;
            } else if (velocitaTestoInput == 3) {
                velocitaTestoInput = 20;
                printAnimated("hai scelto testo veloce", velocitaTestoInput);
                return velocitaTestoInput;
            } else {
                velocitaTestoInput = 5;
                printAnimated("hai scelto testo molto veloce", velocitaTestoInput);
                return velocitaTestoInput;
            }
        } catch (Exception e) {
            System.out.println(e);
            printAnimated("input non valido selezionato testo molto veloce ", 5);
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
