package com.example.eloadasbeadando;

import jakarta.persistence.*;

@Entity
@Table(name = "tartalom")
public class Tartalom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="sutiid")
    private int sutiid;
    @Column(name="mentes")
    private String mentes;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sutiid")
    private Suti suti;

    public Tartalom(int sutiid, String mentes, Suti suti) {
        this.sutiid = sutiid;
        this.mentes = mentes;
        this.suti = suti;
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

    public Suti getSuti() {
        return suti;
    }

    public void setSuti(Suti suti) {
        this.suti = suti;
    }
}
