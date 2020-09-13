package com.air.etab.web;

import com.air.etab.entities.Quartier;
import com.air.etab.entities.Region;
import com.air.etab.entities.Ville;
import com.air.etab.repository.VilleRepository;
import com.air.etab.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VilleController {
    @Autowired
    private VilleService villeService;
    @Autowired
    private VilleRepository villeRepository;

    @RequestMapping(value="/ville", method= RequestMethod.GET)
    public List<Ville> getVille(){
        return villeService.getVille();
    }

    @RequestMapping(value="/ville/{id}", method=RequestMethod.GET)
    public Optional<Ville> getVille(@PathVariable Long id){
        return villeService.getVille(id);
    }

    @RequestMapping(value = "/ville/{id}", method = RequestMethod.PUT)
    public Ville update(@PathVariable Long id, @RequestBody Ville e ){
        e.setId(id);
        return villeService.update(id, e);
    }

    @RequestMapping(value="/ville/{id}", method=RequestMethod.DELETE)
    public Boolean delete(@PathVariable Long id){
        return villeService.delete(id);
    }

    @RequestMapping(value = "/ville", method = RequestMethod.POST)
    public Ville save(@RequestBody Ville v){
        return villeService.save(v);
    }

    @RequestMapping(value = "/quartier-ville/{id}", method = RequestMethod.GET)
    public List<Quartier> getQuartiers(@PathVariable Long id){
        Optional<Ville> v = villeService.getVille(id);
        return v.get().getQuartiers();
    }

    @RequestMapping(value="ville/chercher", method=RequestMethod.GET)
    public Page<Ville> findAll(@RequestParam Optional<String> nom,
                               @RequestParam Optional<Integer> page,
                               @RequestParam Optional<Integer> size,
                               @RequestParam Optional<String> sortBy){
        return villeService.findAll(nom, page, size, sortBy);
    }

    /*@RequestMapping(value = "/villeRegion", method = RequestMethod.GET)
    public List<Ville> getVilleRegion(@RequestBody Region r){
        return villeService.getVille();
    }*/


}
