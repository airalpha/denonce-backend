package com.air.etab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("ville")
@Data @AllArgsConstructor @NoArgsConstructor
public class Ville extends Couverture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    @JoinColumn()
    private Region region;

    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quartier> quartiers = new ArrayList<Quartier>();

    public Ville(String nom) {
        super();
        this.nom = nom;
    }

}
