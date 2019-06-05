package com.air.etab.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Denonciation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Etablissement etablissement;
    @ManyToOne
    @JoinColumn
    private NiveauScolaire niveauScolaire;
    private String sexe;
    private int age;
    @ManyToOne
    @JoinColumn
    private TypeDenonciation typeDenonciation;
    private String personneConcerne;
    private String message;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Boolean statut;

    public Denonciation() {
        super();
    }

    public Denonciation(String sexe, int age, String message) {
        super();
        this.sexe = sexe;
        this.age = age;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public NiveauScolaire getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(NiveauScolaire niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeDenonciation getTypeDenonciation() {
        return typeDenonciation;
    }

    public void setTypeDenonciation(TypeDenonciation typeDenonciation) {
        this.typeDenonciation = typeDenonciation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPersonneConcerne() {
        return personneConcerne;
    }

    public void setPersonneConcerne(String personneConcerne) {
        this.personneConcerne = personneConcerne;
    }
}
