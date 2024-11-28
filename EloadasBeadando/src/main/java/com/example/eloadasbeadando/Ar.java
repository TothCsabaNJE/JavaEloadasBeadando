package com.example.eloadasbeadando;

import jakarta.persistence.*;

@Entity
@Table(name = "ar")
public class Ar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;
    @Column(name="sutiid")
    private int sutiid;
    @Column(name="ertek")
    private int ertek;
    @Column(name="egyseg")
    private String egyseg;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sutiid")
    private Suti suti;

    public Ar(int sutiid, int ertek, String egyseg, Suti suti) {
        this.sutiid = sutiid;
        this.ertek = ertek;
        this.egyseg = egyseg;
        this.suti = suti;
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

    public Suti getSuti() {
        return suti;
    }

    public void setSuti(Suti suti) {
        this.suti = suti;
    }
}
