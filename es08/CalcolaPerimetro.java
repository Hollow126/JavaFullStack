package es08;

import java.util.*;

public class CalcolaPerimetro 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);           // creazione oggetto di classe Scanner di nome Tastiera
        boolean eInserito=false;
        while (eInserito == false) 
        {
            try                                                 
            {        
                System.out.println("inserisci la base");     
                double base = Double.parseDouble(tastiera.nextLine());
                System.out.println("scrivi la altezza");
                double altezza = Double.parseDouble(tastiera.nextLine());
                double area = base*altezza;
                double perimetro = base*2 + altezza*2;
                System.out.println("l'area è " + area + ", il perimetro è " + perimetro);
                eInserito=true;
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


