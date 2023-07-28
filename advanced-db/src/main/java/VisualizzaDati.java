import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

            String sql = "SELECT * FROM prodotti";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // tabulazione nome Database 
            System.out.println(" \t \t \t|" + args[0]+"|\t \t"  );
            // Tabulazione Nomi Colonne 
            System.out.println("ID: \t|" + "Nome: \t \t|" + "Quantita: \t|" + "Prezzo: \t|" + "ID_Categoria:");

            //Cicliamo i record ottenuti dalla query e li stampiamo tabulandoli in modo che seguano la tabulazione delle colonne
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t|" + rs.getString("nome") + "\t|" + rs.getInt("quantita")
                        + "\t \t|" + rs.getDouble("prezzo") + "\t \t|" + rs.getInt("id_categoria"));
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