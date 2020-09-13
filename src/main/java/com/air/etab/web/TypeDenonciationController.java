package com.air.etab.web;

import com.air.etab.entities.TypeDenonciation;
import com.air.etab.service.TypeDenonciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TypeDenonciationController {

    @Autowired
    private TypeDenonciationService typeDenonciationService;

    @RequestMapping(value="/type-denonciation", method= RequestMethod.GET)
    public List<TypeDenonciation> getTypeDenonciation(){
        return typeDenonciationService.getTypeDenonciation();
    }

    @RequestMapping(value="/type-denonciation/{id}", method=RequestMethod.GET)
    public Optional<TypeDenonciation> getTypeDenonciation(@PathVariable Long id){
        return typeDenonciationService.getTypeDenonciation(id);
    }
}
