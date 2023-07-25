package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AggiungiColonne {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Aggiungo la colonna 'categoria_prodotto'
            String sql1 = "ALTER TABLE prodotti ADD COLUMN categoria_prodotto text;";
            Statement stmt1 = conn.createStatement();
            stmt1.execute(sql1);

            System.out.println("Colonna 'categoria_prodotto' aggiunta.");

            // Aggiungo la colonna 'prezzo_prodotto'
            String sql2 = "ALTER TABLE prodotti ADD COLUMN prezzo_prodotto real;";
            Statement stmt2 = conn.createStatement();
            stmt2.execute(sql2);

            System.out.println("Colonna 'prezzo_prodotto' aggiunta.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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