package es30;

import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int numeroDaIndovinare = rand.nextInt((100) + 1);
        Giocatore pg1 = new Giocatore("mario", 0);

    }
}

class Giocatore {

    private String nome;
    private int tentativo;

    public Giocatore(String nome, int tentativo) {
        this.nome = nome;
        this.tentativo = tentativo;
    }

    public String getNome() {
        return nome;
    }

    public int gettentativo() {
        return tentativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void settentativo(int tentativo) {
        this.tentativo = tentativo;
    }
}

class Gioco {
    private int numeroDaIndovinare;
    private Giocatore giocatore;

    public Gioco(int numeroDaIndovinare ,Giocatore giocatore)
    {
        this.numeroDaIndovinare=numeroDaIndovinare;
        this.Giocatore = giocatore;

    } 
    
}