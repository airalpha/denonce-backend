package com.air.etab.service;

import com.air.etab.entities.Denonciation;
import com.air.etab.entities.Etablissement;
import com.air.etab.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EtablissementServiceImpl implements EtablissementService {

    @Autowired
    private EtablissementRepository etablissementRepository;

    public List<Etablissement> getEtablissement(){
        return etablissementRepository.findAll();
    }

    public Optional<Etablissement> getEtablissement(Long id){
        return etablissementRepository.findById(id);
    }

    public Etablissement save(Etablissement e){
        return etablissementRepository.save(e);
    }

    public Boolean delete(Long id){
        Optional<Etablissement> v = etablissementRepository.findById(id);
        if (!v.get().getDenonciations().isEmpty()){
            throw new RuntimeException("Cet etablissement a des denonciations !");
        }else{
            etablissementRepository.deleteById(id);
        }
        return true;
    }

    public Etablissement update(Long id, Etablissement e ){
        e.setId(id);
        return etablissementRepository.save(e);
    }

    public List<Denonciation> getDenonciations(Long id){
        Optional<Etablissement> e = etablissementRepository.findById(id);
        return e.get().getDenonciations();
    }

    public Page<Etablissement> findAll(Optional<String> nom,
                                       Optional<Integer> page,
                                       Optional<Integer> size,
                                       Optional<String> sortBy) {
        return etablissementRepository.findByNom(nom.orElse(""),
                new PageRequest(page.orElse(0),
                        size.orElse(5),
                        Sort.Direction.ASC,
                        sortBy.orElse("id")));
    }

}
