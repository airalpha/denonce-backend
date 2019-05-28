package com.air.etab.service;

import com.air.etab.entities.NiveauScolaire;
import com.air.etab.repository.NiveauScolaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauScolaireServiceImpl implements NiveauScolaireService {
    @Autowired
    private NiveauScolaireRepository niveauScolaireRepository;

    public List<NiveauScolaire> getNiveauScolaire(){
        return niveauScolaireRepository.findAll();
    }

    public Optional<NiveauScolaire> getNiveauScolaire(Long id){
        return niveauScolaireRepository.findById(id);
    }

    @RequestMapping(value="/niveauScolaire", method=RequestMethod.POST)
    public NiveauScolaire save(NiveauScolaire e){
        return niveauScolaireRepository.save(e);
    }

    @RequestMapping(value="/niveauScolaire/{id}", method=RequestMethod.DELETE)
    public Boolean delete(Long id){
        niveauScolaireRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value="/niveauScolaire/{id}", method=RequestMethod.PUT)
    public NiveauScolaire update(Long id, NiveauScolaire e ){
        e.setId(id);
        return niveauScolaireRepository.save(e);
    }
}
