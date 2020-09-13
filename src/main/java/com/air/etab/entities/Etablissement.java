package com.air.etab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@DiscriminatorValue("etablissement")
@Data @AllArgsConstructor @NoArgsConstructor
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
    @JsonIgnore
    private List<Denonciation> denonciations = new ArrayList<Denonciation>();

}
