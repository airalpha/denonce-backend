package com.air.etab.repository;

import com.air.etab.entities.Etablissement;
import com.air.etab.entities.Region;
import com.air.etab.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    @Autowired
    Region findByNomFr(String mc);

    //List<Ville> getVilles();

    //@Autowired
    //public List<Ville> getVilles(Region r);
}
