package es17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class CodaBanca 
{
    public static void main(String[] args) 
    {
        Queue<Integer> coda = new LinkedList<Integer>();
        Scanner tastiera = new Scanner(System.in);
        Random ransRandom = new Random();
        int sommaTempo = 0;
        int limiteTempo = 20;
        int limiteClienti = 50;
        int numClienti = (ransRandom.nextInt(limiteClienti)+1);
        for (int i = 0; i < numClienti; i++) 
        {
            coda.add(i);
            System.out.println(coda);
        }
        while (!coda.isEmpty()) 
        {   
            int tempoCliente = (ransRandom.nextInt(limiteTempo)+1);
            sommaTempo += tempoCliente;
            coda.remove();
            System.out.println("il tempo che ci ha messo questo cliente è : " + tempoCliente + " tempo tot trascorso : " + sommaTempo);
            System.out.println(coda);
        }
        tastiera.close();
        
    }
}
