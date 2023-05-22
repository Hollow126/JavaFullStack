package es12;

import java.util.Scanner;

public class CercaArray 
{
    public static void main(String[] args) 
    {
        Scanner Tastiera = new  Scanner(System.in);
        boolean numeroTrovato = false;
        System.out.println("Inserisci la dimensione del array");
        int dimensioneArray = Tastiera.nextInt();
        int[] array = new int [dimensioneArray];
        int indiceNumeroTrovato = -1;
        for (int i = 0; i < dimensioneArray; i++) 
        {
            System.out.println("inserisci il prossimo numero da inserire nel arrray "); 
            array[i] = Tastiera.nextInt();
        }
        System.out.println(array);
        System.out.println("inserisci il numero da cercare ");
        int numeroDaCercare=Tastiera.nextInt();
        for (int i = 0; i < dimensioneArray; i++) 
        {
            if (numeroDaCercare == array[i]) 
            {
                indiceNumeroTrovato = i;
                numeroTrovato = true;
                break;
            }    
        }
        if (numeroTrovato == true)
        {
            System.out.println("il numero da cercare è nel indice " + indiceNumeroTrovato);
        }
        else
        {
            System.out.println("il numero non è presente nel array ");
        }
        Tastiera.close();
    }
}
