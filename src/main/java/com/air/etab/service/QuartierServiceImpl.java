package com.air.etab.service;

import com.air.etab.entities.Quartier;
import com.air.etab.entities.Etablissement;
import com.air.etab.entities.Ville;
import com.air.etab.repository.QuartierRepository;
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
public class QuartierServiceImpl implements QuartierService {

    @Autowired
    private QuartierRepository quartierRepository;

    public List<Quartier> getQuartier(){
        return quartierRepository.findAll();
    }

    public Optional<Quartier> getQuartier(Long id){
        return quartierRepository.findById(id);
    }

    public Quartier save(Quartier e){
        return quartierRepository.save(e);
    }

    public Boolean delete(Long id){
        Optional<Quartier> v = quartierRepository.findById(id);
        if (!v.get().getEtablissements().isEmpty()){
            throw new RuntimeException("Ce quartier possede des etablissements !");
        }else{
            quartierRepository.deleteById(id);
        }
        return true;
    }

    public Quartier update(Long id, Quartier e ){
        e.setId(id);
        return quartierRepository.save(e);
    }

    public List<Etablissement> getEtablissements(Long id){
        Optional<Quartier> q = quartierRepository.findById(id);
        return q.get().getEtablissements();
    }

    public Page<Quartier> findAll(Optional<String> nom,
                                  Optional<Integer> page,
                                  Optional<Integer> size,
                                  Optional<String> sortBy) {
        return quartierRepository.findByNom(nom.orElse(""),
                new PageRequest(page.orElse(0),
                        size.orElse(5),
                        Sort.Direction.ASC,
                        sortBy.orElse("id")));
    }
}
