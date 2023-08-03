package com.example;

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
                "FOREIGN KEY(id) REFERENCES magie(idMagia)" +
                ")";

        // Creazione della tabella magie con chiave primaria (idMagia)
        String sqlMagie = "CREATE TABLE IF NOT EXISTS magie (" +
                "idMagia INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idPersonaggioMagia," +
                "nomeMagia VARCHAR(100)," +
                "descrizione VARCHAR(255)," +
                "puntiPotenza INT" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlPersonaggi);
            statement.execute(sqlMagie);
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

    public void creaMagiaPerPersonaggioSeNonEsisteDB(EntitaGiocante personaggio, Magia magia) {
        if (verificaSeMagiaEsisteInDB(personaggio.getId(), magia.getNome())) {
            System.out.println("LA MAGIA ESISTE");
        } else {
            System.out.println("la magia non esiste");
            creaMagiaPerPersonaggioDB(personaggio.getId(), magia);
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
        String sql = "SELECT COUNT(*) AS countMagie " +
                "FROM magie " +
                "JOIN personaggi ON magie.idPersonaggioMagia = personaggi.id " +
                "WHERE magie.nomeMagia = ? AND magie.idPersonaggioMagia = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nomeMagia);
            preparedStatement.setInt(2, idPersonaggio);

            ResultSet resultSet = preparedStatement.executeQuery(); // con l'oggetto ResultSet otteniamo le righe che
                                                                    // soddisfano la query che gli assegniamo

            // con il metodo .next prendiamo la riga successiva
            if (resultSet.next()) {
                int countMagie = resultSet.getInt("countMagie"); // assegniamo alla variabile countMagie il numero di
                                                                 // righe che soddisfano le query
                return countMagie > 0; // con questa istruzione il metodo ritorna true se countMagie e maggiore di 0 e
                                       // quindi su Database esiste gia un collegamento
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Ritorna false in caso di eccezione o se il nomeMagia non esiste nel databased
    }

    public void creaMagiaPerPersonaggioDB(int idPersonaggio, Magia magia) {
        String sql = "INSERT INTO magie (idPersonaggioMagia, nomeMagia, descrizione, puntiPotenza) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idPersonaggio);
            preparedStatement.setString(2, magia.getNome());
            preparedStatement.setString(3, magia.getDescrizione());
            preparedStatement.setInt(4, magia.getPp());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}