package com.air.etab.service;

import com.air.etab.entities.Quartier;
import com.air.etab.entities.Ville;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface VilleService {
    public List<Ville> getVille();
    public Optional<Ville> getVille(Long id);
    public Ville update(Long id, Ville e);
    public Boolean delete(Long id);
    public Ville save(Ville v);
    public List<Quartier> getQuartiers(Long id);
    public Page<Ville> findAll(Optional<String> nom, Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);
}
