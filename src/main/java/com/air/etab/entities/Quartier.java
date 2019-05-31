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
@DiscriminatorValue("quartier")
@Data @AllArgsConstructor @NoArgsConstructor
public class Quartier extends Couverture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    @JoinColumn()
    private Ville ville;

    @OneToMany(mappedBy = "quartier", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Etablissement> etablissements = new ArrayList<Etablissement>();

}
