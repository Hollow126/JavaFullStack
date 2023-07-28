package com.example;

import java.util.ArrayList;
import java.util.List;

public abstract class EntitaGiocante {
  protected int id;
  protected String nome;
  protected int lV;
  protected int esperienza;
  protected boolean isAlley;

  protected double vita;
  protected int atkBase;
  protected int defBase;
  protected int velocita;
  protected List<Magia> listaMagie;
  protected List<Attacco> listaAttacchi;
  protected List<Oggetto> inventario;

  public EntitaGiocante(int id, String nome, int lV, int esperienza, boolean isAllley, double vita, int atkBase,
      int defBase,
      int velocita) {
    this.id = id;
    this.nome = nome;
    this.lV = lV;
    this.esperienza = esperienza;
    this.isAlley = isAllley;
    this.vita = vita;
    this.atkBase = atkBase;
    this.defBase = defBase;
    this.velocita = velocita;
    this.listaMagie = new ArrayList<Magia>();
    this.listaAttacchi = new ArrayList<Attacco>();
    this.inventario = new ArrayList<Oggetto>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getVita() {
    return vita;
  }

  public void setVita(double vita) {
    this.vita = vita;
  }

  public int getlV() {
    return lV;
  }

  public void setlV(int lV) {
    this.lV = lV;
  }

  public int getEsperienza() {
    return esperienza;
  }

  public void setEsperienza(int esperienza) {
    this.esperienza = esperienza;
  }

  public boolean isAlley() {
    return isAlley;
  }

  public void setAlley(boolean isAllley) {
    this.isAlley = isAllley;
  }

  public int getAtkBase() {
    return atkBase;
  }

  public void setAtkBase(int atkBase) {
    this.atkBase = atkBase;
  }

  public int getDefBase() {
    return defBase;
  }

  public void setDefBase(int defBase) {
    this.defBase = defBase;
  }

  public int getVelocita() {
    return velocita;
  }

  public void setVelocita(int velocita) {
    this.velocita = velocita;
  }

  public List<Magia> getListaMagie() {
    return listaMagie;
  }

  public void setListaMagie(List<Magia> listaMagie) {
    this.listaMagie = listaMagie;
  }

  public List<Attacco> getListaAttacchi() {
    return listaAttacchi;
  }

  public void setListaAttacchi(List<Attacco> listaAttacchi) {
    this.listaAttacchi = listaAttacchi;
  }

  public List<Oggetto> getInventario() {
    return inventario;
  }

  public void setInventario(List<Oggetto> inventario) {
    this.inventario = inventario;
  }

  public abstract void attaccaSingolo();

  public abstract void attaccaMulti();

  public void aggiungiMagia(Magia magia) {
    listaMagie.add(magia);
  }

  public void aggiungiAttacco(Attacco attacco) {
    listaAttacchi.add(attacco);
  }

  public void aggiungiOggetto(Oggetto oggetto) {
    inventario.add(oggetto);
  }

}
