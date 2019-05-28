package com.air.etab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("ville")
public class Ville extends Couverture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    @JoinColumn()
    private Region region;

    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    private List<Quartier> quartiers = new ArrayList<Quartier>();

    public Ville(){
        super();
    }
    public Ville(String nom) {
        super();
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @JsonIgnore
    public List<Quartier> getQuartiers() {
        return quartiers;
    }

    @JsonIgnore
    public void setQuartiers(List<Quartier> quartiers) {
        this.quartiers = quartiers;
    }
}
