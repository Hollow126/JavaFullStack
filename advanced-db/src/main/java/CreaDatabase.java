import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreaDatabase {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");
            
            String sqlCreaTabellaCategorie = "CREATE TABLE IF NOT EXISTS categorie (" +
                    "id INTEGER PRIMARY KEY," +
                    "nome TEXT NOT NULL" +
                    ");";

            // Creo le tabelle
            String sqlCreaTabellaProdotti = "CREATE TABLE IF NOT EXISTS prodotti (" +
                    "id INTEGER PRIMARY KEY," +
                    "nome TEXT NOT NULL," +
                    "quantita INTEGER NOT NULL," +
                    "prezzo REAL NOT NULL," +
                    "id_categoria INTEGER NOT NULL," +
                    "FOREIGN KEY(id_categoria) REFERENCES categorie(id)" +
                    ");";

            

            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreaTabellaProdotti);
            stmt.execute(sqlCreaTabellaCategorie);

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
}