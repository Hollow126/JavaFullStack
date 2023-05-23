package es15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// non funziona come dovrebbe

public class Coda 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);
        Queue<String> coda = new LinkedList<String>();
        System.out.println("inserisci Stringhe della lista, digita \" fine \" per smettere di inserire elementi");
        String elemento = tastiera.nextLine();
        while (!elemento.equals("fine"))
        {
            coda.add(elemento);
            elemento=tastiera.nextLine();
        }
        System.out.println("gli elementi della coda sono :" ); // + coda
        while (!coda.isEmpty()) 
        {
            System.out.println(coda.remove());      
        }
        tastiera.close();
    }
}
