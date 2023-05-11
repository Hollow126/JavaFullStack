package Esecitazioni.es02;

import java.util.*;  // importate classe esterne 


public class DivisioneNumeri 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);  // creazione oggetto Scanner per potere leggere input
        try    
        {                                                               //prova questa parte di codice 
            System.out.println("inserisci il tuo nome "); 
            String nome = tastiera.nextLine();                  // inserimento nome del utente tramite utilizzo di nextline, viene utilizzato nextline ed una stringa, per potere prendere qualsisi carattere 
            System.out.println("ciao " + nome );
            System.out.println("inserisci primo numero");
            double primoNumero = tastiera.nextDouble();         // ottiene dei numeri double per potere fare la divisione 
            System.out.println("inserisci secondo numero");
            double secondoNumero = tastiera.nextDouble();
            if (Math.abs(primoNumero / secondoNumero) == Double.POSITIVE_INFINITY || Math.abs(primoNumero / secondoNumero) == Double.NEGATIVE_INFINITY)          // lancia una eccezzione se il risultato viene infinito
            {
                throw new ArithmeticException("Not finite");
            }
            double divisione = primoNumero / secondoNumero;
            System.out.println(nome + " la divisione è " + divisione + ".");    // esegue la divisione tra i 2 numeri 
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("input non valido, inserisci un numero intero");   // eccezione per il quale se inserisci delle string al posto dei numeri  da questo messaggaio e blocca il codice 
        }
        catch (ArithmeticException e)
        {
            System.out.println("il numero 0 non è valido, non si può dividere un numero per 0");   //eccezione per la quale se uno dei 2 numeri è 0 blocca il programma e lancia questo messaggio   
        }
        finally
        {
            tastiera.close();     // chiude oggetto tastiera 
        }
    }
}
    
