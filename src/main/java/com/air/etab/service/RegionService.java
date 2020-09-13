package com.air.etab.service;

import com.air.etab.entities.Region;
import com.air.etab.entities.Ville;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface RegionService {
    public List<Region> getRegion();
    public List<Ville> getVilles(Long id);
    public Optional<Region> getRegion(Long id);
    //public List<Ville> getVilles();
}
