package com.air.etab.service;

import com.air.etab.entities.Denonciation;
import com.air.etab.entities.Etablissement;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface DenonciationService {
    public List<Denonciation> getDenonciation();
    public Optional<Denonciation> getDenonciation(Long id);
    public Denonciation save(Denonciation d);
    public Denonciation update(Long id, Denonciation d);
    public Page<Denonciation> findAll(Optional<String> nom, Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);
}
