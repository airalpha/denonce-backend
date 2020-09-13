package com.air.etab.web;

import com.air.etab.entities.Denonciation;
import com.air.etab.service.DenonciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DenonciationController {

    @Autowired
    private DenonciationService denonciationService;

    @RequestMapping(value="/denonciation", method= RequestMethod.GET)
    public List<Denonciation> getDenonciation(){
        return denonciationService.getDenonciation();
    }

    @RequestMapping(value="/denonciation/{id}", method=RequestMethod.GET)
    public Optional<Denonciation> getDenonciation(@PathVariable Long id){
        return denonciationService.getDenonciation(id);
    }

    @RequestMapping(value="/denonciation", method=RequestMethod.POST)
    public Denonciation save(@RequestBody Denonciation d){
        return denonciationService.save(d);
    }

    @RequestMapping(value="/denonciation/{id}", method=RequestMethod.PUT)
    public Denonciation update(@PathVariable Long id, @RequestBody Denonciation d){
        return denonciationService.update(id, d);
    }

    @RequestMapping(value="denonciation/chercher", method=RequestMethod.GET)
    public Page<Denonciation> findAll(@RequestParam Optional<String> nom,
                                      @RequestParam Optional<Integer> page,
                                      @RequestParam Optional<Integer> size,
                                      @RequestParam Optional<String> sortBy){
        return denonciationService.findAll(nom, page, size, sortBy);
    }
}
