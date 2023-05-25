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
        boolean uscitoDallaStanza = false;
        boolean morto = false;
        boolean grimaldelloRaccolto = false;
        boolean nightmareMode = false;
        boolean oggettoUsato = false;
        boolean oggettoUsato2 = false;
        boolean portaAperta = false;
        String inputUtente = "0";
        System.out.println("il tempo di alzarti da terra vedi accendersi una sirena ed una luce si accenda con un timer rosso che sta scendendo il primo numero era 200 \n 199... \n 198... \n 197..");
        

        while (uscitoDallaStanza == false && nightmareMode== false &&morto == false) 
        {
            System.out.println("dove vai ?  attorno a te vedi un grimaldello (1) ,una mattonella rotta (2)"); 
            System.out.println(" un letto (3) , un muro con qualcosa scritto sopra di non ben preciso (4)");
            System.out.println("il muro contenente la fiaccola (5), una porta sotto il timer (6), un bottone in un angolo (7),un comodino (8) , un armadio (9)");
            inputUtente = tastiera.nextLine();
            switch (inputUtente) {
                case "1":     //grimaldello
                    if (inventario.contains("grimaldello") || grimaldelloRaccolto == true) 
                    {
                        System.out.println("non c'è niente altro, torni indietro");
                        break;
                    } 
                    else 
                    {
                        aggiungiOggetto(inventario, stanza, "grimaldello");
                        grimaldelloRaccolto = true;
                        break;
                    }
                case "2": //mattonella rotta 
                if (inventario.contains("pezzoDiMattonella")) 
                {
                    System.out.println("non c'è niente altro, torni indietro");
                    break;
                }
                else 
                {
                    System.out.println("la mattonella sembra muoversi ");
                    System.out.println("se vuoi usare un oggetto digita il nome dell'oggetto altrimenti digita 0");
                    inputUtente = tastiera.nextLine();
                    oggettoUsato = usaOggettoRompendolo(inventario,stanza,inputUtente,"grimaldello");
                    if (oggettoUsato == true) 
                    {
                        System.out.println("la mattonella si spacca");
                        inventario.add("pezzoDiMattonella");
                    }
                    break;   
                }
                case "3": //letto
                {
                    System.out.println("il letto sembra richiamarti....");
                    System.out.println("se vuoi dormire premi si, se vuoi usare un oggetto digita il nome dell'oggetto altrimenti digita 0");
                    inputUtente = tastiera.nextLine();
                    oggettoUsato = usaOggettoRompendolo(inventario,stanza,inputUtente,"siringa");
                    if (inputUtente.equalsIgnoreCase("si")) 
                    {
                        System.out.println("provi a dormire, appena ti metti nel letto noti una figura osservarti");
                        System.out.println("la figura si avvicina e non riesci più a fare nulla");
                        System.out.println("la figura ti prende e ti porta con se....");
                        System.out.println("SEI MORTO");
                        morto= true;
                        break;
                    }
                    else if (oggettoUsato == true) 
                    {
                            System.out.println("ti spari la siringa nel collo e svieni");
                            nightmareMode = true;
                            break;
                    }
                    else
                    {
                        break;
                    }
                }
                case "4":  // il muro oscuro
                {
                    if (inventario.contains("fiaccola")) 
                    {
                        System.out.println("sul muro vedi una croce, una scritta che riporta \n \t \"the nightmare is the answer\" ed un disegno mostruoso sul muro ");
                        break;
                    } 
                    else 
                    {
                        System.out.println("non riesci a vedere nulla... il muro è troppo scuro");
                        break;
                    }
                }
                case "5": // fiaccola
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
                case "6":  // porta
                    if(portaAperta == false)
                    {
                        System.out.println("ce una porta ma è chiusa, digita il nome dell'oggetto per usarlo");
                        inputUtente = tastiera.nextLine();
                        oggettoUsato = usaOggettoRompendolo(inventario,stanza,inputUtente,"grimaldello");
                        oggettoUsato2 = usaOggettoMantenendolo(inventario, stanza, inputUtente, "crocifisso");
                        if (oggettoUsato == true) 
                        {
                            System.out.println("provi a usare il grimaldello ma si rompe");
                        }
                        if (oggettoUsato2 == true) 
                        {
                            System.out.println("il crocifisso vibra");
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("vuoi uscire dalla stanza ? ");
                        inputUtente = tastiera.nextLine();
                        if (inputUtente.equalsIgnoreCase("si")) 
                        {
                            System.out.println("esci dalla stanza");
                            uscitoDallaStanza = true;  
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }
                case "7": //bottone
                    if (portaAperta == false) 
                    {
                        System.out.println("c'è un bottone in un angolo, digita si per premerlo, altrimenti scrivi un oggetto per usarlo ");
                        inputUtente = tastiera.nextLine();
                        oggettoUsato = usaOggettoRompendolo(inventario, stanza, inputUtente, "pezzoDiMattonella");
                        if (inputUtente.equalsIgnoreCase("si")) 
                        {
                            System.out.println("dal muro si stacca una mattonella e una balestra ti spara, sei morto...");
                            System.out.println("SEI MORTO");
                            morto = true;    
                            break;
                        } 
                        else if (oggettoUsato == true)
                        {
                            System.out.println("noti un pezzo di muro che sembra muoversi, lo copri con la mattonella");
                            System.out.println("la porta si apre");
                            portaAperta=true;
                            break;
                        }
                        else
                        {
                            System.out.println("ti guardi stranito e torni al centro della stanza");
                            break;
                        }
                    } 
                    else 
                    {
                        System.out.println("non c'è nient'altro");
                        break;
                    }
                case "8": //comodino
                if (inventario.contains("crocifisso")) 
                {
                    System.out.println("non c'è niente altro, torni indietro");
                    break;
                } 
                else 
                {
                    System.out.println("apri il comodino, al suo interno trovi un crocifisso ed una siringa con un eticchetta con su scritto nightmare, le raccogli");
                    System.out.println("vedi anche 2 foto bruciate, nella prima  si vede una persona tenere in mano il crocifisso contro una figura nera");
                    System.out.println("nella seconda si vede una bambina che dorme in un letto ed una figura nera che la fissa ");
                    aggiungiOggetto(inventario, stanza, "crocifisso");
                    aggiungiOggetto(inventario, stanza, "siringa");
                    break;
                }
                case "9": //armadio
                    {
                        System.out.println("Ci sono delle ossa ed un teschio per terra, sembra che qualcuno si sia nascosto all'interno e sia morto soffocato");
                        break;
                    }
                default:
                    System.out.println("Inserisci un numero valido, va bene essere spaesato, ma zio leggi le istruzioni....");
                    break;
            }
        }

        while(uscitoDallaStanza == false && nightmareMode == true && morto == false)
        {
            System.out.println("continua 1 ");   // continua a giocare ma la stanza e diversa finche non esci 
        }

        while(uscitoDallaStanza== true && nightmareMode == false  && morto == false)
        {
            System.out.println("continua 2 "); // mostro lo vedi ma non puoi combatterlo,puoi solo fuggire ma morirai comunque nell'armadio, se usi il crocifisso muori 
        }
        while (uscitoDallaStanza== true && nightmareMode == true  && morto == false) 
        {
            System.out.println("continua 3"); // sei te il mostro e lo uccidi, poi vedrai un altra stanza con un altra persona che si risveglia 
        }
    }


    public static void aggiungiOggetto(List<String> inventario, List<String> oggettiStanza, String oggettoDaRaccogliere ) 
    {
        oggettiStanza.remove(oggettoDaRaccogliere);
        inventario.add(oggettoDaRaccogliere);
        System.out.println("il tuo inventario contiene: " + inventario);
    }

    public static boolean usaOggettoRompendolo(List<String> inventario,List<String> oggettiStanza,String inputUtente , String oggettocorretto) 
    {
        if (inventario.contains(inputUtente) && inputUtente.equalsIgnoreCase(oggettocorretto)) 
            {
                inventario.remove(inputUtente);
                // System.out.println(inputUtente + "usato");
                // System.out.println("il tuo inventario contiene: " + inventario);
                return true;   
            } 
            else if (!inventario.contains(inputUtente)) 
            {
                System.out.println("nessun oggetto corrispondente");
                return false;
            }
            else if (inputUtente!= oggettocorretto)
            {
                System.out.println("provi a usare " + inputUtente + " ma non succede nulla");
                return false;
            }
            else{
                System.out.println("errore ");
                return false;
            }
    }
    

    public static boolean usaOggettoMantenendolo(List<String> inventario,List<String> oggettiStanza,String inputUtente , String oggettocorretto) 
    {
        if (inventario.contains(inputUtente) && inputUtente.equalsIgnoreCase(oggettocorretto)) 
            {
                //inventario.remove(inputUtente);
                // System.out.println(inputUtente + "usato");
                // System.out.println("il tuo inventario contiene: " + inventario);
                return true;   
            } 
            else if (!inventario.contains(inputUtente)) 
            {
                System.out.println("nessun oggetto corrispondente");
                return false;
            }
            else if (inputUtente!= oggettocorretto)
            {
                System.out.println("provi a usare " + inputUtente + " ma non succede nulla");
                return false;
            }
            else{
                System.out.println("errore ");
                return false;
            }
    }
}
