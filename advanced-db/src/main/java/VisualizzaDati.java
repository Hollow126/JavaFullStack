import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisualizzaDati {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }

        Connection conn = null;
        try {

            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            // String sql = "SELECT * FROM prodotti";
            String sql = "SELECT prodotti.id, prodotti.nome, prodotti.quantita, prodotti.prezzo, categorie.nome AS nomeCategoria FROM prodotti JOIN categorie ON prodotti.id_categoria=categorie.id;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // tabulazione nome Database
            System.out.println("\n \t \t \t \t|" + "Database " + args[0] + "|\t \t \n");

            // Tabulazione Nomi Colonne
            System.out.println(
                    "ID: \t|" + "Nome: \t \t \t \t|" + "Quantita: \t|" + "Prezzo: \t|" + "Nome_Categoria:");

            // Cicliamo i record ottenuti dalla query e li stampiamo tabulandoli in modo che
            // seguano la tabulazione delle colonne

            // nel caso in quale il nome del prodotto sia troppo lumngo, aumaentare i \t
            // dopo la string nome, cosi andra smepre tabulato in modo corretot
            while (rs.next()) {
                if (rs.getString("nome").length() > 20) {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome") + "\t|" + rs.getInt("quantita")
                                    + "\t \t|" + rs.getDouble("prezzo") + "\t \t|" + rs.getString("nomeCategoria"));
                } else if (rs.getString("nome").length() <= 20 && rs.getString("nome").length() >= 7) {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome") + "\t \t \t|" + rs.getInt("quantita")
                                    + "\t \t|" + rs.getDouble("prezzo") + "\t \t|" + rs.getString("nomeCategoria"));
                } else {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome") + "\t \t \t \t|" + rs.getInt("quantita")
                                    + "\t \t|" + rs.getDouble("prezzo") + "\t \t|" + rs.getString("nomeCategoria"));
                }
            }

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