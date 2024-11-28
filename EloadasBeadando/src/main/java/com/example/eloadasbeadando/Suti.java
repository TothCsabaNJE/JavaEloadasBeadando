package com.example.eloadasbeadando;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "suti")
public class Suti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nev")
    private String nev;
    @Column(name="tipus")
    private String tipus;
    @Column(name="dijazott")
    private boolean dijazott;
    @OneToMany(mappedBy = "suti")
    private List<Ar> ar;
    @OneToMany(mappedBy = "suti")
    private List<Tartalom> tartalom;

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

    public boolean isDijazott() {
        return dijazott;
    }

    public void setDijazott(boolean dijazott) {
        this.dijazott = dijazott;
    }

    public List<Ar> getAr() {
        return ar;
    }

    public void setAr(List<Ar> ar) {
        this.ar = ar;
    }

    public List<Tartalom> getTartalom() {
        return tartalom;
    }

    public void setTartalom(List<Tartalom> tartalom) {
        this.tartalom = tartalom;
    }

    public Suti(String nev, String tipus, boolean dijazott, List<Ar> ar, List<Tartalom> tartalom) {
        this.nev = nev;
        this.tipus = tipus;
        this.dijazott = dijazott;
        this.ar = ar;
        this.tartalom = tartalom;
    }


}
