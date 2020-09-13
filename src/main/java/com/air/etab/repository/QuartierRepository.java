package com.air.etab.repository;

import com.air.etab.entities.Quartier;
import com.air.etab.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartierRepository extends JpaRepository<Quartier, Long> {
    @Autowired
    @Query("SELECT q FROM Quartier q WHERE nom LIKE %?1%")
    Page<Quartier> findByNom(String nom, Pageable pageable);
}
