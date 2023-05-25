package es21;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MappaDiParole 
{
    public static void main(String[] args) 
    {

    Scanner input = new Scanner(System.in);

    Map<String, Integer> mappaParole = new HashMap<String, Integer>();
    System.out.println("Inserisci il testo:");
    String testo = input.nextLine();
    String[] parole = testo.split(" ");         // parole è un array che prende il testo di prima e ne crea un elemento per ogni spazio messo (ogni elemento è una parola)
    
    
    for (String parola : parole)       //per ogni parola nell'array
    {
      if (mappaParole.containsValue(2))             // se il valore associato a qualche chiave è 2 ( occhio che se qualsiasi parola è a 2 entra in sto if )
      {
        System.out.println("ce ne sono 2");                     // allora scrive sul terminale che ce ne sono 2
        mappaParole.put(parola, mappaParole.get(parola) + 1);           // poi il valore associato alla parola aumenta di 1 (come se la quantità aumentasse)
      } 
      else if (mappaParole.containsKey(parola))       // invece se dentro mappaParole vi è stata gia inserita la parola 
      {
        mappaParole.put(parola, mappaParole.get(parola) + 1);           // allora il valore associato alla parola aumenta di 1 (come se la quantità aumentasse)
      }
      else 
      {
        mappaParole.put(parola, 1);             // se non è stata inserita, allora si inserisce la parola nella lista e si setta il suo valore iniziale a 1 
      }
    }


    System.out.println("La lista delle parole e il loro conteggio è:");
    for (Map.Entry<String, Integer> entry : mappaParole.entrySet()) 
    {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    input.close();
  }
}