package com.air.etab.repository;

import com.air.etab.entities.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
    @Autowired
    @Query("SELECT e FROM Etablissement e WHERE nom LIKE %?1%")
    Page<Etablissement> findByNom(String nom, Pageable pageable);

}
