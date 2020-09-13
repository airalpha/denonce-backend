package com.air.etab.service;

import com.air.etab.entities.Region;
import com.air.etab.entities.Ville;
import com.air.etab.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImp implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getRegion(){
        return regionRepository.findAll();
    }

    public List<Ville> getVilles(Long id){
        Optional<Region> r = regionRepository.findById(id);
        return r.get().getVilles();
    }

    public Optional<Region> getRegion(Long id){
        return regionRepository.findById(id);
    }

    @RequestMapping(value="/region", method=RequestMethod.POST)
    public Region save(Region e){
        return regionRepository.save(e);
    }

    @RequestMapping(value="/region/{id}", method=RequestMethod.DELETE)
    public Boolean delete(Long id){
        regionRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value="/region/{id}", method=RequestMethod.PUT)
    public Region update(Long id, Region e ){
        e.setId(id);
        return regionRepository.save(e);
    }

    @RequestMapping(value="/chercher_region", method=RequestMethod.GET)
    public Region findAll(Optional<String> nom){
        return regionRepository.findByNomFr(nom.orElse(""));
    }
}
