package es28;

public abstract class Animale {
    public String nomeProprio;
    public String numeroImmatricolamento;
    public boolean isAlive;

    public Animale(String nomeProprio, String numeroImmatricolamento)
    {
        this.nomeProprio = nomeProprio;
        this.numeroImmatricolamento = numeroImmatricolamento;
    }


    public abstract void faRumore();
    
}
