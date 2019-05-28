package com.air.etab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("region")
public class Region extends Couverture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFr;
    private String nomEn;
    private String chefLieu;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Ville> villes = new ArrayList<Ville>();

    public Region(){
        super();
    }
    public Region(String nomFr, String nomEn, String chefLieu) {
        super();
        this.nomFr = nomFr;
        this.nomEn = nomEn;
        this.chefLieu = chefLieu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnomFr() {
        return nomFr;
    }

    public void setnomFr(String nomFr) {
        this.nomFr = nomFr;
    }

    public String getNomEn() {
        return nomEn;
    }

    public void setNomEn(String nomEn) {
        this.nomEn = nomEn;
    }

    public String getChefLieu() {
        return chefLieu;
    }

    public void setChefLieu(String chefLieu) {
        this.chefLieu = chefLieu;
    }

    @JsonIgnore
    public List<Ville> getVilles() {
        return villes;
    }

    @JsonIgnore
    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }
}
