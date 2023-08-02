# Esercitazione Database
## Scopo Progetto 
Lo scopo del progetto, è creare un **interfaccia** , che possa permettere ad un utente finale di creare, modificare ed eseguire diverse operazione su uno o più database.
Tutto queste operazioni vengono eseguite da terminale tramite i dati che l'utente immette.
# Il Main 
Il main è il punto di partenza del codice, l'utente appena avvia il codice farà partire il main e si ritrovera davanti queste 4 scelte, che fanno parte del primo **Menu Di Opzioni** 

## Il Primo Menu Di Opzioni 
1. : Crea un nuovo DB
2. : Seleziona un DB esistente
3. : Elimina un DB
4. : Esci

## Scelta 1 Crea Database
Selezionando l'opzione 1 all'utente verra chiesto di inserire il nome del Database che vuole creare, poi partirà il metodo Main della classe CreaDatabase al quale viene passato come argomento, la stringa che l'utente scrive.

Al'interno del metodo CreaDatabase, vengono eseguite queste 2 Query, che creano la tabella prodotti e la tabella categorie con tutti i loro campi e Chiavi Primarie e secondarie.

 

            // Creo le tabelle
             String sqlCreaTabellaCategorie = "CREATE TABLE IF NOT EXISTS categorie (" +  
                    "id INTEGER PRIMARY KEY," +
                    "nome TEXT NOT NULL" +
                    ");";
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
            stmt.execute(sqlCreaTabellaCategorie);`  

dopo che le tabelle vengono create all'utente viene mostrato il **Secondo Menu Di Opzioni** nella quale può visualizzare tutte le opzioni che si possono fare nel database creato, tuttavia andando con ordine, vediamo prima la altre scelte del **Primo Menu Di Opzioni**

## Scelta 2 Seleziona Database Esistente 
Selezionando l'opzione 2 il programma controlla tutti i file nella stessa cartella nella quale si trova il main che hanno come estensione **.db**, poi esegue un ciclo che fa stampare tutti quanti i nomi dei database con affianco a loro un numero, poi l'utente inserirà il numero associato al database nel quale lavorare e vedra sullo schermo il **Secondo Menu Di Opzioni** nel quale potrà visualizzare tutte le opzioni che può eseguire sul database che egli ha **Selezionato**

              // Directory corrente
              File dir = new File("."); 
                String[] files = dir.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".db");
                    }
                }); // Filtra solo i file .db

                // Stampa l'elenco dei database
                System.out.println("Database disponibili:");
                for (int i = 0; i < files.length; i++) {
                    System.out.println((i + 1) + ": " + files[i]);
                }

                System.out.println("Scegli un database (inserisci il numero):");
                int dbChoice = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline lasciato da nextInt()
                databaseName = files[dbChoice - 1].replace(".db", ""); // Rimuovi l'estensione .db dal nome del database

## Scelta 3 Elimina Database 
Selezionando l'opzione 3 il programma farà partire il metodo Main della classe DeleteDatabase, che con un funzionamento analogo alla opzione 2, fa un controllo per vedere se esite almeno un file con estensione **.db** nella cartella corrente; in caso non ci fosse il programma scrive che non vi è nessun database esistente, in caso invece esista almeno un database, procede in modo analogo alla opzione 2 a stampare i nomi di tutti i database esistenti con affianco un numero.
L'utente scriverà poi il numero associato al database che vuole eliminare, eliminerà il database e poi tornera al **Primo Menu Di Opzioni**.

        // Elenco tutti i file del database nella directory corrente
        File dir = new File(".");
        String[] files = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".db");
            }
        });

        if (files.length == 0) {
            System.out.println("Nessun database disponibile per la cancellazione.");
            return;

        }

        // Stampo l'elenco dei database
        System.out.println("Database disponibili:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ": " + files[i]);
        }

        System.out.println("Inserisci il numero del database che vuoi cancellare:");
        int dbChoice = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline lasciato da nextInt()

        if (dbChoice < 1 || dbChoice > files.length) {
            System.out.println("Scelta non valida.");
            return;
        }

        // Elimino il database selezionato
        File dbFile = new File(files[dbChoice - 1]);
        if (dbFile.delete()) {
            System.out.println("Il database " + files[dbChoice - 1] + " � stato eliminato.");
        } else {
            System.out.println("Impossibile eliminare il database " + files[dbChoice - 1] + ".");
        }
## Scelta 4 Esci Dal Programma
Selezionando l'opzione 4, il programma esce dal ciclo nel quale veniva mostrato il **Primo Menu Di Opzioni** e subito dopo **Viene Chiuso**

# Il Secondo Menù Di Opzioni 
l'utente dopo avere **creato** o **selezionato** un database nel menu precedente, aprirà il secondo menù di opzioni, nel quale visualizzerà queste opzioni.
1. Inserisci dummy datas
2. Salva in CSV
3. Modifica dati
4. Cancella dati
5. Inserisci i dati a mano
6. Torna al menu principale

al compimento di ognuna di queste opzioni (a parte la 6) verranno visualizzati i dati che sono presenti all'interno del database selezionato 


## Visualizzazione Dati 
per la parte della visualizzazione dei Dati, è stata scelta una tabulazione tramite stringhe da terminale.

Nella quale in cima viene mostrato il nome del Database che viene Passato come argomento nel metodo Visualizza Dati  

Dopodichè sotto il Database vi inseriamo i nomi dei campi della tabella prodotti. 

            // tabulazione nome Database
            System.out.println("\n \t \t \t \t|" + "Database " + args[0] + "|\t \t \n");

            // Tabulazione Nomi Colonne
            System.out.println(
                    "ID: \t|" + "Nome: \t \t \t \t|" + "Quantita: \t|" + "Prezzo: \t|" + "Nome_Categoria:");

dopodichè, per prendere i dati da inserire, compreso del nome della categoria, si esegue questa query

            // Query per ottennimento dati necessari 
            String sql = "SELECT prodotti.id, prodotti.nome, prodotti.quantita, prodotti.prezzo, categorie.nome AS nomeCategoria FROM prodotti JOIN categorie ON prodotti.id_categoria=categorie.id;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);+

dopodichè per scrivere in modo incollonato, si esegue un ciclo sul ResultSet, che ti permette di ottenere i dati di ogni row, per una visualizzazione più pulita, per ogni row si fa un controllo su quanti caratteri ha il nome, più il nome è lungo meno \t vengono immessi nel testo 

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

## Scelta 1 Inserimento Dummy Datas
L'utente selezionando 1 inserirà dei *Dummy Datas* nel database, i *Dummy Datas* sono dei sample di alcune Row che potrebbero essere presenti nel database. 
In poche parole consentono di popolare il database con dei Dati di esempio in un solo click, per fare ciò si fanno delle query **INSERT TO**


            // Aggiungi dati di esempio
            String sqlInserisci = "INSERT INTO prodotti(nome, quantita, prezzo, id_categoria) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInserisci);
            pstmt.setString(1, "Mele");
            pstmt.setInt(2, 10);
            pstmt.setDouble(3, 9.99);
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();

Utilizzando questo comando nella tabella prodotti vi saranno inseriti 4 records.

## Scelta 5 Inserimento Dati A Mano
> Metto prima L'Opzione 5 rispetto alle altre 3 opzioni perchè sono 2 opzioni concettualmente simili.

All'interno di questa opzione vi è subito una altra scelta da fare, nella quale si Puo scegliere se Creare un row nella tabella Categoria o un row nella tabella Prodotti.

### Creazione Row Tabella Prodotti 
quando l'utente vuole aggiungere un prodotto, riceverà una serie di prompt, nel quale gli viene chiesto di dargli le informazioni sul nome del prodotto, il prezzo, la quantita,ed il nome della categoria al quale appartiene 

                // Preparazione Query 
                String sqlInserisciDatiUtente = "INSERT INTO prodotti(nome, quantita, prezzo, id_categoria) VALUES(?, ?, ?, ?)";
                PreparedStatement pstmtInserisciDatiUtente = conn.prepareStatement(sqlInserisciDatiUtente);

                // inserisce il nome del prodtoo
                System.out.println("inserisci nome prodotto");
                String nomeProdotto = input.nextLine();
                pstmtInserisciDatiUtente.setString(1, nomeProdotto);

                // inserisci quantita
                System.out.println("inserisci quantità prodotto");
                int quantitaProdotto = Integer.parseInt(input.nextLine());
                pstmtInserisciDatiUtente.setInt(2, quantitaProdotto);

                // inserisci prezzo

                System.out.println("inserisci prezzo prodotto");
                double prezzoProdotto = Double.parseDouble(input.nextLine());
                pstmtInserisciDatiUtente.setDouble(3, prezzoProdotto);

                // inserisci nome categoria

                System.out.println("inserisci il nome della categoria prodotto");
                String nomeCategoria = input.nextLine();

Tuttavia prima di potere Eseguire questa query (**pstmtInserisciDatiUtente**), bisogna controllare se il nome della categoria che l'utente ha immesso esista o meno, per farlo si esegue questa query (**ptsmtControlloCategoria**),che seleziona l'id del nome della categoria il quale gli ha passato l'utente, i dati di questi query, verrano salvati all'interno di un resultSet.
facendo un controllo sul numero di record di questo ResultSet, si può capire se la categoria esiste o meno, se esiste almeno una row, vuol dire che la categoria esiste. e di conseguenza si aggiunge come quarto valore della prima query, l'Id che è stato pescato dalla seconda query, e si crea il prodotto associato alla categoria.


                // esegue una seconda query che seleziona l'id della categoria che ha scritto
                // l'utente
                String sqlControlloCategoria = "SELECT categorie.id AS id FROM categorie WHERE categorie.nome = ?";
                PreparedStatement ptsmtControlloCategoria = conn.prepareStatement(sqlControlloCategoria);
                ptsmtControlloCategoria.setString(1, nomeCategoria);
                ResultSet rsCc = ptsmtControlloCategoria.executeQuery();

                // se dal risultato della seconda query esce almeno una riga, allora aggiunge
                // come 4 ? valore della prima query
                // il valore dell'id che è risultato dalla prima query
                if (rsCc.next() == true) {
                    int id_categoria = rsCc.getInt("id");
                    pstmtInserisciDatiUtente.setInt(4, id_categoria);
                    pstmtInserisciDatiUtente.executeUpdate();
                    }


Se invece nel Result set vi sono 0 Row,Allora vuol dire che la categoria non esiste. 
A questo punto il programma chiede all'utente se vuole aggiungere al database la categoria che non esiste, se dice di no, l'utente torna al secondo menu di opzioni, se invece l'utente dice di si l'utente crea una nuova categoria, utilizzando la query (**sqlCreaCategoria**), e dopo avere creato la categoria, aggiunge il prodotto alla nuova categoria.


**NOTA BENE AL MOMENTO QUESTA PARTE DI CODICE NON è TERMINATA, MANCA LA PARTE NELLA QUALE AGGIUNGE IL PRODOTTO ALLA NUOVA CATEGORIA, AL MOMENTO CREA SOLO LA NUOVA CATEGORIA, PERDENDO I DATI CHE L'UTENTE HA INSERITO**



                //se la categoria non esiste allora essa viene creata 
                else {
                    System.out.println("Categoria non esistente. Vuoi aggiungerla? S/N");
                    String risposta = input.nextLine();
                    if (risposta.equalsIgnoreCase("S"))
                    {
                        String sqlCreaCategoria = "INSERT INTO categorie(nome) VALUES(?)";
                        
                        PreparedStatement ptsmCreaCategoria = conn.prepareStatement(sqlCreaCategoria);
                        ptsmCreaCategoria.setString(1, nomeCategoria);
                        ptsmCreaCategoria.executeUpdate();
                        // cosi aggiunge solo la categoria e non anche il prodotto alla categoria, da modificare 

                    }
                }
### Creazione Row Categoria 
Se l'utente invece vuole creare una nuova categoria utilizza questa query che aggiunge la categoria 

                //Creazione Row Categoria
                else if (scelta == 1) {
                String sqlInserisciCategoria = "INSERT INTO categorie(nome) VALUES(?)";
                PreparedStatement pstmtInserisciCategoria = conn.prepareStatement(sqlInserisciCategoria);
                System.out.println("inserisci il nome dela categoria");
                String nomeCategoria = input.nextLine();
                pstmtInserisciCategoria.setString(1, nomeCategoria);
                pstmtInserisciCategoria.executeUpdate();}