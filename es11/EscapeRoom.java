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
        String inputUtente = "0";
        System.out.println("il tempo di alzarti da terra vedi accendersi una sirena ed una luce si accenda con un timer rosso che sta scendendo il primo numero era 200 \n 199... \n 198... \n 197..");
        

        while (uscitoDallaStanza == false && morto == false) 
        {
            System.out.println("dove vai ?  attorno a te vedi un grimaldello (1) ,una mattonella rotta (2), un letto (3) , un muro con qualcosa scritto sopra di non ben preciso (4) \n il muro contenente la fiaccola (5), una porta sotto il timer (6), un bottone in un angolo (7),un comodino (8) , un armadio (9)  ");
            inputUtente = tastiera.nextLine();
            switch (inputUtente) {
                case "1":
                    if (inventario.contains("grimaldello")) 
                    {
                        System.out.println("non c'è niente altro, torni indietro");
                        break;
                    } 
                    else 
                    {
                        aggiungiOggetto(inventario, stanza, "grimaldello");
                        break;
                    }
                case "2":
                    System.out.println("la mattonella sembra muoversi ");
                    if(inventario.contains("grimaldello") && usaOggetto(inventario,stanza,inputUtente)==true)


                    break;
                case "5":
                    if (inventario.contains("fiaccola")) 
                    {
                        System.out.println("non c'è niente altro, torni indietro");
                        break;
                    } 
                    else 
                    {
                        System.out.println("raccogli la fiaccola");
                        aggiungiOggetto(inventario, stanza, "fiaccola");
                        break;
                    }   
                case "7":
                    System.out.println("c'è un bottone in un angolo, lo premi ? ");
                    if (tastiera.nextLine().equalsIgnoreCase("si")) 
                    {
                        System.out.println("dal muro si stacca una mattonella e una balestra ti spara, sei morto...");
                        morto = true;    
                        break;
                    } 
                    else 
                    {
                        System.out.println("ti guardi un attimo stranito e torni nel centro della stanza");
                        break;
                    }
                case "9":
                    eventoArmadio(mostroAllertato);
                default:
                    System.out.println("Inserisci un numero valido, va bene essere spaesato, ma zio leggi le istruzioni....");
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

    public static boolean usaOggetto(List<String> inventario,List<String> oggettiStanza,String inputUtente , String oggettocorretto) 
    {
        System.out.println("se vuoi usare un oggetto digita il nome dell'oggetto altrimenti digita 0");
        if (inventario.contains(inputUtente) && inputUtente == oggettocorretto) 
        {
            inventario.remove(inputUtente);
            System.out.println(inputUtente + "usato");
            System.out.println("il tuo inventario contiene: " + inventario);
            return true;   
        } 
        else if (inputUtente!= oggettocorretto) 
        {
            System.out.println("non succede nulla");
            return false;
        }
        else
        {
            System.out.println("nessun oggetto corrispondente");
            return false;
        }
    }

    public static void eventoArmadio(boolean mostroAllertato) 
    {
        if (mostroAllertato) {
            
        } 
        else 
        {
            
        }
        // sevira a scappare poi dal mostro, se ce il mostro allertato puoi entrarci dentro, se non ce nessuno l'armadio è vuoto
        System.exit(0);
    }
}
