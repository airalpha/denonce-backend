package com.air.etab.service;

import com.air.etab.entities.Etablissement;
import com.air.etab.entities.Quartier;
import com.air.etab.entities.Ville;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface QuartierService {
    public List<Quartier> getQuartier();
    public Optional<Quartier> getQuartier(Long id);
    public Quartier save(Quartier e);
    public Boolean delete(Long id);
    public Quartier update(Long id, Quartier e );
    public List<Etablissement> getEtablissements(Long id);
    public Page<Quartier> findAll(Optional<String> nom, Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);
}
