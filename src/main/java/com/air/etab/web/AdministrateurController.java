package com.air.etab.web;

import com.air.etab.entities.Administrateur;
import com.air.etab.entities.Couverture;
import com.air.etab.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdministrateurController {
    @Autowired
    private AdministrateurService administrateurService;

    @PostMapping("/register")
    public Administrateur save(@RequestBody RegisterForm registerForm) {
        //Verification des deux mot de passe
        if (!registerForm.getPassword().equals(registerForm.getRepeatpassword()))
            throw new RuntimeException("Vous devez confirmez votre mot de passe");
        //Verification des doublures
        Administrateur a = administrateurService.findAdministrateurByNom(registerForm.getNom());
        if (a != null)
            throw new RuntimeException("Cet utilisateur existe deja");

        Administrateur administrateur = new Administrateur();
        administrateur.setNom(registerForm.getNom());
        administrateur.setEmail(registerForm.getEmail());
        administrateur.setTel(registerForm.getTel());
        administrateur.setPassword(registerForm.getPassword());
        return administrateurService.save(administrateur);
    }

    @DeleteMapping(value="/users/{id}")
    public Boolean delete(@PathVariable Long id){
        return administrateurService.delete(id);
    }

    @PutMapping(value="/users/{id}")
    public Administrateur update(@PathVariable Long id, @RequestBody Administrateur a ){
        return administrateurService.update(id, a);
    }

    @GetMapping(value="/couverture")
    public List<Couverture> getEtablissement(){
        return administrateurService.getCouvertures();
    }

    @PutMapping(value = "/update-role/{nom}")
    public void addRoleToAdmin(@PathVariable String nom, @RequestParam Long id) {
        administrateurService.addRoleToAdmin(nom, id);
    }

    @GetMapping("/users")
    public List<Administrateur> getAdministrateur() {
        return administrateurService.getAdministrateur();
    }

    @GetMapping("/couverture/{id}")
    public Optional<Couverture> getCouverture(@PathVariable Long id) {
        return administrateurService.getCouverture(id);
    }

    @GetMapping("/user/{id}")
    public Optional<Administrateur> getAdministrateur(@PathVariable Long id) {
        return administrateurService.getAdministrateur(id);
    }

    @RequestMapping(value="/users/chercher", method=RequestMethod.GET)
    public Page<Administrateur> findAll(@RequestParam Optional<String> nom,
                                        @RequestParam Optional<Integer> page,
                                        @RequestParam Optional<Integer> size,
                                        @RequestParam Optional<String> sortBy){
        return administrateurService.findAll(nom, page, size, sortBy);
    }
}
