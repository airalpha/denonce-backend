package com.air.etab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class TypeDenonciation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "typeDenonciation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Denonciation> denonciations = new ArrayList<Denonciation>();

    public TypeDenonciation() {
        super();
    }

    public TypeDenonciation(String nom) {
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

    @JsonIgnore
    public List<Denonciation> getDenonciations() {
        return denonciations;
    }

    @JsonIgnore
    public void setDenonciations(List<Denonciation> denonciations) {
        this.denonciations = denonciations;
    }
}
