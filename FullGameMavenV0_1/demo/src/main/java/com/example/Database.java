package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteException;

public class Database {
    private Connection connection;

    public Database(String dbUrl) {

        try {
            connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDatabase() {
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
                "idMagia INT," +
                "FOREIGN KEY (idMagia) REFERENCES magie(idMagia)" +
                ")";

        // Creazione della tabella magie con chiave primaria (idMagia)
        String sqlMagie = "CREATE TABLE IF NOT EXISTS magie (" +
                "idMagia INT PRIMARY KEY," +
                "nomeMagia VARCHAR(100)," +
                "descrizione VARCHAR(255)," +
                "puntiPotenza INT" +
                ")";

        //Aggiunta della chiave esterna (idMagia) nella tabella personaggi
        // String sqlForeignKey = "ALTER TABLE personaggi " +
        // //         // "ADD COLUMN idMagia INT, " +
        //          "ADD FOREIGN KEY (idMagia) REFERENCES magie(idMagia)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlPersonaggi);
            statement.execute(sqlMagie);
         //   statement.execute(sqlForeignKey);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per salvare un oggetto Personaggio nel database; con le prepared
    // statement, 1 corrisponde al primo punto di domanda, il 2 al secondo ecc ecc
    // con preparedStatement.setQualcosa si possono inserire i valori che noi
    // vogliamo passare come valori alla query, come primo argomento il nuemro del
    // punto di domand a
    // come secondo il valore vero e proprio che si passera alla query
    public void salvaPersonaggio(EntitaGiocante personaggio) {
        String sql = "INSERT INTO personaggi (id, nome, lV, esperienza, isAllley, vita, atkBase, defBase, velocita) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, personaggio.getId());
            preparedStatement.setString(2, personaggio.getNome());
            preparedStatement.setInt(3, personaggio.getlV());
            preparedStatement.setInt(4, personaggio.getEsperienza());
            preparedStatement.setBoolean(5, personaggio.isAlley());
            preparedStatement.setDouble(6, personaggio.getVita());
            preparedStatement.setInt(7, personaggio.getAtkBase());
            preparedStatement.setInt(8, personaggio.getDefBase());
            preparedStatement.setInt(9, personaggio.getVelocita());

            preparedStatement.executeUpdate();
            System.out.println("personaggio " + personaggio.getNome() + " salvato correttamente nel DB");
        } catch (SQLException e) {
            if (e instanceof SQLiteException && e.getMessage().contains("PRIMARY KEY constraint")) {
                // Il personaggio esiste già nel database
                System.out.println(
                        "Personaggio già esistente nel database. Per modificarlo, usa il metodo modificaPersonaggio()");
            } else {
                // Altri tipi di eccezioni
                e.printStackTrace();
            }
        }
    }

    // Metodo per modificare un personaggio nel database
    public void modificaPersonaggio(EntitaGiocante nuovoPersonaggio) {
        String sql = "UPDATE personaggi SET " +
                "nome = ?, lV = ?, esperienza = ?, isAllley = ?, " +
                "vita = ?, atkBase = ?, defBase = ?, velocita = ? " +
                "WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Imposta i nuovi valori degli attributi, escludendo l'ID
            preparedStatement.setString(1, nuovoPersonaggio.getNome());
            preparedStatement.setInt(2, nuovoPersonaggio.getlV());
            preparedStatement.setInt(3, nuovoPersonaggio.getEsperienza());
            preparedStatement.setBoolean(4, nuovoPersonaggio.isAlley());
            preparedStatement.setDouble(5, nuovoPersonaggio.getVita());
            preparedStatement.setInt(6, nuovoPersonaggio.getAtkBase());
            preparedStatement.setInt(7, nuovoPersonaggio.getDefBase());
            preparedStatement.setInt(8, nuovoPersonaggio.getVelocita());

            // Imposta l'ID del personaggio da modificare
            preparedStatement.setInt(9, nuovoPersonaggio.getId());

            // Esegui l'aggiornamento nel database
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}