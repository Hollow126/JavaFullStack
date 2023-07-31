import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class DeleteDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Elenco tutti i file del database nella directory corrente
        File dir = new File(".");
        String[] files = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".db");
            }
        });

        if (files.length == 0) {
            System.out.println("Nessun database disponibile per la cancellazione.");
            return;

        }

        // Stampo l'elenco dei database
        System.out.println("Database disponibili:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ": " + files[i]);
        }

        System.out.println("Inserisci il numero del database che vuoi cancellare:");
        int dbChoice = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline lasciato da nextInt()

        if (dbChoice < 1 || dbChoice > files.length) {
            System.out.println("Scelta non valida.");
            return;
        }

        // Elimino il database selezionato
        File dbFile = new File(files[dbChoice - 1]);
        if (dbFile.delete()) {
            System.out.println("Il database " + files[dbChoice - 1] + " è stato eliminato.");
        } else {
            System.out.println("Impossibile eliminare il database " + files[dbChoice - 1] + ".");
        }

        scanner.close();
    }
}