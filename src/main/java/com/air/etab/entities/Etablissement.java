package com.air.etab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@DiscriminatorValue("etablissement")
public class Etablissement extends Couverture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    @JoinColumn()
    private Quartier quartier;
    private String tel;
    private String email;

    @OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Denonciation> denonciations = new ArrayList<Denonciation>();

    public Etablissement() {
        super();
    }

    public Etablissement(String nom, String tel, String email) {
        super();
        this.nom = nom;
        this.email = email;
        this.tel = tel;
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

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }
    
    public String getTel(){
        return tel;
    }
    
    public void setTel(String tel){
        this.tel = tel;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
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
