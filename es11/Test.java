package es11;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // utilizziamo degli array, per fare in modo che i valori al suo interno siano modificabili 
        // in cima creiamo tutte le variabili che servono solo al thread secondario per dare partire il timer 
             int[] seconds = {200}; // Tempo iniziale in secondi
            int[] interval = {50}; // Intervallo di aggiornamento iniziale
            int[] secondsRemaining = {200}; // variabile aggiunta secondi rimanenti da stampare 
    
            // Creazione di un nuovo thread per eseguire il timer in background
            Thread timerThread = new Thread(() -> {
                try {
                    while (seconds[0] >= 0) {
                        // System.out.println("Secondi rimanenti: " + seconds[0]);
                        Thread.sleep(interval[0] * 1000); // Pausa in base all'intervallo attuale
    
                        if (seconds[0] > 150) {
                            interval[0] = 50; // Intervallo di aggiornamento per i secondi > 150
                            secondsRemaining[0] = secondsRemaining[0] - 50;
                            System.out.println("la sirena nella stanza si accende di rosso, il tempo rimanente è di " + secondsRemaining[0] + " secondi");
                        } else if (seconds[0] <= 150 && seconds[0] > 50) {
                            interval[0] = 10; // Intervallo di aggiornamento per 150 >= secondi > 50
                            secondsRemaining[0] = secondsRemaining[0] - 10;
                            System.out.println("la sirena nella stanza ed incomincia a girare sempre più velocemente " + secondsRemaining[0] + " secondi");
                        } else {
                            interval[0] = 5; // Intervallo di aggiornamento per i secondi <= 50
                            secondsRemaining[0] = secondsRemaining[0] - 5;
                            System.out.println("la sirena è oramai impazzita e la stanza viene avvolta in continuazione da una luce rosso che si accende e si spegne ogni mezzo secondo, il tempo rimanente è di  " + secondsRemaining[0] + " secondi");

                        }
                        
                        // Decrementa i secondi
                        seconds[0]--;
                    }
    
                    System.out.println("Timer scaduto!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
    
            // Avvio del thread del timer
            timerThread.start();
    
            // Esempio di azioni degli utenti
            for (int i = 1; i <= 200; i++) {
                System.out.println("Esecuzione dell'azione degli utenti " + i);
                Thread.sleep(1000); // Simula l'elaborazione dell'azione degli utenti
            }
    
            // Interrompi il thread del timer dopo che le azioni degli utenti sono state eseguite
            timerThread.interrupt();
        
        }
}

      

    // public static int restituisciTempo(int secondi) throws InterruptedException 
    // {
            // ActionListener taskPerformer = new ActionListener() 
            // {
            //     public void actionPerformed(ActionEvent evt) 
            //     {
            //         //...Perform a task...
    
            //         System.out.println("secondi rimanenti :" + (secondi - 4));
            //     }
            // };
            // Timer timer = new Timer(400 ,taskPerformer);
            // timer.setRepeats(true);
            // timer.start();
    
            // Thread.sleep(5000);
    //         return secondi;
            
    // }



        // public static void main(String [] args) throws InterruptedException 
   
    // {

    //     int secondiRimanenti = 200;
    //     // secondiRimanenti = restituisciTempo(secondiRimanenti);
    //     ActionListener taskPerformer = new ActionListener() 
    //     {
    //         public void actionPerformed(ActionEvent evt) 
    //         {
    //             //...Perform a task...

    //             System.out.println("secondi rimanenti :" + (secondiRimanenti - 4));
    //         }
    //     };   
    //     Timer timer = new Timer(400,taskPerformer);
    //     timer.setRepeats(true);
    //     timer.start(); 
    //     Thread.sleep(5000);
    // }