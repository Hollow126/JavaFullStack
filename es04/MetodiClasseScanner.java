package Esecitazioni.es04;

/**
 * MetodiClasseScanner
 */
import java.util.*;

public class MetodiClasseScanner {

    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);           // creazione oggetto di classe Scanner di nome Tastiera
        try                                                 
        {                                                    // prova questa parte di codice 
            System.out.println("inserisci un numero decimale");     
            double nun_decimale = Double.parseDouble(tastiera.nextLine());
            System.out.println("scrivi una stringa");
            String stringa = tastiera.nextLine();                    // chiede al utente di inserire un decimale, una stringa ed un carattere
            System.out.println("scrivi un carattere");
            String stringaPerCarattere1 = tastiera.nextLine();
            char carattereParsato1 = stringaPerCarattere1.charAt(0);
            System.out.println("scrivi un altro carattere");
            String stringaPerCarattere2 = tastiera.nextLine();  
            char carattereParsato2 = stringaPerCarattere2.charAt(0);
            System.out.println("il decimale è " + nun_decimale);
            System.out.println("la stringa è " + stringa);
            System.out.println("il carattere 1 è " + carattereParsato1);
            System.out.println("il carattere 2 è " + carattereParsato2);
        } 
        catch (InputMismatchException e) 
        {                                             // cattura eccezzione nel caso l'utente scriva un valore del tipo diverso da quello richiesto
            System.out.println("inserisci un unita del valore richiesto");
        }
        finally
        {
            tastiera.close();          // chiude oggetto tastiera 
        }   
    }        
}