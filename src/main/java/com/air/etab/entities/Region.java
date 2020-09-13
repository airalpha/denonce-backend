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
@DiscriminatorValue("region")
@Data @AllArgsConstructor @NoArgsConstructor
public class Region extends Couverture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFr;
    private String nomEn;
    private String chefLieu;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ville> villes = new ArrayList<Ville>();



}
