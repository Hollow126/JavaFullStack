 package es07;
 import java.util.*;
 public class ListaSpesa 
 {
  
  public static void main(String[] args) 
  {
     Scanner tastiera = new Scanner(System.in);
     List<String> merce = new ArrayList<String>();
     List<String> carrello = new ArrayList<String>();
     try 
     {
     merce.add("carne");
     merce.add("prosciutto");    
     merce.add("pesce");    
     merce.add("latte");
     merce.add("pane");
     int maxCapienzaCarrello = 0; 
     while (maxCapienzaCarrello<3)
     {
         System.out.println("questa è la lista: " + merce);
         System.out.println("che cosa vuoi aggiungere al tuo carrello ? ");
         String mercePresa = tastiera.nextLine().toLowerCase();
         if (merce.remove(mercePresa) == true) 
         {
             carrello.add(mercePresa); 
             maxCapienzaCarrello++;  
             System.out.println(carrello);
         } 
         else if (merce.remove(mercePresa) == false)
         {
             System.out.println("elemento della merce non disponibile");
         }
         else
         {
             System.out.println("problema con l'input");
         }
     }
     System.out.println("il tuo carrello è " + carrello);
     }
    catch (InputMismatchException e) 
     {
         System.out.println("carattere non riconosciuto, riprova ");
     }
     tastiera.close();

  }   
 }


// la parte qua sotto la ha scritta chatGPT

// package es07;

// import java.util.Scanner;

// public class ListaSpesa {
//     public static void main(String[] args) {
//         String[] prodottiDisponibili = {"Prodotto1", "Prodotto2", "Prodotto3", "Prodotto4", "Prodotto5"};
//         String[] carrello = new String[3];
//         int carrelloIndex = 0;
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("Prodotti disponibili: ");
//         for (String prodotto : prodottiDisponibili) {
//             System.out.println(prodotto);
//         }

//         while (carrelloIndex < 3) {
//             System.out.println("\nInserisci il nome del prodotto che desideri aggiungere al carrello: ");
//             String prodottoScelto = scanner.nextLine();

//             boolean prodottoPresente = false;
//             for (int i = 0; i < prodottiDisponibili.length; i++) {
//                 if (prodottiDisponibili[i].equalsIgnoreCase(prodottoScelto)) {
//                     prodottoPresente = true;
//                     carrello[carrelloIndex] = prodottiDisponibili[i];
//                     carrelloIndex++;
//                     // Rimuovi il prodotto dalla lista dei prodotti disponibili
//                     prodottiDisponibili[i] = null;
//                     break;
//                 }
//             }

//             if (prodottoPresente) {
//                 System.out.println(prodottoScelto + " è stato aggiunto al carrello.");
//             } else {
//                 System.out.println(prodottoScelto + " non è disponibile o è già stato aggiunto al carrello.");
//             }
//         }

//         System.out.println("\nHai raggiunto la massima capienza del carrello. Ecco i prodotti nel tuo carrello: ");
//         for (String prodotto : carrello) {
//             System.out.println(prodotto);
//         }
//         scanner.close();
//     }
// }
