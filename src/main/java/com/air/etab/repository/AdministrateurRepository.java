package com.air.etab.repository;

import com.air.etab.entities.Administrateur;
import com.air.etab.entities.Couverture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

    @Autowired
    public Administrateur findAdministrateurByNom(String nom);

}
