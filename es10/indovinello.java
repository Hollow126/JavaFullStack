/* programma che scriva i numeri da 1 a 100 poi l'utente scrive un numero e se è più grande, il numero è più grande
 * da hint, continua fino a che non azzecca il numero 
 */

package es10;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class indovinello {
    public static void main(String[] args) {
        try {
            Scanner tastiera = new Scanner(System.in);
            Random ransRandom = new Random();
            System.out.println("scegli il numero massimo che puoi indovinare");
            int limite = Integer.parseInt(tastiera.nextLine());
            int numeroDaIndovinare = (ransRandom.nextInt(limite + 1));
            boolean numeroIndovinato = false;
            int tentativi = 0;
            while (tentativi <= 5) {
                System.out.println("digita il tuo numero e vediamo se lo hai indovinato");
                int numeroUtente = Integer.parseInt(tastiera.nextLine());
                if (numeroDaIndovinare < numeroUtente) {
                    System.out.println("il tuo numero è più grande di quello che cerchi");
                    tentativi++;
                } else if (numeroDaIndovinare > numeroUtente) {
                    System.out.println("il tuo numero è più piccolo di quello che cerchi");
                    tentativi++;
                } else if (numeroDaIndovinare == numeroUtente) {
                    numeroIndovinato = true;
                    break;
                } else {
                    System.out.println("errore ? ");
                }
            }
            if (numeroIndovinato) {
                System.out.println("Ottimo lavoro, il numero "  + numeroDaIndovinare + " e stato indovinato in " + tentativi + " tentativi");
            } else {
                System.out.println("mi spiace non hai indovinato, il numero era " + numeroDaIndovinare);

            }
            tastiera.close();
        } catch (InputMismatchException e) {
            System.out.println("errore nella scrittura del input input exception");
        } catch (NumberFormatException e) {
            System.out.println("errore nella scrittura del input number format exception");
        }
    }
}
