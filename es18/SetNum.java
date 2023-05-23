package es18;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetNum 
{
    public static void main(String[] args) 
    {
    Scanner input = new Scanner(System.in);

    Set<Integer> setNumeri = new HashSet<Integer>();
    System.out.println("Inserisci gli interi separati da uno spazio:");
    String[] numeri = input.nextLine().split(" ");
    for (String numero : numeri) {
      setNumeri.add(Integer.parseInt(numero));
    }
    System.out.println("il numero di elementi inseriti è " + numeri.length);
    System.out.print("i numeri inseriti sono ");
    for (String numero : numeri) 
    {
        System.out.print(numero + " ");    
    }
    System.out.println();
    System.out.println("il numero di element del set è " + setNumeri.size());
    System.out.println("Il Set senza duplicati è:");
    for (int numero : setNumeri) {
      System.out.print(numero + " ");
    }

    input.close();
  }
}
