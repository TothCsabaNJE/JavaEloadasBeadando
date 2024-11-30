package com.example.eloadasbeadando;

public class Tartalom {

    public int id;
    public int sutiid;
    public String mentes;

    public Tartalom(int sutiid, String mentes) {
        this.sutiid = sutiid;
        this.mentes = mentes;
    }

    public Tartalom() {

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

    public String getMentes() {
        return mentes;
    }

    public void setMentes(String mentes) {
        this.mentes = mentes;
    }

}
