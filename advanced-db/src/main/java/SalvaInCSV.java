import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SalvaInCSV {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }


        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new java.util.Date());

        Connection conn = null;

        Scanner input = new Scanner(System.in);

        try {

            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Eseguo la query JOIN
            String sql = "SELECT prodotti.nome AS nome_prodotto, prodotti.quantita, prodotti.prezzo, categorie.nome AS nome_categoria "
                    + // selziono i campi con cui mi interessa creare il csv
                    "FROM prodotti " + // La clausola FROM specifica la tabella da cui vengono selezionati i dati. In
                                       // questo caso, selezioniamo i dati dalla tabella "prodotti".
                    "JOIN categorie ON prodotti.id_categoria = categorie.id;"; // l'operazione di JOIN consente di
                                                                               // combinare i dati da più tabelle in
                                                                               // base a una condizione di
                                                                               // corrispondenza, La parola chiave "ON"
                                                                               // indica come le righe delle due tabelle
                                                                               // dovrebbero essere abbinate. La colonna
                                                                               // "id_categoria" nella tabella
                                                                               // "prodotti" viene utilizzata come
                                                                               // chiave per la combinazione con la
                                                                               // tabella "categorie". La colonna "id"
                                                                               // nella tabella "categorie" viene
                                                                               // utilizzata come chiave per la
                                                                               // combinazione con la tabella
                                                                               // "prodotti".
            // unisci categorie a prodotti se nella riga presa in esame i valori di
            // 'id_categoria' in 'prodotti' corrispondono ai valori di 'id' in 'categorie'.
            // La condizione di join è specificata dopo ON.
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Che formato CSV vuoi?");
            System.out.println("1: Tabella");
            System.out.println("2: In linea");
            int scelta = input.nextInt();
            if (scelta == 1) {

                // Preparo il file CSV
                FileWriter fileWriter = new FileWriter(args[0] + "_prodotti_categorie_Table_" + timeStamp + ".csv");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println("Nome Prodotto, Quantita, Prezzo, Categoria"); // Intestazione del CSV

                // Stampo i risultati nel file CSV
                while (rs.next()) {
                    String nomeProdotto = rs.getString("nome_prodotto"); // Recupera il valore della colonna
                                                                         // "nome_prodotto" dalla riga corrente del
                                                                         // ResultSet e lo assegna alla variabile
                                                                         // nomeProdotto di tipo String.
                    int quantita = rs.getInt("quantita");
                    double prezzo = rs.getDouble("prezzo");
                    String nomeCategoria = rs.getString("nome_categoria");

                    printWriter.println(nomeProdotto + ", " + quantita + ", " + prezzo + ", " + nomeCategoria);
                }

                printWriter.close();
                System.out.println("I dati sono stati salvati nel file 'prodotti_categorie.csv'.");
            }

            else if (scelta == 2) {

                // Preparo il file CSV
                FileWriter fileWriter = new FileWriter(args[0] + "_prodotti_categorie_Inline_" + timeStamp + ".csv");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                // printWriter.println("Nome Prodotto, Quantita, Prezzo, Categoria"); //
                // Intestazione del CSV

                // Stampo i risultati nel file CSV
                while (rs.next()) {
                    String nomeProdotto = rs.getString("nome_prodotto"); // Recupera il valore della colonna
                                                                         // "nome_prodotto" dalla riga corrente del
                                                                         // ResultSet e lo assegna alla variabile
                                                                         // nomeProdotto di tipo String.
                    int quantita = rs.getInt("quantita");
                    double prezzo = rs.getDouble("prezzo");
                    String nomeCategoria = rs.getString("nome_categoria");

                    printWriter.println("Nome Prodotto: " + nomeProdotto + ", " + "Quantita: " + quantita + ", "
                            + "Prezzo: " + prezzo + ", " + "Categoria: " + nomeCategoria);
                }

                printWriter.close();
                System.out.println("I dati sono stati salvati nel file 'prodotti_categorie.csv'.");
            }
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