package es11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class HorrorEscapeRoom 
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner tastiera = new Scanner(System.in);
        List<String> inventario = new ArrayList<String>();
        // mettere una mappa di stringhe int in modo che quando scegli una opzione la rimuovi dallla possibile scelta da fare, potenzialmente lo switch potrebbe non servire, ma meglio mantenerlo
        Map<Integer,String> ListaSceltePreda1 = new HashMap<Integer ,String>();

        ListaSceltePreda1.put(1, "vedi un grimaldello affianco a te");
        ListaSceltePreda1.put(2, "una mattonella rotta");
        ListaSceltePreda1.put(3, "un letto ");
        ListaSceltePreda1.put(4, "un muro ombroso ");
        ListaSceltePreda1.put(5, "una fiaccola sul muro ");
        ListaSceltePreda1.put(6,"porta ");
        ListaSceltePreda1.put(7, "bottone ");
        ListaSceltePreda1.put(8, "comodino ");
        ListaSceltePreda1.put(9, "armadio ");
        ListaSceltePreda1.put(10, "specchio ");
        ListaSceltePreda1.put(11, "inventario ");
        ListaSceltePreda1.put(12, "fondi oggetti ");


        boolean uscitoDallaStanza = false;
        boolean morto = false;
        boolean nightmareMode = false;
        boolean oggettoUsato = false;
        boolean oggettoUsato2 = false;
        boolean portaAperta = false;
        String inputUtente = "0";
       // printAnimated("il tempo di alzarti da terra vedi accendersi una sirena ed una luce si accenda con un timer rosso che sta scendendo il primo numero era 200" ,80);
       // printAnimated("199...",100);
       // printAnimated("198...",100);
       // printAnimated("197...",100);
        int velocitatesto;
        System.out.println("inserisci la velocita del testo (1 = lenta,2 = media 3 = veloce)");
        try 
        {
            velocitatesto = Integer.parseInt(tastiera.nextLine());
            if (velocitatesto == 1) 
            {
                velocitatesto = 100;
                printAnimated("hai scelto testo lento", velocitatesto);
            } 
            else if (velocitatesto==2) 
            {
                velocitatesto = 50;
                printAnimated("hai scelto testo normale", velocitatesto);
            }
            else
            {
                velocitatesto =20;
                printAnimated("hai scelto testo veloce", velocitatesto);
            }  
        } 
        catch (NumberFormatException e) 
        {
            velocitatesto =30;
            printAnimated("non hai scelto un valore valido, vbb tieniti il testo veloce", velocitatesto);
        }
        printAnimated("ti risvegli in una stanza buia illuminata solo dalla luce di una fiaccola mezza spenta \n la stanza nonostante sia in delle condizioni pessime, con del sangue ovunque ha comunque sia un qualcosa di moderno, vedi delle luci in cima ",velocitatesto);
        while (uscitoDallaStanza == false && nightmareMode== false && morto == false) 
        {
            for (Map.Entry<Integer, String> entry : ListaSceltePreda1.entrySet()) 
            {
              if (entry.getKey()% 2 == 0) 
              {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " ");
              } 
              else 
              {
                System.out.print(entry.getKey() + ": " + entry.getValue() + "\t");
              }  
              
            }
            inputUtente = tastiera.nextLine();
            switch (inputUtente) {
                case "1":     //grimaldello
                    if (ListaSceltePreda1.containsKey(1)) 
                    {
                        printAnimated("raccogli il grimaldello da terra ",35);
                        //System.out.println("non c'è niente altro, torni indietro");
                        aggiungiOggetto(inventario, "grimaldello");
                        ListaSceltePreda1.remove(1);
                        break;
                    } 
                    else 
                    {
                        System.out.println("numero non valido");
                        break;
                    }
                case "2": //mattonella rotta 
                    if (ListaSceltePreda1.containsKey(2)) 
                    {
                        System.out.println("la mattonella sembra muoversi ");
                        System.out.println("se vuoi usare un oggetto digita il nome dell'oggetto altrimenti digita 0");
                        inputUtente = tastiera.nextLine();
                        oggettoUsato = usaOggettoRompendolo(inventario,inputUtente,"grimaldello");
                        if (oggettoUsato == true) 
                        {
                            System.out.println("la mattonella si spacca, hai raccolto un pezzoDiMattonella ");
                            inventario.add("pezzoDiMattonella");
                            ListaSceltePreda1.remove(2);
                            break;   
                        }
                        else
                        {
                            messaggioOggettoUsatoO_NonCorretto(inventario,inputUtente);
                            break; 
                        } 
                    }
                    else 
                    {
                        System.out.println("numero non valido");
                        break;
                    }
                case "3": //letto
                {
                    System.out.println("il letto sembra richiamarti....");
                    System.out.println("se vuoi dormire premi si, se vuoi usare un oggetto digita il nome dell'oggetto altrimenti digita 0");
                    inputUtente = tastiera.nextLine();
                    oggettoUsato = usaOggettoRompendolo(inventario,inputUtente,"siringa");
                    if (inputUtente.equalsIgnoreCase("si")) 
                    {
                        System.out.println("provi a dormire, appena ti metti nel letto noti una figura osservarti");
                        System.out.println("vuoi provare ad usare un oggetto? digita il suo nome per usarlo");
                        inputUtente = tastiera.nextLine();
                        oggettoUsato = usaOggettoMantenendolo(inventario, inputUtente, "crocifisso");
                        if (oggettoUsato == true) 
                        {
                            System.out.println("riesci a tirare fuori il crocifisso, lo punti contro la figura nera");
                            System.out.println("la figura nera scompare, mentre scompare noti che la porta si è aperta");
                            portaAperta = true;
                            break;
                        } 
                        else 
                        {
                            messaggioOggettoUsatoO_NonCorretto(inventario, inputUtente);
                            System.out.println("la figura si avvicina e non riesci più a fare nulla");
                            System.out.println("la figura ti prende e ti porta con se....");
                            printAnimated("SEI MORTO",200);
                            morto= true;
                            break;
                        }
                    }
                    else if (oggettoUsato == true) 
                    {
                            printAnimated("utilizzi la siringa iniettandola nella vena del collo e svieni sul letto",100); 
                            nightmareMode = true;
                            printAnimated("dopo esserti iniettato la siringa ed esserti addormentato ti risvegli, ma le cose attorno a te sembrano diverse.... ", 100);
                            printAnimated("attorno a te adesso vedi tutto chiaramente, riesci a percepire molte più cose rispetto a prima", 100);
                            printAnimated("ti rendi conto di avere perso tutti quanti i tuoi oggetti", 100);
                            break;
                    }
                    else
                    {
                        messaggioOggettoUsatoO_NonCorretto(inventario, inputUtente);
                        break;
                    }
                }
                case "4":  // il muro oscuro
                    if (ListaSceltePreda1.containsKey(4)) 
                    {
                        if (inventario.contains("fiaccola")) 
                        {
                            printAnimated("Utilizzi la fiaccola per fare luce. sul muro vedi una croce, una scritta che riporta \n \"the nightmare is the answer\" \n assieme ad un disegno che raffigura una persona che assomiglia a te, insieme ad un altra persona con le sembianze da mostro, divisa da un muro  ", 100);
                            ListaSceltePreda1.remove(4);
                            break;
                        } 
                        else 
                        {
                            System.out.println("non riesci a vedere nulla... il muro è troppo scuro");
                            break;
                        }
                    }
                    else 
                    {
                        System.out.println("numero non valido");
                        break;
                    }
                case "5": // fiaccola
                if (ListaSceltePreda1.containsKey(5)) 
                {
                    System.out.println("raccogli la fiaccola");
                    aggiungiOggetto(inventario, "fiaccola");
                    ListaSceltePreda1.remove(5);
                    break;
                } 
                else 
                {
                    System.out.println("numero non valido");
                    break;
                }
                case "6":  // porta
                    if(portaAperta == false)
                    {
                        System.out.println("ce una porta ma è chiusa,percepisci qualcosa di malvagio fuori dalla porta.....  \ndigita il nome di un oggetto per usarlo");
                        inputUtente = tastiera.nextLine();
                        oggettoUsato = usaOggettoRompendolo(inventario,inputUtente,"grimaldello");
                        oggettoUsato2 = usaOggettoMantenendolo(inventario, inputUtente, "crocifisso");
                        if (oggettoUsato == true) 
                        {
                            System.out.println("provi a usare il grimaldello ma si rompe");
                            break;
                        }
                        else if (oggettoUsato2 == true) 
                        {
                            System.out.println("il crocifisso vibra se puntato verso la porta,  e vibrando sembra come se ci fosse qualcosa al suo interno");
                            break;
                        }
                        else if (oggettoUsato == false && oggettoUsato2 == false)
                        {
                            messaggioOggettoUsatoO_NonCorretto(inventario, inputUtente);
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("vuoi uscire dalla stanza ? ");
                        inputUtente = tastiera.nextLine();
                        if (inputUtente.equalsIgnoreCase("si")) 
                        {
                            if(inventario.contains("fiaccola"))
                            {
                                printAnimated("esci dalla stanza,la stanz nel quale entri è molto buia ma con la fiaccola riesci a vedere che il posto nel quale sei entrato è identico a quello in cui ti sei risvegliato, solo che è specchiato",100);
                                uscitoDallaStanza = true;  
                                break;
                            }
                            else
                            {
                                printAnimated("l'altra stanza è molto buia, apppena fai un passo nell'altra stanza, delle mani ti prendono di soprassalto i piedi, e ti trascinano con loro verso destra",100);
                                printAnimated("SEI MORTO",200);
                                morto= true;
                                break;
                            }
                        }
                        else
                        {
                            break;
                        }
                    }
                case "7": //bottone
                    if (ListaSceltePreda1.containsKey(7)) 
                    {
                        if (portaAperta == false) 
                        {
                            System.out.println("c'è un bottone in un angolo, digita si per premerlo, altrimenti scrivi un oggetto per usarlo ");
                            inputUtente = tastiera.nextLine();
                            oggettoUsato = usaOggettoRompendolo(inventario,inputUtente, "pezzoDiMattonella");
                            if (inputUtente.equalsIgnoreCase("si")) 
                            {
                                System.out.println("dal muro si stacca una mattonella, una mano esce dal muro, ti prende e ti trascina con te....");
                                printAnimated("SEI MORTO",200);
                                morto = true;    
                                break;
                            } 
                            else if (oggettoUsato == true)
                            {
                                System.out.println("noti un pezzo di muro che sembra muoversi, lo copri con la mattonella");
                                System.out.println("la porta si apre");
                                portaAperta=true;
                                ListaSceltePreda1.remove(7);
                                break;
                            }
                            else
                            {
                                messaggioOggettoUsatoO_NonCorretto(inventario, inputUtente);
                                System.out.println("ti guardi stranito e torni al centro della stanza");
                                break;
                            }
                        }                     
                    }   
                    else 
                    {
                        System.out.println("numero non valido");
                        break;
                    }
                case "8": //comodino
                if (ListaSceltePreda1.containsKey(8)) 
                {
                    printAnimated("apri il comodino, al suo interno trovi un crocifisso ed una siringa con un eticchetta con su scritto nightmare, le raccogli",100);
                    printAnimated("vedi anche 2 foto bruciate, nella prima  si vede uno scienziato ed un prete dall'alto che osservano gruppi di persone divisi in coppie uccidersi tra loro",100);
                    printAnimated("nella seconda si vede una bambina che dorme in un letto pieno di crocifissi ed una figura nera che la fissa ",100);
                    aggiungiOggetto(inventario, "crocifisso");
                    aggiungiOggetto(inventario, "siringa");
                    ListaSceltePreda1.remove(8);
                    break;
                } 
                else 
                {
                    System.out.println("numero non valido");
                    break;
                }
                case "9": //armadio
                    if (ListaSceltePreda1.containsKey(9)) 
                    {
                        System.out.println("Ci sono delle ossa ed un teschio per terra, sembra che qualcuno si sia nascosto all'interno e sia morto soffocato");
                        ListaSceltePreda1.remove(9);
                        // inserisci la possibilità di mettere il primo pezzo di chiave (dare come hint chiave a forma di crocifisso )
                        break;
                    }
                    else
                    {
                        System.out.println("numero non valido");
                    }    
                case "10": //specchio
                    if (ListaSceltePreda1.containsKey(10)) 
                    {
                        printAnimated("Ti guardi allo specchio e non noti nulla di insolito",80);
                        ListaSceltePreda1.remove(10);
                        // inserisci la possibilità di mettere il primo pezzo di chiave (dare come hint chiave a forma di crocifisso )
                        break;
                    }    
                    else
                    {
                        System.out.println("numero non valido");
                        break;
                    }  
                case "11": //mostra inventario
                    {
                        System.out.println("il tuo inventario è " + inventario);
                        break;
                    }
                case "12": //unisci 2 oggetti
                    {
                        System.out.println("il tuo inventario è " + inventario + " quali oggetti vuoi fondere? digita il nome di entrambi gli oggetti separati da una virgola ");
                        inputUtente=tastiera.nextLine();
                        unioneOggetti(inventario, inputUtente, "", "", "chiaveCrocifisso");
                        break;
                    }   
                default:
                    System.out.println("Inserisci un numero valido, va bene essere spaesato, ma zio leggi le istruzioni....");
                    break;
            }
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// continua a giocare ma la stanza e diversa finche non esci ( quindi non esci dalla porta)
        while(uscitoDallaStanza == false && nightmareMode == true && morto == false)
        {
            int contaturni = 1;
            inventario.clear();
           // printAnimated("dopo esserti iniettato la siringa ed esserti addormentato ti risvegli, ma le cose attorno a te sembrano diverse.... ", 100);
           // printAnimated("attorno a te adesso vedi tutto chiaramente, riesci a percepire molte più cose rispetto a prima", 100);
            printAnimated("", 100);
            System.out.println("dove vai ? "); 
            System.out.println(" un letto (1) , un muro con qualcosa scritto sopra (2), uno specchio (3)");
            System.out.println("prova a sentire cosa senti dal'altra stanza (4), una porta sotto il timer (6), una fessura in un angolo (7),un comodino (8) , un armadio (9) "); 
            while ((contaturni > 10)) 
            {
                switch (contaturni) {
                    case 1:
                        // la preda si sveglia 
                        break;
                    case 2:
                        // la preda urla 
                        break;
                    case 3:
                        //la preda è terrorizzata dall'armadip
                        break;
                    case 4:
                        // puoi uccidere la preda usando l'armadio 
                        break;
                    case 5:
                        // la preda clicca il bottone  
                        break;
                    case 6:
                        // puoi uccidere la preda dal bottone 
                        break;
                    case 8:
                        // la preda apre la porta con il crocifisso e la chiave sciolta dal crocifisso 
                        break;
                    case 10:
                        // la preda ti uccide x forza 
                        break;
                
                    default:
                        break;
                }
            }
            inputUtente = tastiera.nextLine();
            switch (inputUtente) {
                case "1":     //grimaldello
                    if (inventario.contains("grimaldello")) 
                    {
                        System.out.println("non c'è niente altro, torni indietro");
                        break;
                    } 
                    else 
                    {
                        aggiungiOggetto(inventario, "grimaldello");
                        break;
                    } 
                default:
                    System.out.println("Inserisci un numero valido, va bene essere spaesato, ma zio leggi le istruzioni....");
                    break;

            //sei nella seconda stanza dove c'è l'altra persona, se esci dalla stanza uccidi l'altro, controlla se la porta è aperta o meno 
            //lore sugli scienziat e le 2 stanze con il cacciaotore e prede 
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// mostro lo vedi ma non puoi combatterlo,puoi solo fuggire ma morirai comunque nell'armadio, se usi il crocifisso muori, l'unico modo è scappare via usando i 2 pezzi di chiave
        while(uscitoDallaStanza== true && nightmareMode == false  && morto == false)
        {
            System.out.println("continua 2 "); 
            // inserisci il combattimento, evento armadio ed il dialogo, inserici lo specchio  
        
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// sei te il mostro e lo uccidi, poi vedrai un altra stanza con un altra persona che si risveglia 
        while (uscitoDallaStanza== true && nightmareMode == true  && morto == false) 
        {
            System.out.println("continua 3"); 
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (morto==true)
        {
            printAnimated("HINT UTILI : \n 1 l'antro nel quale sei è molto pericoloso, tuttavia sul muro vi è un indizio molto importante \n 2 dicono che perdersi nei sogni sia sbagliato, pero fors non lo è perdersi negli incubi ?" , 20);
        }
        else
        {
            System.out.println("finale ");
        }
    }
    tastiera.close();
    }


    public static void aggiungiOggetto(List<String> inventario, String oggettoDaRaccogliere ) 
    {
        inventario.add(oggettoDaRaccogliere);
        System.out.println("il tuo inventario contiene: " + inventario);
    }

    public static boolean usaOggettoRompendolo(List<String> inventario,String inputUtente , String oggettocorretto) 
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
                //System.out.println("nessun oggetto corrispondente");
                return false;
            }
            else if (inputUtente!= oggettocorretto)
            {
                //System.out.println("provi a usare " + inputUtente + " ma non succede nulla");
                return false;
            }
            else
            {
                System.out.println("errore ");
                return false;
            }
    }
    

    public static boolean usaOggettoMantenendolo(List<String> inventario,String inputUtente , String oggettocorretto) 
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
                // System.out.println("nessun oggetto corrispondente");
                return false;
            }
            else if (inputUtente!= oggettocorretto)
            {
                // System.out.println("provi a usare " + inputUtente + " ma non succede nulla");
                return false;
            }
            else
            {
                System.out.println("errore ");
                return false;
            }
    }

    public static void messaggioOggettoUsatoO_NonCorretto(List<String> inventario,String inputUtente) 
    {
        if (!inventario.contains(inputUtente)) 
        {
            System.out.println("nessun oggetto corrispondente");
        
        }
        else if (inventario.contains(inputUtente))
        {
            System.out.println("provi a usare " + inputUtente + " ma non succede nulla");
        }
    }
    public static void unioneOggetti(List<String> inventario,String inputUtente, String oggettoDaFondere1 ,String oggettoDaFondere2 , String oggettoFuso) 
    {
        String[] oggettiSingoli = inputUtente.split(",");
        if (oggettiSingoli.length==0) 
        {
            System.out.println("inserisci le parole staccandole da una virgola ");    
        } 
        else 
        {
         //prendi array di 
            if ((oggettiSingoli[0].equalsIgnoreCase(oggettoDaFondere1) && oggettiSingoli[1].equalsIgnoreCase(oggettoDaFondere2)) || (oggettiSingoli[1].equalsIgnoreCase(oggettoDaFondere1) && oggettiSingoli[0].equalsIgnoreCase(oggettoDaFondere2)) ) 
            {
                System.out.println("hai utilizzato gli oggetti : " + oggettiSingoli[0] + " e " + oggettiSingoli[1] + " ed hai creato " + oggettoFuso);         
                inventario.add(oggettoFuso);
            } 
            else 
            {
                System.out.println("gli oggetti : " + oggettiSingoli[0] + " e " + oggettiSingoli[1] + " uniti, non fanno nulla");         
            }
        }
    }



    public static void printAnimated(String action,int time) throws InterruptedException {
        for (char c : action.toCharArray()) {
            System.out.print(c);
            Thread.sleep(time); // aggiunto il tempo tra una riga e l'altra
        }
        System.out.println(); // Stampa una nuova riga alla fine di ogni azione
    }
}



/* ◘ prova a creare un metodo a parte che in ogni else scriva il messaggio di errore adatto al utente ("passandogli input utente ed inventario utente")  ◘ 
 * 
 *♥ FARE potere in parte preda potere vincere, scogliendo il crocifisso, ottenere il primo pezzo di chiave, uscire dalla stanza, rubare il pezzo di chiave e uscire dalla stanza originaria 


    parte del predatore fare in modo che possa uccidere la preda utilizzando il contaturni in modod che dia uan possibile azione alla preda 

    se apri la stanza e poi usi la siringa ottieni il finale segreto dove ci sono 2 mostri ed uscite dalla stanza 

    inserire metodo fusione oggetti 
    inserire la chiave sul muro ed una granata emp nel armadio 

    //indovinello x preda dove puoi troVARE la granata emp, con indovinello da fare 

    possibile implementazione per il futuro, fare che ci siano 2 giocatori 
 

    // provare a fare un if, ad esempio nella parte del letto, per fare partire il metodo solo se ha lìoggetto nell'inventario e nel else dare errore oggeto non riconosciuto
 

 * 
*/