package com.air.etab.service;

import com.air.etab.entities.Ville;
import com.air.etab.entities.Quartier;
import com.air.etab.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class VilleServiceImp implements VilleService{

    @Autowired
    private VilleRepository villeRepository;

    public List<Ville> getVille(){
        return villeRepository.findAll();
    }

    public Optional<Ville> getVille(Long id){
        return villeRepository.findById(id);
    }

    public Ville save(Ville v){
        return villeRepository.save(v);
    }

    public Boolean delete(Long id){
        Optional<Ville> v = villeRepository.findById(id);
        if (!v.get().getQuartiers().isEmpty()){
            throw new RuntimeException("Cette ville a des quartiers !");
        }else{
            villeRepository.deleteById(id);
        }
        return null;
    }

    public Ville update(Long id, Ville e ){
        e.setId(id);
        return villeRepository.save(e);
    }

    public List<Quartier> getQuartiers(@PathVariable Long id){
        Optional<Ville> v = villeRepository.findById(id);
        return v.get().getQuartiers();
    }

    public Page<Ville> findAll(@RequestParam Optional<String> nom,
                               @RequestParam Optional<Integer> page,
                               @RequestParam Optional<Integer> size,
                               @RequestParam Optional<String> sortBy){
        return villeRepository.findByNom(nom.orElse(""),
                new PageRequest(page.orElse(0),
                        size.orElse(5),
                        Sort.Direction.ASC,
                        sortBy.orElse("id")));
    }
}
