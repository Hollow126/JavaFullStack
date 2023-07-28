package com.example;

public class Magia {
    String nome;
    String descrizione;
    int pp;

    public Magia(String nome, String descrizione, int pp) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.pp = pp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
