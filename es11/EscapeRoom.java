package es11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscapeRoom 
{
    public static void main(String[] args) 
    {
        System.out.println("ti risvegli in una stanza buia illuminata solo dalla luce di una fiaccola mezza spenta \n la stanza nonostante sia in delle condizioni pessime, con del sangue ovunque ha comunque sia un qualcosa di moderno, vedi delle luci in cima ");
        Scanner tastiera = new Scanner(System.in);
        List<String> stanza = new ArrayList<String>();
        List<String> inventario = new ArrayList<String>();
        boolean fineGioco = false;
        boolean uscitoDallaStanza = false;
        boolean morto = false;
        boolean mostroAllertato = false; 
        int inputUtente = 0;

        while (uscitoDallaStanza == false && morto == false) 
        {
            System.out.println("il tempo di alzarti da terra vedi accendersi una sirena ed una luce si accenda con un timer rosso che sta scendendo il primo numero era 200 \n 199... \n 198... \n 197..");
            System.out.println("dove vai ?  attorno a te vedi un grimaldello (1) , un armadio (2), un letto (3) , un muro con qualcosa scritto sopra di non ben preciso (4) \n il muro contenente la fiaccola (5), una porta sotto il timer (6), un bottone in un angolo (7),un comodino (8)   ");
            inputUtente = Integer.parseInt(tastiera.nextLine());
            switch (inputUtente) {
                case 1:
                    if (inventario.contains("grimaldello")) 
                    {
                        System.out.println("non c'è niente altro");
                    } 
                    else 
                    {
                        inventario.add("grimaldello");
                    }
                    break;
                case 2:
                    eventoArmadio(0);
                default:
                    break;
            }
        }
    
    }


    public static void aggiungiOggetto(List<String> inventario, List<String> oggettiStanza, String inputUtente ) 
    {
        oggettiStanza.remove(inputUtente);
        inventario.add(inputUtente);
        System.out.println("il tuo inventario contiene: " + inventario);
    }

    public static void usaOggetto(List<String> inventario,List<String> oggettiStanza,String inputUtente) 
    {
        inventario.remove(inputUtente);
        System.out.println("il tuo inventario contiene: " + inventario);
    }
    public static void eventoArmadio(List<String> inventario,List<String> oggettiStanza,String inputUtente) 
    {
        System.exit(0);
    }
}
