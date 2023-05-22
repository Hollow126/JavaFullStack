package es13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CercaLista 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);
        
        List<Integer> listaInteri = new ArrayList<Integer>();
        System.out.println("inserisci elementi della lista, digita 0 per smettere di inserire elementi");
        int elemento = tastiera.nextInt();
        while (elemento != 0)
        {
            listaInteri.add(elemento);
            System.out.println("inserisci elementi della lista, digita 0 per smettere di inserire elementi");
            elemento = tastiera.nextInt();
        }
        int somma = sommaLista(listaInteri);
        System.out.println("la somma è " + somma);
        System.out.println("dimmi il numero che vuoi trovare nella lista");
        int elementoDaTrovare = tastiera.nextInt();
        cercaLista(listaInteri, elementoDaTrovare);
        tastiera.close();

    }


    public static Integer sommaLista (List<Integer> listaInteri) 
    {
        System.out.println(listaInteri);
        Integer somma = 0; 
        for (Integer integer : listaInteri) 
        {
            somma += integer;
        }
        return somma;
    }

    public static void cercaLista (List<Integer> listaInteri, int elementoDaTrovare) 
    {
        if (listaInteri.contains(elementoDaTrovare)) 
        {
            System.out.println("l'elemento esiste, ed è all'indice " + listaInteri.indexOf(elementoDaTrovare));
        }
        else
        {
            System.out.println("l'elemento non esiste");
        }
        return;
    }
}
