package com.example.eloadasbeadando;

public class Compiled {
    public int id;
    public String nev;
    public String tipus;
    public int dijazott;
    public int ertek;
    public String egyseg;
    public String mentes;

    public Compiled(int id, String nev, String tipus, int dijazott, int ertek, String egyseg, String mentes) {
        this.id = id;
        this.nev = nev;
        this.tipus = tipus;
        this.dijazott = dijazott;
        this.ertek = ertek;
        this.egyseg = egyseg;
        this.mentes = mentes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getDijazott() {
        return dijazott;
    }

    public void setDijazott(int dijazott) {
        this.dijazott = dijazott;
    }

    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }

    public String getEgyseg() {
        return egyseg;
    }

    public void setEgyseg(String egyseg) {
        this.egyseg = egyseg;
    }

    public String getMentes() {
        return mentes;
    }

    public void setMentes(String mentes) {
        this.mentes = mentes;
    }
}
