import java.util.*;

public class Negozio 
{
    public static void main(String[] args) 
    {
        Random rand = new Random();   // creazione oggetto Random per fare in modo di avere un prezzo ed una quantita casuale per i prodotti 
        int upperboundprezzo = 50;      // questi sono i limiti per il valore del prezzo e della quantità
        int upperboundquantita = 6; 
        Scanner tastiera = new Scanner(System.in);
        System.out.println("inserisci quanti soldi hai");
        double portafoglio = Double.parseDouble(tastiera.nextLine());
        int colonne = 3;               // le colonne saranno sempre 3 perchè una contiene : nome prodotto, prezzo, quantità 
        System.out.println("quanti prodotti vuoi che ci siano nel negozio ? ");
        int righe = Integer.parseInt(tastiera.nextLine());                  // all'inizio chiediamo quanti prodotti ci sono 
        String [][] arraybidimensionaleStringNegozio = new String [righe][colonne];  // creazione array  che rappresenta il negozio ed il carrello, sono della stessa
        List <String> carello = new ArrayList<String>(); // creata lista che contiene i nomi del carrello, inizialmente avevo optato per un altra array, però poi ho optato per la lista 
        for (int i = 0; i < righe; i++) 
        {
            System.out.println("digita il nome del prodotto");
            arraybidimensionaleStringNegozio[i][0] = tastiera.nextLine();           //riempimento array del negozio
            arraybidimensionaleStringNegozio[i][1]= (Integer.toString(rand.nextInt(upperboundprezzo)) /* + " $"*/); // la parte con il dollaro fa casino 
            arraybidimensionaleStringNegozio[i][2]= Integer.toString(rand.nextInt(upperboundquantita) + 1);
        }
        stampaListaBidimensionale(arraybidimensionaleStringNegozio);
        boolean importoPagato = false;   // dicahiarata variabile per il quale fino a quando non è true, il programma continua a chiedere  numero a utente
        while (importoPagato == false) 
        {
            try 
            {
                System.out.println("premi 1 per aggiungere un prodotto al carello, 2 per andare a pagare, 3 per vedere le merci,4 per vedere il carrello, 5 per togliere un prodotto dal carrello,");
                int scelta = Integer.parseInt(tastiera.nextLine());
                String inputUtente = "";
                switch (scelta) 
                {
                    case 1:        
                        System.out.println("quale prodotto vuoi comprare ");
                        inputUtente = tastiera.nextLine();
                        portafoglio = aggiungiAlCarrello(arraybidimensionaleStringNegozio,inputUtente,carello,portafoglio);
                        //stampaListaBidimensionale(arraybidimensionaleStringNegozio);
                        break;
                    case 2:
                        importoPagato = Pagamento(portafoglio, importoPagato);
                        break;
                    case 3:
                        stampaListaBidimensionale(arraybidimensionaleStringNegozio);
                        break;
                    case 4:
                        System.out.println(carello);
                        break;
                    case 5:
                        System.out.println("quale prodotto vuoi rimuovere ");
                        inputUtente = tastiera.nextLine();
                        portafoglio = rimozioneProdottoCarrello(arraybidimensionaleStringNegozio,inputUtente,carello,portafoglio);
                        break;
                    default:
                        System.out.println("inserisci un valore valido");
                        break;
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("errore nel formato di cio che hai scritto");
                continue;
            }
            
        }
        tastiera.close();
    }


    private static void stampaListaBidimensionale(String[][] listaBidimensionale)  // metodo per stampare la lista 
    {
        int rows = listaBidimensionale.length;
        int columns = listaBidimensionale[0].length;

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                System.out.print(listaBidimensionale[i][j] + " ");
            }
            System.out.println();
        }
    }



    private static Double aggiungiAlCarrello(String[][] listaBidimensionale, String inputUtente, List<String> carrello, double portafoglio)
    {
        int rows = listaBidimensionale.length;

        for (int i = 0; i < rows; i++) 
        { 
            if (inputUtente.equalsIgnoreCase(listaBidimensionale[i][0])) 
            {
                if (Integer.parseInt(listaBidimensionale[i][2])>0) 
                {
                    System.out.println(listaBidimensionale[i][0] + " aggiunta al carello");
                    //portafoglio = metodoAggiornamento(portafoglio, Double.parseDouble(listaBidimensionale[i][1]) );
                    int quantitaAggiornata = Integer.parseInt(listaBidimensionale[i][2]) - 1;
                    listaBidimensionale[i][2] = Integer.toString(quantitaAggiornata);
                    carrello.add(listaBidimensionale[i][0]);
                    portafoglio = portafoglio - Double.parseDouble(listaBidimensionale[i][1]);
                    System.out.println(portafoglio);
                    return portafoglio;
                }
                else 
                {
                    System.out.println("prodotto: " + inputUtente + " terminato");
                    return portafoglio;
                }
                
            }
        }
        System.out.println("prodotto non trovato ");
        return portafoglio;
    }
    
    private static boolean Pagamento (double portafogli, boolean importopagato)
    {
        if (portafogli>=0) 
        {
            System.out.println("importo pagato corettamente, ti sono rimasti " + portafogli + " $"); 
            importopagato=true; 
            return importopagato;   
        } 
        else if (portafogli<0)
        {
            System.out.println("non hai abbastanza soldi, togli qualcossa dal carrello ");
            importopagato=false; 
            return importopagato;
        }
        return importopagato;
    }

    // // public static double metodoAggiornamento(double valore, double prezzoDaTogliere ) 
    // // {
    // //     // Effettua le operazioni per aggiornare il valore
    // //     valore = valore- prezzoDaTogliere; // Esempio di aggiornamento, puoi modificare questa parte a seconda delle tue esigenze

    // //     return valore; // Restituisce il valore aggiornato
    // // }

    private static double rimozioneProdottoCarrello(String[][] listaBidimensionale, String inputUtente, List<String> carrello, double portafoglio) 
    {
        int rows = listaBidimensionale.length;

        for (int i = 0; i < rows; i++) 
        { 
            if (inputUtente.equalsIgnoreCase(listaBidimensionale[i][0])) 
            {
                    carrello.remove(listaBidimensionale[i][0]);
                    System.out.println(listaBidimensionale[i][0] + " rimosso dal carello");
                    int quantitaAggiornata = Integer.parseInt(listaBidimensionale[i][2]) + 1;
                    listaBidimensionale[i][2] = Integer.toString(quantitaAggiornata);
                    portafoglio = portafoglio + Double.parseDouble(listaBidimensionale[i][1]);
                    System.out.println(portafoglio);
                    return portafoglio;
            }
        }
        System.out.println("prodotto mai aggiunto al carello ");
        return portafoglio;
    }

}



// sistemare bug portafoglio che non funziona e mettere try catch nella prima parte con i continue per errori in inserimento portafoglio s