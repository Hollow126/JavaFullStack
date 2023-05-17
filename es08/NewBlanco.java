/*
 * chiedi all'utente quanti soldi ha, crea una lista di merce ed un carrello 
 * l'utente potra aggiungere elementi al carrello, ognuno di questi elementi avra un prezzo 
 * alla fine bisogna vedere se l'utente riuscira a pagare o meno cio che ha aggiunto al 
 * carrello
 * 
 */
//package es08;

import java.util.*;

public class NewBlanco 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Quanti soldi hai?");
        Double portafogli = tastiera.nextDouble();
        int indice1 = 0;
        int indice2 = 0;
        String mercePrezzo[][] = {{"carne ","pesce ","pane","latte"},{"10","20","30","40"}}; 
        System.out.println(mercePrezzo);

        List<String> merce = new ArrayList<String>();//creiamo la lista merce
        List<String> carrello = new ArrayList<String>();//creiamo la lista carrelo


        merce.add("carne");
        merce.add("prosciutto");    
        merce.add("pesce");    
        merce.add("latte");
        merce.add("pane");
      int scelta = 0;

      while(scelta != 0)
      {
        System.out.println("premi 1 per aggiungere un prodotto al carrello \n premi 0 per andare alla cassa");
        scelta = Integer.parseInt(tastiera.next());
        if (scelta == 1) 
        {
          System.out.println("Cosa vuoi aggiungere al carrello?");
          String merceDaComprare = tastiera.nextLine();
          if (merce.contains(merceDaComprare) == true)
            {
              portafogli = portafogli - 2;
              merce.remove(merceDaComprare);
              System.out.println("la merce rimasta è " + merce);
              carrello.add(merceDaComprare);
              System.out.println("il tuo carrello contiene " + carrello);
            }
          else if (merce.contains(merceDaComprare) == false)
            {
              System.out.println("la merce " + merceDaComprare + "non esiste");
            }          
          else
            {
              System.out.println("non ho idea di come tu sia finito qui dentro, complimetni");
            }
        }
      }
        System.out.println(carrello);
        System.out.println(portafogli);
     //if(portafogli > prezzoTotale){
           
        //}


    }
    
}

        // prova con ArrayList di ArrayList
       // ArrayList<ArrayList<String>> biDemArrList = new ArrayList<ArrayList<String>>();
        // ArrayList<String> merceArrayList = new ArrayList<String>(); // added () 
        // ArrayList<String> prezzi = new ArrayList<String>();
        // merceArrayList.add("carne");
        // merceArrayList.add("pesce");
        // merceArrayList.add("pane");
        // prezzi.add("10");
        // prezzi.add("5");
        // prezzi.add("8");
        // biDemArrList.add(merceArrayList);
        // biDemArrList.add(prezzi);
        // System.out.println(biDemArrList[1]);