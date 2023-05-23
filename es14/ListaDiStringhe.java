package es14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * ListaDiStringhe
 */



 // correggere, non escce dal while
public class ListaDiStringhe 
{

    

        public static void main(String[] args) 
        {
            Scanner tastiera = new Scanner(System.in);
            
            List<String> listaInteri = new ArrayList<String>();
            System.out.println("inserisci Stringhe della lista, digita 0 per smettere di inserire elementi");
            String elemento = tastiera.nextLine();
            while (elemento.equals(0))
            {
                listaInteri.add(elemento);
                System.out.println("inserisci Stringhe della lista, digita 0 per smettere di inserire elementi");
                elemento = tastiera.nextLine();
            }
            System.out.println("dimmi la Stringhe che vuoi trovare nella lista");
            String elementoDaTrovare = tastiera.nextLine();
            cercaLista(listaInteri, elementoDaTrovare);
            tastiera.close();
    
        }
    
    
    
        public static void cercaLista (List<String> listaInteri, String elementoDaTrovare) 
        {
            if (listaInteri.contains(elementoDaTrovare)) 
            {
                System.out.println("la Stringha esiste, ed è all'indice " + listaInteri.indexOf(elementoDaTrovare));
            }
            else
            {
                System.out.println("la Stringa non esiste");
            }
            return;
        }
    }
