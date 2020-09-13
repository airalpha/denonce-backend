package com.air.etab.repository;

import com.air.etab.entities.Denonciation;
import com.air.etab.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DenonciationRepository extends JpaRepository<Denonciation, Long> {
    @Autowired
    @Query("SELECT d FROM Denonciation d WHERE message LIKE %?1%")
    Page<Denonciation> findByMessage(String nom, Pageable pageable);

}
