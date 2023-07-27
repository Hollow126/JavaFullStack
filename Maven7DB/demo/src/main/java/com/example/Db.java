package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// TODO mettere il collegamento non su id ma su idLista e mettere un campo Id magia e idpersonaggio a cui appartiene magia 
import org.sqlite.SQLiteException;

public class Db {

    public static void createDatabase() {
        Connection connection;
        try {
            String url = "jdbc:sqlite:database.db";

            System.out.println("Connessione a SQLite stabilita.");

            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Creazione della tabella personaggi con chiave primaria (id)
        String sqlPersonaggi = "CREATE TABLE IF NOT EXISTS personaggi (" +
                "id INT PRIMARY KEY," +
                "nome VARCHAR(100)," +
                "lV INT," +
                "esperienza INT," +
                "isAllley BOOLEAN," +
                "vita DOUBLE," +
                "atkBase INT," +
                "defBase INT," +
                "velocita INT," +
                "idMagia INT" +
                ")";

        // Creazione della tabella magie con chiave primaria (idMagia)
        String sqlMagie = "CREATE TABLE IF NOT EXISTS magie (" +
                "idMagia INT PRIMARY KEY," +
                "idPersonaggioMagia," +
                "nomeMagia VARCHAR(100)," +
                "descrizione VARCHAR(255)," +
                "puntiPotenza INT" +
                ")";

        // Aggiunta della chiave esterna (idMagia) nella tabella personaggi
        // String sqlForeignKey = "ALTER TABLE personaggi " +
        // // // "ADD COLUMN idMagia INT, " +
        // "ADD FOREIGN KEY (idMagia) REFERENCES magie(idMagia)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlPersonaggi);
            statement.execute(sqlMagie);
            // statement.execute(sqlForeignKey);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void aggiungiColonne() {
        Connection connection;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database.db";
            connection = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Aggiungo la colonna 'categoria_prodotto'
            String sql1 = "ALTER TABLE prodotti ADD COLUMN categoria_prodotto text;";
            Statement stmt1 = connection.createStatement();
            stmt1.execute(sql1);

            System.out.println("Colonna 'categoria_prodotto' aggiunta.");

            // Aggiungo la colonna 'prezzo_prodotto'
            String sql2 = "ALTER TABLE prodotti ADD COLUMN prezzo_prodotto real;";
            Statement stmt2 = connection.createStatement();
            stmt2.execute(sql2);

            System.out.println("Colonna 'prezzo_prodotto' aggiunta.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
