package com.example.eloadasbeadando;


public class Suti {
    public int id;
    public String nev;
    public String tipus;
    public int dijazott;


    public Suti(String nev, String tipus, int dijazott) {
        this.nev = nev;
        this.tipus = tipus;
        this.dijazott = dijazott;
    }

    public Suti() {
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



}
