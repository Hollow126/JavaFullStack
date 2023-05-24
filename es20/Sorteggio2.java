package es20;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sorteggio2 {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Random rand = new Random();
        List<String> studenti = new ArrayList<String>();
        System.out.println("digita Default per avere i soliti 10 o qualcosaltro per farla custom");
        String inputUtente = tastiera.nextLine(); 
        if (inputUtente.equalsIgnoreCase("default")) 
        {
            studenti.add("Davide");
            studenti.add("Cristopher");
            studenti.add("Andrea");
            studenti.add("Simone");
            studenti.add("Giorgio");
            studenti.add("Emanuele");
            studenti.add("Alessandro");
            studenti.add("Greta");
            studenti.add("Tiziano");
            studenti.add("Gianluca");
            studenti.add("Gianluca");

        } 
        else 
        { 
            System.out.println("inserisci il nome dello studente, metti fine per terminare la lista");
            inputUtente = tastiera.nextLine(); 
            while (!inputUtente.equalsIgnoreCase("fine")) 
            {
                studenti.add(inputUtente);
                inputUtente = tastiera.nextLine();
            }
        }



       
       
        //System.out.println(studenti); debug per creazione LISTA

        //  Integer numeroStudenti = Integer.parseInt(tastiera.nextLine());
        //  for (int i = 0; i < numeroStudenti; i++) {
      
        //      studenti.add(tastiera.nextLine());
        //  }


         System.out.println(studenti);
         int numeroStudenti = studenti.size();
         int indiceArray = studenti.size();
         List<String> coppia = new ArrayList<String>();
         for (int i = 0; i < numeroStudenti; i++) {
             if ((numeroStudenti % 2) == 0) 
             {
                //creaCoppia(studenti, coppia, indiceArray, i, "pari");
                  int numerocasuale = rand.nextInt(indiceArray);
                  //System.out.println(studenti.get(numerocasuale)); VEDERE CHI è USCITO 
                  if ((indiceArray % 2) == 0) 
                  {
                     coppia.add(studenti.get(numerocasuale));
                  } 
                  else 
                  {
                      coppia.add(studenti.get(numerocasuale));
                      System.out.println("il primo della coppia è " + coppia.get(i - 1));
                      System.out.println("il secondo della coppia è " + coppia.get(i));
                  }
                  studenti.remove(numerocasuale);
                  // System.out.println(studenti); CON QUESTO CI STAMPA LA LISTA AGGIORNATA OGNI VOLTA
            indiceArray--;
             } 
             else 
             {
                // creaCoppia(studenti, coppia, indiceArray, i, "dispari");
                if (indiceArray == 3) 
                {
                    System.out.print("I 3 rimasti sono ");
                    for (String studente  : studenti) 
                    {
                        System.out.print(studente + " ");
                    }
                    break;
                }
                else 
                {
                    int numerocasuale = rand.nextInt(indiceArray);
                    //System.out.println(studenti.get(numerocasuale)); VEDERE CHI è USCITO
                    if ((indiceArray % 2) == 0) {
                        coppia.add(studenti.get(numerocasuale));
                        System.out.println("il primo della coppia è " + coppia.get(i - 1));
                        System.out.println("il secondo della coppia è " + coppia.get(i));
                    } else {
                        coppia.add(studenti.get(numerocasuale));
                    }
                    studenti.remove(numerocasuale);
                   // System.out.println(studenti); CON QUESTO CI STAMPA LA LISTA AGGIORNATA OGNI VOLTA
                    indiceArray--;
                  }
             }        
         // System.out.println(studenti.get(rand.nextInt(numeroStudenti)));
        // System.out.println(studenti);
        tastiera.close();
        }
    }
      



    public static void creaCoppia( List<String> primaLista, List<String> secondaLista, int dimensionePrimaLista,int indiceCiclo,String pariOdispari ) 
    {
        if (pariOdispari.equalsIgnoreCase("pari"))
        {
            Random rand = new Random();
            int numerocasuale = rand.nextInt(dimensionePrimaLista);
            //System.out.println(studenti.get(numerocasuale)); VEDERE CHI è USCITO 
            if ((dimensionePrimaLista % 2) == 0) 
            {
                secondaLista.add(primaLista.get(numerocasuale));
            } 
            else 
            {
                secondaLista.add(primaLista.get(numerocasuale));
                System.out.println("il primo della coppia è " + secondaLista.get(indiceCiclo - 1));
                System.out.println("il secondo della coppia è " + secondaLista.get(indiceCiclo));
            }
            primaLista.remove(numerocasuale);
            // System.out.println(studenti); CON QUESTO CI STAMPA LA LISTA AGGIORNATA OGNI VOLTA
            //dimensionePrimaLista--;
        }
        else if(pariOdispari.equalsIgnoreCase("dispari"))
        {
            if (dimensionePrimaLista == 3) 
            {
               System.out.print("I 3 rimasti sono ");
               for (String studente  : primaLista) 
               {
                   System.out.print(studente + " ");
               }
               //break;
            } 
            else 
            {
                Random rand = new Random();
                int numerocasuale = rand.nextInt(dimensionePrimaLista);
                //System.out.println(studenti.get(numerocasuale)); VEDERE CHI è USCITO
                if ((dimensionePrimaLista % 2) == 0) {
                    secondaLista.add(primaLista.get(numerocasuale));
                    System.out.println("il primo della coppia è " + secondaLista.get(indiceCiclo - 1));
                    System.out.println("il secondo della coppia è " + secondaLista.get(indiceCiclo));
                } else {
                    secondaLista.add(primaLista.get(numerocasuale));
                }
                primaLista.remove(numerocasuale);
               // System.out.println(studenti); CON QUESTO CI STAMPA LA LISTA AGGIORNATA OGNI VOLTA
            //    dimensionePrimaLista--;
            }
        }
    }
}

/* il mio branch */





