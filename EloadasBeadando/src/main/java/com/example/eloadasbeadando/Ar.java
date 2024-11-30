package com.example.eloadasbeadando;

public class Ar {
    public int id;
    public int sutiid;
    public int ertek;
    public String egyseg;

    public Ar(int sutiid, int ertek, String egyseg) {
        this.sutiid = sutiid;
        this.ertek = ertek;
        this.egyseg = egyseg;
    }

    public Ar() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSutiid() {
        return sutiid;
    }

    public void setSutiid(int sutiid) {
        this.sutiid = sutiid;
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
}
