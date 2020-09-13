package com.air.etab.repository;

import com.air.etab.entities.Administrateur;
import com.air.etab.entities.Couverture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

    @Autowired
    public Administrateur findAdministrateurByNom(String nom);

    @Autowired
    @Query("SELECT a FROM Administrateur a WHERE nom LIKE %?1%")
    public Page<Administrateur> findByNom(String nom, Pageable pageable);

}
