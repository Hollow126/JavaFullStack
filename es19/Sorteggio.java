package es19;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sorteggio 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);
        List<String> studenti = new ArrayList<String>();
        Random rand = new Random();
        System.out.println("quanti studenti ci sono oggi?");
        Integer numeroStudenti = Integer.parseInt(tastiera.nextLine());
        
        for (int i = 0; i < numeroStudenti; i++) 
        {
            System.out.println("inserisci il nome dello studente");
            studenti.add(tastiera.nextLine());
        }
        System.out.println(studenti);
        int indiceArray = numeroStudenti;
        List<String> coppia = new ArrayList<String>();
        for (int i = 0; i < numeroStudenti; i++) 
        {
            if ((numeroStudenti%2) == 0)
            {
                int numerocasuale = rand.nextInt(indiceArray);
                System.out.println(studenti.get(numerocasuale));
                if ((indiceArray % 2) == 0) 
                { 
                    coppia.add(studenti.get(numerocasuale));
                } 
                else 
                {
                    coppia.add(studenti.get(numerocasuale));
                    System.out.println("il primo della coppia è " + coppia.get(i -1));
                    System.out.println("il secondo della coppia è " + coppia.get(i));
                }
                studenti.remove(numerocasuale);
                System.out.println(studenti);
                indiceArray --;
            }
            else
            {
                if (indiceArray == 3) 
                {
                    System.out.println("l'ultima coppia è" + studenti);
                    break;
                }
                else
                {
                    int numerocasuale = rand.nextInt(indiceArray);
                    System.out.println(studenti.get(numerocasuale));
                    if ((indiceArray % 2) == 0) 
                    { 
                        coppia.add(studenti.get(numerocasuale));
                        System.out.println("il primo della coppia è " + coppia.get(i -1));
                        System.out.println("il secondo della coppia è " + coppia.get(i));
                    } 
                    else 
                    {
                        coppia.add(studenti.get(numerocasuale));
                    }
                    studenti.remove(numerocasuale);
                    System.out.println(studenti);
                    indiceArray --;
                }
            }

        }
        //System.out.println(studenti.get(rand.nextInt(numeroStudenti)));
        //System.out.println(studenti);
        tastiera.close();

    }    
}
