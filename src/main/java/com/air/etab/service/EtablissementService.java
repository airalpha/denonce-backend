package com.air.etab.service;

import com.air.etab.entities.Denonciation;
import com.air.etab.entities.Etablissement;
import com.air.etab.entities.Ville;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface EtablissementService {
    public List<Etablissement> getEtablissement();
    public Optional<Etablissement> getEtablissement(Long id);
    public Etablissement save(Etablissement e);
    public Boolean delete(Long id);
    public Etablissement update(Long id, Etablissement e);
    public Page<Etablissement> findAll(Optional<String> nom, Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);
    public List<Denonciation> getDenonciations(Long id);
}
