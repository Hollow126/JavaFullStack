import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean cont = true;
        String databaseName = null;

        while (cont) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1: Crea un nuovo DB");
            System.out.println("2: Seleziona un DB esistente");
            System.out.println("3: Elimina un DB");
            System.out.println("4: Esci");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline lasciato da nextInt()

            if (choice == 1) {
                System.out.println("Inserisci il nome del nuovo database:");
                databaseName = scanner.nextLine();
                CreaDatabase.main(new String[] { databaseName });
            } else if (choice == 2) {
                File dir = new File("."); // Directory corrente
                String[] files = dir.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".db");
                    }
                }); // Filtra solo i file .db

                // Stampa l'elenco dei database
                System.out.println("Database disponibili:");
                for (int i = 0; i < files.length; i++) {
                    System.out.println((i + 1) + ": " + files[i]);
                }

                System.out.println("Scegli un database (inserisci il numero):");
                int dbChoice = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline lasciato da nextInt()
                databaseName = files[dbChoice - 1].replace(".db", ""); // Rimuovi l'estensione .db dal nome del database
            } else if (choice == 3) {
                DeleteDatabase.main(new String[] {});
            } else if (choice == 4) {
                System.out.println("Addio!");
                cont = false;
                continue;
            } else {
                System.out.println("Opzione non valida. Riprova.");
                continue;
            }

            while (cont) {
                System.out.println("Scegli un'opzione per il database " + databaseName + ":");
                System.out.println("1: Inserisci dummy datas");
                System.out.println("2: Salva in CSV");
                System.out.println("3: Modifica dati");
                System.out.println("4: Cancella dati");
                System.out.println("5: Inserisci i dati a mano");
                System.out.println("6: Torna al menu principale");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline lasciato da nextInt()

                try {
                    switch (choice) {
                        case 1:
                            InserisciDummyDatas.main(new String[] { databaseName });
                            break;
                        case 2:
                            SalvaInCSV.main(new String[] { databaseName });
                            break;
                        case 3:
                            ModificaDati.main(new String[] { databaseName });
                            break;
                        case 4:
                            CancellaDati.main(new String[] { databaseName });
                            break;
                        case 5:
                            InserisciManual.main(new String[] { databaseName });
                            break;
                        case 6:
                            System.out.println("Torna al menu principale.");
                            cont = false;
                            break;
                        default:
                            System.out.println("Opzione non valida. Riprova.");
                    }

                    // Stampare i dati del database dopo ogni azione, eccetto l'uscita
                    if (cont) {
                        VisualizzaDati.main(new String[] { databaseName });
                    }

                } catch (Exception e) {
                    System.out.println("Si � verificato un errore: " + e.getMessage());
                }
            }
            cont = true;
        }

        scanner.close();
    }
}