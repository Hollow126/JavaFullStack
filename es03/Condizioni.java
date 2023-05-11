/* Titolo : Verifica maggiore eta utente 
 * Scopo : chieder al utente il propiro nome e la sua età, poi  
 * dare un messaggio specifico a differenza se l'utente è maggiorenne o meno
*/

package Esecitazioni.es03;  // creazione Package

import java.util.*;         // import liberia esterna per fare funzionare lo Scanner 

public class Condizioni 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);           // creazione oggetto di classe Scanner di nome Tastiera
        try                                                 
        {                                                    // prova questa parte di codice 
            System.out.println("scrivi il tuo nome ");     
            String nome = tastiera.nextLine();
            System.out.println("scrivi la tua età ");
            int eta = tastiera.nextInt();                  // chiede al utente il proprio nome e la propria eta, andandole a salvare nella variabile nome ed età
            if(eta >= 18)
            {
                System.out.println("ciao " + nome + " benvenuto nel sito");     // se età è maggiore di 18,  restituisce questo messaggio 
            }
            else if(eta<=0)
            {
                System.out.println("età non valida ");                      // se età è minore o uguale a 0 restituisce questo messaggio 
            }
            else 
            {
                System.out.println("utente non maggiorenne accesso negato ");       // se età è minore di 18 restituisce questo messaggio 
            }
        } 
        catch (InputMismatchException e)                                              // cattura eccezzione nel caso l'utente scriva un numero con la virgola o 
        {                                                                             // una stringa al posto dell'intero e restituisce questo messaggio 
            System.out.println("inserisci un valore valido per l'eta, 0 ed i numeri con la virgola non sono autorizzati");
        }
        finally
        {
            tastiera.close();          // chiude oggetto tastiera 
        }   
    }
}
