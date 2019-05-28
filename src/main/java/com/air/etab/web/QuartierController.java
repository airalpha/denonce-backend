package com.air.etab.web;

import com.air.etab.entities.Etablissement;
import com.air.etab.entities.Quartier;
import com.air.etab.entities.Ville;
import com.air.etab.service.QuartierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuartierController {

    @Autowired
    private QuartierService quartierService;

    @RequestMapping(value="/quartier", method= RequestMethod.GET)
    public List<Quartier> getQuartier(){
        return quartierService.getQuartier();
    }

    @RequestMapping(value="/quartier/{id}", method=RequestMethod.GET)
    public Optional<Quartier> getQuartier(@PathVariable Long id){
        return quartierService.getQuartier(id);
    }

    @RequestMapping(value="/quartier", method=RequestMethod.POST)
    public Quartier save(@RequestBody Quartier e){
        return quartierService.save(e);
    }

    @RequestMapping(value="/quartier/{id}", method=RequestMethod.DELETE)
    public Boolean delete(@PathVariable Long id){
        return quartierService.delete(id);
    }

    @RequestMapping(value="/quartier/{id}", method=RequestMethod.PUT)
    public Quartier update(@PathVariable Long id, @RequestBody Quartier e ){
        return quartierService.update(id, e);
    }

    @RequestMapping(value = "/etab-quartier/{id}", method = RequestMethod.GET)
    public List<Etablissement> getEtablissements(@PathVariable Long id){
        return quartierService.getEtablissements(id);
    }

    @RequestMapping(value="quartier/chercher", method=RequestMethod.GET)
    public Page<Quartier> findAll(@RequestParam Optional<String> nom,
                               @RequestParam Optional<Integer> page,
                               @RequestParam Optional<Integer> size,
                               @RequestParam Optional<String> sortBy){
        return quartierService.findAll(nom, page, size, sortBy);
    }
}
