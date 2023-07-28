
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crea uno Scanner per leggere l'input dell'utente
        Scanner scanner = new Scanner(System.in);
        boolean fineProgramma = false;
        int scelta;
        boolean databaseCreato = dbEsistente();

        String dbName = "";

    


        while (fineProgramma == false) {
            // Stampa il menu
            System.out.println("Seleziona un'opzione:");
            System.out.println("1: Crea il database e le tabelle");
            System.out.println("2: Inserisci i dati nelle tabelle");
            System.out.println("3: Modifica i dati");
            System.out.println("4: Cancella i dati");
            System.out.println("5: Salva i dati in un file CSV");
            System.out.println("6: Per terminare il programma");

            // Leggi la scelta dell'utente
            try {
                scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        System.out.println("Inserisci il nome del database da creare:");
                        dbName = scanner.nextLine();
                        Crealo.main(new String[] { dbName });
                        databaseCreato = true;
                        break;
                    case 2:
                        System.out.println("Inserisci il nome del database nel quale inserire i dati:");
                        dbName = scanner.nextLine();
                        if (databaseCreato == true) {
                            InserisciDatiCollegati.main(new String[] { dbName });
                            break;
                        } else {
                            System.out.println("crea almeno un database prima di  inserire i dati: ");
                            break;
                        }
                    case 3:
                        System.out.println("Inserisci il nome del database del quale modificare i dati:");
                        dbName = scanner.nextLine();
                        if (databaseCreato == true) {
                            ModificaDati.main(new String[] { dbName });
                            break;
                        } else {
                            System.out.println("crea almeno un database prima di modificare i dati:");
                            break;
                        }
                    case 4:
                        System.out.println("Inserisci il nome del database dal quale cancellare i dati:");
                        dbName = scanner.nextLine();
                        if (databaseCreato == true) {
                            CancellaDati.main(new String[] { dbName });
                            break;
                        } else {
                            System.out.println("crea almeno un database prima di cancellare i dati:");
                            break;
                        }
                    case 5:
                        System.out.println("Inserisci il nome del database dal quale estrarre i dati:");
                        dbName = scanner.nextLine();
                        if (databaseCreato == true) {
                            SalvaInCSV.main(new String[] { dbName });
                            break;
                        } else {
                            System.out.println("crea almeno un database prima di estrarre i dati:");
                            break;
                        }
                    case 6:
                        fineProgramma = true;
                        break;

                    default:
                        System.out.println("Scelta non valida. Inserisci 1, 2, 3, 4, 5, 6.");
                        break;
                }
            if (databaseCreato == true) {
                VisualizzaDati.main(new String[] { dbName });
            }
            }

            catch (InputMismatchException | NumberFormatException e) {
                System.out.println("inserisci un valore valido");
            }

        }
        scanner.close();
    }




    // Metodo che serve a controllare se nella cartella padre esiste un Db, nel caso esistesse, ci si puo lavorare sopra e ritorna True, se non esiste ritorna False e devi necessariamente creare un database per potere effettuare le modifiche 
    public static boolean dbEsistente()
    {
         String folderPath = "C:\\Users\\Java\\Documents\\java-Local\\java-FullStack-Assignement\\advanced-db"; // Sostituisci con il percorso della cartella desiderata

        // Ottieni l'elenco dei file nella cartella
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        // Controlla se ci sono file che contengono la stringa ".db" nel nome
        List<String> dbFiles = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().contains(".db")) {
                    dbFiles.add(file.getName());
                }
            }
        }

        // Stampa i nomi dei file trovati
        if (!dbFiles.isEmpty()) {
            // System.out.println("I seguenti file .db sono stati trovati nella cartella:");
            // for (String fileName : dbFiles) {
            //     System.out.println(fileName);
            // }
            return true;
        } else {
            System.out.println("Nessun file .db trovato nella cartella.");
            return false;
        }
    }
}