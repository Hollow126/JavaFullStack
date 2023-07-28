package com.example;

public class Guerriero extends EntitaGiocante {

    public Guerriero(int id ,String nome,int lV,int esperienza, boolean isAllley,double vita, int atkBase, int defBase, int veloxBase) {
        super(id,nome,lV,esperienza, isAllley,vita, atkBase, defBase, veloxBase);
    }

    @Override
    public void attaccaSingolo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attaccaSingolo'");
    }

    @Override
    public void attaccaMulti() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attaccaMulti'");
    }
}
