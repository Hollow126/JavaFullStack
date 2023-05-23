package es16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * CodaConCondizione
 */
public class CodaConCondizione 
{

    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);
        Queue<Integer> coda = new LinkedList<Integer>();
        System.out.println("aggiungi il prossimo elemento, verranno aggiunti alla coda solo elementi positivi, digita 0 per terminare di aggiungere ");
        Integer elemento = tastiera.nextInt();
        while (elemento != 0) 
        {
            if (elemento>0) 
            {
                coda.add(elemento);
                System.out.println("elemento : " + elemento + " aggiunto");
                System.out.println("aggiungi il prossimo elemento, verranno aggiunti alla coda solo elementi positivi, digita 0 per terminare di aggiungere ");
                elemento = tastiera.nextInt();

            } else 
            {
                System.out.println("elemento : " + elemento + " minore di 0, non aggiunto");
                System.out.println("aggiungi il prossimo elemento, verranno aggiunti alla coda solo elementi positivi, digita 0 per terminare di aggiungere ");
                elemento = tastiera.nextInt();    
            }    
        }
        System.out.println("la coda è " + coda);
        tastiera.close();

    

    }
}