package com.air.etab.service;

import com.air.etab.entities.TypeDenonciation;
import com.air.etab.repository.TypeDenonciationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDenonciationServiceImpl implements TypeDenonciationService {
    @Autowired
    private TypeDenonciationRepository typeDenonciationRepository;

    public List<TypeDenonciation> getTypeDenonciation(){
        return typeDenonciationRepository.findAll();
    }

    public Optional<TypeDenonciation> getTypeDenonciation(Long id){
        return typeDenonciationRepository.findById(id);
    }

    @RequestMapping(value="/typeDenonciation", method=RequestMethod.POST)
    public TypeDenonciation save(TypeDenonciation e){
        return typeDenonciationRepository.save(e);
    }

    @RequestMapping(value="/typeDenonciation/{id}", method=RequestMethod.DELETE)
    public Boolean delete(Long id){
        typeDenonciationRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value="/typeDenonciation/{id}", method=RequestMethod.PUT)
    public TypeDenonciation update(Long id, @RequestBody TypeDenonciation e ){
        e.setId(id);
        return typeDenonciationRepository.save(e);
    }
}
