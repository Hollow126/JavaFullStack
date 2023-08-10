package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// TODO mettere il collegamento non su id ma su idLista e mettere un campo Id magia e idpersonaggio a cui appartiene magia 
import org.sqlite.SQLiteException;

public class Database {
    private Connection connection;

    // se ci fossero più database, passare sempre l'url della connessione
    public Database(String dbUrl) {

        try {
            connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDatabase() {

        // Creo la tabella "personaggi"
        String createTablePersonaggi = "CREATE TABLE IF NOT EXISTS personaggi (" +
                "id INTEGER PRIMARY KEY," +
                "nome VARCHAR(100)," +
                "lV INT," +
                "esperienza INT," +
                "isAllley BOOLEAN," +
                "vita DOUBLE," +
                "atkBase INT," +
                "defBase INT," +
                "velocita INT" +
                ");";

        // Creo la tabella "magie"
        String createTableMagie = "CREATE TABLE IF NOT EXISTS magie (" +
                "id INTEGER PRIMARY KEY," +
                "nomeMagia TEXT NOT NULL," +
                "descrizione VARCHAR(255)," +
                "puntiPotenza INT" +
                ");";

        // Creo la tabella di collegamento "personaggio_magia"
        String createTablePersonaggioMagia = "CREATE TABLE IF NOT EXISTS personaggio_magia (" +
                "id INTEGER PRIMARY KEY," +
                "id_personaggio INTEGER NOT NULL," +
                "id_magia INTEGER NOT NULL," +
                "FOREIGN KEY (id_personaggio) REFERENCES personaggi(id)," +
                "FOREIGN KEY (id_magia) REFERENCES magie(id)" +
                ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTablePersonaggi);
            statement.execute(createTableMagie);
            statement.execute(createTablePersonaggioMagia);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per creare un oggetto Personaggio nel database; con le prepared
    // statement, 1 corrisponde al primo punto di domanda, il 2 al secondo ecc ecc
    // con preparedStatement.setQualcosa si possono inserire i valori che noi
    // vogliamo passare come valori alla query, come primo argomento il nuemro del
    // punto di domand a
    // come secondo il valore vero e proprio che si passera alla query
    public void creaPersonaggioInDB(EntitaGiocante personaggio) {
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
    public void modificaPersonaggioInDB(EntitaGiocante nuovoPersonaggio) {
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


    // Metodo per creare una magia nel database
    public void creaMag1iaInDB(Magia magia) {
        String sql = "INSERT INTO magie (id, nomeMagia, descrizione,puntiPotenza) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, magia.getId());
            preparedStatement.setString(2, magia.getNome());
            preparedStatement.setString(3, magia.getDescrizione());
            preparedStatement.setInt(4, magia.getPp());

            preparedStatement.executeUpdate();
            System.out.println("magia " + magia.getNome() + " salvata correttamente nel DB");
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

    public void creaMagiaPerPersonaggioSeNonEsisteDB(EntitaGiocante personaggio, Magia magia) {
        if (verificaSeMagiaEsisteInDB(personaggio.getId(), magia.getNome())) {
            System.out.println("La correlazione esiste gia ");
            getNomeMagiaPerPersonaggio();
        } else {
            System.out.println("non esiste una correllazione");
            CreaCorrelazione(personaggio.getId(), magia);
        }

    }

    // con questo metodo utilizzo la count per avere come risultato le righe che
    // soddisfano le condizioni della query
    // la query in se fa un confronto tra le tabelle personaggi e la tabella magia,
    // utilizzando come collegamento
    // per la tabella magie il campo idPersonaggioMagia, per la tabella personaggi
    // il campo id,
    // prendendo i casi nel quale i valori
    // dei campi magie.nomeMagia e personaggi.id sono uguali al nome della magia e
    // all'id del personaggio passati come argomento,
    // ritorna True se la magia esiste in Database, False se la magia non esiste

    public boolean verificaSeMagiaEsisteInDB(int idPersonaggio, String nomeMagia) {
        String ottieniIDMagiaSQL = "SELECT id FROM magie WHERE NomeMagia = ?";
        String corrispondenza = "SELECT COUNT(*) as conto_corrispondenze FROM personaggio_magia " +
                "WHERE id_personaggio = ? AND id_magia = ?";

        try (PreparedStatement preparedStatement1 = connection.prepareStatement(ottieniIDMagiaSQL);
                PreparedStatement preparedStatement2 = connection.prepareStatement(corrispondenza)) {
            preparedStatement1.setString(1, nomeMagia);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if (resultSet1.next()) {
                int idMagia = resultSet1.getInt("id");

                preparedStatement2.setInt(1, idPersonaggio);
                preparedStatement2.setInt(2, idMagia);
                ResultSet resultSet2 = preparedStatement2.executeQuery();

                if (resultSet2.next()) {
                    int countMagie = resultSet2.getInt("conto_corrispondenze");
                    System.out.println("ok ce una corrispondenza");
                    return countMagie > 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    // TODO modificare ed aggiungere la roba anziche in tabella magia ma nella
    // tabella di mezzo
    // semplice insert nella quale si va a riempire la tabella magia di un
    // personaggio
    public void CreaCorrelazione(int idPersonaggio, Magia magia) {
        String sql = "INSERT INTO personaggio_magia (id_personaggio, id_magia) " +
                "VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idPersonaggio);
            preparedStatement.setInt(2, magia.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getNomeMagiaPerPersonaggio() {
        String sql = "SELECT p.id, p.nome AS nomePersonaggio, m.nomeMagia " +
                "FROM personaggi p " +
                "LEFT JOIN magie m ON p.idMagia = m.idMagia";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            // Stampare i risultati
            while (resultSet.next()) {
                int idPersonaggio = resultSet.getInt("id");
                String nomePersonaggio = resultSet.getString("nomePersonaggio");
                String nomeMagia = resultSet.getString("nomeMagia");

                System.out.println("Personaggio (ID: " + idPersonaggio + "): " + nomePersonaggio);
                System.out.println("Nome Magia collegata: " + nomeMagia);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exportPersonaggiToCSV(String filePath) {
        String sql = "SELECT * FROM personaggi";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                FileWriter fileWriter = new FileWriter(filePath)) {

            // Scrivi l'intestazione del file CSV
            fileWriter.append("id,nome,lV,esperienza,isAllley,vita,atkBase,defBase,velocita");
            fileWriter.append("\n");

            // Scrivi i dati dei personaggi nel file CSV
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int lV = resultSet.getInt("lV");
                int esperienza = resultSet.getInt("esperienza");
                boolean isAllley = resultSet.getBoolean("isAllley");
                double vita = resultSet.getDouble("vita");
                int atkBase = resultSet.getInt("atkBase");
                int defBase = resultSet.getInt("defBase");
                int velocita = resultSet.getInt("velocita");

                // Scrivi una riga nel file CSV per ogni personaggio
                fileWriter.append(String.valueOf(id)).append(",");
                fileWriter.append(nome).append(",");
                fileWriter.append(String.valueOf(lV)).append(",");
                fileWriter.append(String.valueOf(esperienza)).append(",");
                fileWriter.append(String.valueOf(isAllley)).append(",");
                fileWriter.append(String.valueOf(vita)).append(",");
                fileWriter.append(String.valueOf(atkBase)).append(",");
                fileWriter.append(String.valueOf(defBase)).append(",");
                fileWriter.append(String.valueOf(velocita)).append(",");
                fileWriter.append("\n");
            }

            System.out.println("Dati dei personaggi esportati con successo in " + filePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}