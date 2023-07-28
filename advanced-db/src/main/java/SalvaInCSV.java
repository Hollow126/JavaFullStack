import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalvaInCSV {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[]{"database_collegato"};
        }

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Query per selezionare tutti i dati dalla tabella prodotti
            String query = "SELECT * FROM prodotti";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            FileWriter csvWriter = new FileWriter("prodotti.csv");

            // Scrivi l'intestazione del CSV
            csvWriter.append("ID");
            csvWriter.append(",");
            csvWriter.append("Nome");
            csvWriter.append(",");
            csvWriter.append("Quantita");
            csvWriter.append(",");
            csvWriter.append("Prezzo");
            csvWriter.append(",");
            csvWriter.append("ID_Categoria");
            csvWriter.append("\n");

            // Scrivi i dati del CSV
            while (rs.next()) {
                csvWriter.append(Integer.toString(rs.getInt("id")));
                csvWriter.append(",");
                csvWriter.append(rs.getString("nome"));
                csvWriter.append(",");
                csvWriter.append(Integer.toString(rs.getInt("quantita")));
                csvWriter.append(",");
                csvWriter.append(Double.toString(rs.getDouble("prezzo")));
                csvWriter.append(",");
                csvWriter.append(Integer.toString(rs.getInt("id_categoria")));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("Dati salvati con successo in prodotti.csv.");

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