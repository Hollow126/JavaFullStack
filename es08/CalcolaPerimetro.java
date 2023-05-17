package es08;

import java.util.*;

public class CalcolaPerimetro 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);           // creazione oggetto di classe Scanner di nome Tastiera
        boolean numInseritoCorrettamente=false;
        while (numInseritoCorrettamente == false) 
        {
            try                                                 
            {       
                System.out.println("inserisci il tuo nome");     
                String nome =tastiera.nextLine();
                System.out.println("inserisci la base");     
                double base = Double.parseDouble(tastiera.nextLine());
                System.out.println("scrivi la altezza");
                double altezza = Double.parseDouble(tastiera.nextLine());
                if (base >= 40 || altezza >= 40)
                {
                    System.out.println(" ehy " + nome + " il numero è troppo grande (maggiore di 40), riprova con un numero più piccolo ");
                    numInseritoCorrettamente=false;
                }
                else
                {
                    double area = base*altezza;
                    double perimetro = base*2 + altezza*2;
                    System.out.println("ciao "+ nome + " l'area è " + area + ", il perimetro è " + perimetro);
                    numInseritoCorrettamente=true;
                }
            } 
            catch (InputMismatchException e) 
            {                                            
                System.out.println("inserisci un unita del valore richiesto");
            }
            catch(NumberFormatException e)
            {
                System.out.println("inserisci un unita del valore richiesto");
            }
        }
        tastiera.close();             
    }
}