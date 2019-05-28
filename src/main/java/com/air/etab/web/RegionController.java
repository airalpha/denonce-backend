package com.air.etab.web;

import com.air.etab.entities.Region;
import com.air.etab.entities.Ville;
import com.air.etab.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @RequestMapping(value="/region", method= RequestMethod.GET)
    public List<Region> getRegion(){
        return regionService.getRegion();
    }

    @RequestMapping(value="/ville-region/{id}", method= RequestMethod.GET)
    public List<Ville> getVilles(@PathVariable Long id){
        Optional<Region> r = regionService.getRegion(id);
        return r.get().getVilles();
    }

    @RequestMapping(value="/region/{id}", method=RequestMethod.GET)
    public Optional<Region> getRegion(@PathVariable Long id){
        return regionService.getRegion(id);
    }

}
