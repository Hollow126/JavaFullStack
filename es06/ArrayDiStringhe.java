package es06;

import java.util.Random;

public class ArrayDiStringhe 
{
    public static void main(String[] args) 
    {
        Random rand = new Random(); 
        int limite = 41; 
        int i=0;
        String[] frasi = new String [5];
        for (i=0;i<5;i++) 
        {
            frasi[i] = Integer.toString(rand.nextInt(limite));
            System.out.println(frasi[i]);
            if (i==(frasi.length-1))
            {
                System.out.println("fineArray");
            }
            
        }
        for (String frase : frasi) 
        {  
        System.out.println(frase);
        }
    }
    /*fai in modo che l'utente riempa l'array con le frasi che immette lui anziche di usare numeri random*/
}
 