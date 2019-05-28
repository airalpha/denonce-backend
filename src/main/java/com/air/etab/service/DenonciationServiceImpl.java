package com.air.etab.service;

import com.air.etab.entities.Denonciation;
import com.air.etab.entities.Etablissement;
import com.air.etab.repository.DenonciationRepository;
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
public class DenonciationServiceImpl implements  DenonciationService{
    @Autowired
    private DenonciationRepository denonciationRepository;

    public List<Denonciation> getDenonciation(){
        return denonciationRepository.findAll();
    }

    public Optional<Denonciation> getDenonciation(Long id){
        return denonciationRepository.findById(id);
    }

    public Denonciation save(Denonciation e){
        return denonciationRepository.save(e);
    }

    public Denonciation update(Long id, Denonciation d){
        d.setId(id);
        return denonciationRepository.save(d);
    }

    public Page<Denonciation> findAll(Optional<String> nom,
                                      Optional<Integer> page,
                                      Optional<Integer> size,
                                      Optional<String> sortBy) {
        return denonciationRepository.findByMessage(nom.orElse(""),
                new PageRequest(page.orElse(0),
                        size.orElse(5),
                        Sort.Direction.ASC,
                        sortBy.orElse("id")));
    }
}
