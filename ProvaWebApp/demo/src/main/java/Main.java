
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner tastiera = new Scanner(System.in);
        creaDatabase();
        inserimentoDummyDatas();
        visualizzazioneDati();
        System.out.println("vuoi salvare dati su CSV ? \n 1 per salvare 2 per non salvare");
        try {
            int scelta = Integer.parseInt(tastiera.nextLine());
            if (scelta == 1) {
                salvaSuCSV();
            } else {
                System.out.println("grazie mille per avere testato il programma");
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("inserisci 1 o 0, quello che hai scritto non va bene");
        }
        tastiera.close();
    }

    private static void creaDatabase() {
        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Creo le tabelle
            String sqlCreaTabellaStudenti = "CREATE TABLE IF NOT EXISTS studenti (" +
                    "id INTEGER PRIMARY KEY," +
                    "nome_prodotto TEXT NOT NULL," +
                    "prezzo_prodotto REAL NOT NULL," +
                    "quantita_ordini INTEGER NOT NULL," +
                    "quantita_venduti INTEGER NOT NULL" +
                    ");";

            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreaTabellaStudenti);

            System.out.println("Tabelle create con successo.");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void inserimentoDummyDatas() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            Statement stmt = conn.createStatement();

            // Inserisci 10 record nella tabella "studenti"
            for (int i = 1; i <= 10; i++) {
                String nomeProdotto = "Prodotto " + i;
                double prezzoProdotto = 10.0 + i; // Esempio di prezzo variabile
                int quantitaOrdini = 5 + i; // Esempio di quantità ordini variabile
                int quantitaVenduti = 3 + i; // Esempio di quantità venduti variabile

                String sqlInserisciRecord = "INSERT INTO studenti (nome_prodotto, prezzo_prodotto, quantita_ordini, quantita_venduti) "
                        +
                        "VALUES ('" + nomeProdotto + "', " + prezzoProdotto + ", " + quantitaOrdini + ", "
                        + quantitaVenduti + ");";

                stmt.execute(sqlInserisciRecord);
            }

            System.out.println("Inserimento completato.");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private static void visualizzazioneDati() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:database.db";

            conn = DriverManager.getConnection(url);

            // String sql = "SELECT * FROM prodotti";
            String sql = "SELECT * FROM studenti";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Tabulazione Nomi Colonne
            System.out.println(
                    "ID: \t|" + "Nome: \t \t \t \t|" + "Prezzo: \t|" + "QT.Ordini: \t|" + "QT.Venduti:");

            // Cicliamo i record ottenuti dalla query e li stampiamo tabulandoli in modo che
            // seguano la tabulazione delle colonne

            double prezzo_Tot = 0;
            int ordini_tot = 0;
            int venduti_tot = 0;
            // nel caso in quale il nome del prodotto sia troppo lumngo, aumaentare i \t
            // dopo la string nome, cosi andra smepre tabulato in modo corretot
            while (rs.next()) {
                if (rs.getString("nome_prodotto").length() > 20) {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome_prodotto") + "\t|"
                                    + rs.getDouble("prezzo_prodotto")
                                    + "\t \t|" + rs.getInt("quantita_ordini") + "\t \t|"
                                    + rs.getInt("quantita_venduti"));
                } else if (rs.getString("nome_prodotto").length() <= 20
                        && rs.getString("nome_prodotto").length() >= 7) {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome_prodotto") + "\t \t \t|"
                                    + rs.getDouble("prezzo_prodotto")
                                    + "\t \t|" + rs.getInt("quantita_ordini") + "\t \t|"
                                    + rs.getInt("quantita_venduti"));
                } else {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome_prodotto") + "\t \t \t \t|"
                                    + rs.getDouble("prezzo_prodotto")
                                    + "\t \t|" + rs.getInt("quantita_ordini") + "\t \t|"
                                    + rs.getInt("quantita_venduti"));
                }
                prezzo_Tot += rs.getDouble("prezzo_prodotto");
                ordini_tot += rs.getInt("quantita_ordini");
                venduti_tot += rs.getInt("quantita_venduti");
            }
            System.out.println(
                    "Tot: \t|" + "TOTALE: \t \t \t|" + prezzo_Tot + " \t \t|" + ordini_tot + "\t \t|" + venduti_tot);

        } catch (SQLException |

                ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void salvaSuCSV() {

        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new java.util.Date());
        Connection conn = null;

        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);

            String sql = "SELECT * FROM studenti";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // Preparo il file CSV
            FileWriter fileWriter = new FileWriter("database_studenti_" + timeStamp + ".csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Nome Prodotto, Prezzo , QT ordini , QT Venduti"); // Intestazione del CSV

            // Stampo i risultati nel file CSV
            while (rs.next()) {
                String nomeProdotto = rs.getString("nome_prodotto"); // Recupera il valore della colonna
                                                                     // "nome_prodotto" dalla riga corrente del
                                                                     // ResultSet e lo assegna alla variabile
                                                                     // nomeProdotto di tipo String.
                double prezzo = rs.getDouble("prezzo_prodotto");
                int ordini = rs.getInt("quantita_ordini");
                int venduti = rs.getInt("quantita_venduti");
                printWriter.println(nomeProdotto + ", " + prezzo + ", " + ordini + ", " + venduti);
            }

            printWriter.close();
            System.out.println("I dati sono stati salvati nel file 'database_studenti.csv'");

        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
