package com.air.etab.repository;

import com.air.etab.entities.Region;
import com.air.etab.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {
    @Autowired
    @Query("SELECT v FROM Ville v WHERE nom LIKE %?1%")
    Page<Ville> findByNom(String nom, Pageable pageable);


}