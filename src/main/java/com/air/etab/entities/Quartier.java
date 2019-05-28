package com.air.etab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("quartier")
public class Quartier extends Couverture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    @JoinColumn()
    private Ville ville;

    @OneToMany(mappedBy = "quartier", cascade = CascadeType.ALL)
    private List<Etablissement> etablissements = new ArrayList<Etablissement>();

    public Quartier(){
        super();
    }

    public Quartier(String nom) {
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

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @JsonIgnore
    public List<Etablissement> getEtablissements() {
        return etablissements;
    }

    @JsonIgnore
    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }
}
