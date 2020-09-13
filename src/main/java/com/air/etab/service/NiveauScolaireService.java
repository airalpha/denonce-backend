package com.air.etab.service;

import com.air.etab.entities.NiveauScolaire;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface NiveauScolaireService {
    public List<NiveauScolaire> getNiveauScolaire();
    public Optional<NiveauScolaire> getNiveauScolaire(Long id);
}
