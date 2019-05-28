package com.air.etab.web;

import com.air.etab.entities.NiveauScolaire;
import com.air.etab.service.NiveauScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NiveauScolaireController {

    @Autowired
    private NiveauScolaireService niveauScolaireService;

    @RequestMapping(value="/niveau-scolaire", method= RequestMethod.GET)
    public List<NiveauScolaire> getNiveauScolaire(){
        return niveauScolaireService.getNiveauScolaire();
    }

    @RequestMapping(value="/niveau-scolaire/{id}", method=RequestMethod.GET)
    public Optional<NiveauScolaire> getNiveauScolaire(@PathVariable Long id){
        return niveauScolaireService.getNiveauScolaire(id);
    }
}
