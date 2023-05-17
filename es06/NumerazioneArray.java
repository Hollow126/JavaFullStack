package es06;

import java.util.*;


public class NumerazioneArray 
{
    public static void main(String[] args) 
    {
        Scanner tastiera = new Scanner(System.in);
        //Random rand = new Random(); 
        //int upperbound = 14; 
        int[] exampleArray = {1,2,3,4,5};
        // System.out.println("scrivi quanto grande vuoi l'array");
        // int dimensione = tastiera.nextInt();
        // int [] array = new int[dimensione];
        // for (int i=0;i<array.length;i++) 
        // {
        //     if (i == (array.length-1)) 
        //     {
        //         System.out.println(array[i]);
        //     }
        //     else
        //     {
        //         array[i] = rand.nextInt(upperbound);
        //         System.out.println(array[i]);
        //     }
        // }
        for(int i=0;i<=exampleArray.length;i++)
        {
      
            if (i == (exampleArray.length)) 
            {
                System.out.println("fine array");
            }
            else
            {
                //exampleArray[i] = rand.nextInt(upperbound);
                System.out.println(exampleArray[i]);
            }
        }
        tastiera.close();
    }    
}
