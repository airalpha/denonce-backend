package com.air.etab.web;

import com.air.etab.entities.Denonciation;
import com.air.etab.entities.Etablissement;
import com.air.etab.entities.Region;
import com.air.etab.entities.Ville;
import com.air.etab.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.soap.Addressing;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;

    @RequestMapping(value="/etablissement", method= RequestMethod.GET)
    public List<Etablissement> getEtablissement(){
        return etablissementService.getEtablissement();
    }

    @RequestMapping(value="/etablissement/{id}", method=RequestMethod.GET)
    public Optional<Etablissement> getEtablissement(@PathVariable Long id){
        return etablissementService.getEtablissement(id);
    }

    @RequestMapping(value="/etablissement", method=RequestMethod.POST)
    public Etablissement save(@RequestBody Etablissement e){
        return etablissementService.save(e);
    }

    @RequestMapping(value="/etablissement/{id}", method=RequestMethod.DELETE)
    public Boolean delete(@PathVariable Long id){
        return etablissementService.delete(id);
    }

    @RequestMapping(value="/etablissement/{id}", method=RequestMethod.PUT)
    public Etablissement update(@PathVariable Long id, @RequestBody Etablissement e ){
        return etablissementService.update(id, e);
    }

    @RequestMapping(value="/denonce-etab/{id}", method= RequestMethod.GET)
    public List<Denonciation> getDenonciations(@PathVariable Long id){
        return etablissementService.getDenonciations(id);
    }

    @RequestMapping(value="etablissement/chercher", method=RequestMethod.GET)
    public Page<Etablissement> findAll(@RequestParam Optional<String> nom,
                               @RequestParam Optional<Integer> page,
                               @RequestParam Optional<Integer> size,
                               @RequestParam Optional<String> sortBy){
        return etablissementService.findAll(nom, page, size, sortBy);
    }
}
