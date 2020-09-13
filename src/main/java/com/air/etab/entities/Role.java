package com.air.etab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn()
    private Couverture couverture;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Administrateur> administrateurs;

    public Role() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Couverture getCouverture() {
        return couverture;
    }

    public void setCouverture(Couverture couverture) {
        this.couverture = couverture;
    }

    @JsonIgnore
    public List<Administrateur> getAdministrateurs() {
        return administrateurs;
    }

    @JsonIgnore
    public void setAdministrateurs(List<Administrateur> administrateurs) {
        this.administrateurs = administrateurs;
    }
}