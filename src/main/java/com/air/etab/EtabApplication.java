package com.air.etab;

import com.air.etab.entities.*;
import com.air.etab.repository.*;
import com.air.etab.service.AdministrateurService;
import com.air.etab.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class EtabApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private QuartierRepository quartierRepository;
    @Autowired
    private EtablissementRepository etablissementRepository;
    @Autowired
    private TypeDenonciationRepository typeDenonciationRepository;
    @Autowired
    private NiveauScolaireRepository niveauScolaireRepository;
    @Autowired
    private DenonciationRepository denonciationRepository;
    @Autowired
    private AdministrateurService administrateurService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CouvertureRepository couvertureRepository;


    public static void main(String[] args) {
        SpringApplication.run(EtabApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCrypt(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        /*Role r = new Role();
        r.setCouverture(regionRepository.getOne((long) 4));
        roleService.save(r);
        administrateurService.findAdministrateurByNom("admin3").setRole(r);
        administrateurService.addRoleToAdmin("admin3", couvertureRepository.getOne((long) 4).getId());

        couvertureRepository.deleteById((long) 30);
        couvertureRepository.deleteById((long) 31);
        couvertureRepository.deleteById((long) 32);
        administrateurService.save(new Administrateur("admin1", "admin1@gmail.com", "697456833", "1234"));
        administrateurService.save(new Administrateur("admin2", "admin2@gmail.com", "65356798", "1234"));

        Role role = roleService.findByCouverture(c);



        Role role1 = new Role();
        role1.setCouverture(regionRepository.getOne((long) 1));
        roleService.save(role1);
        administrateurService.addRoleToAdmin("admin1", role1.getCouverture());
        administrateurService.addRoleToAdmin("admin1", role.getCouverture());
        administrateurService.addRoleToAdmin("admin3", role.getCouverture());

        NiveauScolaire niveauScolaire = niveauScolaireRepository.save(new NiveauScolaire("6éme"));
        TypeDenonciation typeDenonciation = typeDenonciationRepository.save(new TypeDenonciation("Alerte"));
        Denonciation denonciation = new Denonciation("M",18, "Il ya des eles qui viennent avec le couteau");
        etablissementRepository.findAll().forEach(e->{
            denonciation.setEtablissement(e);
        });
        denonciation.setNiveauScolaire(niveauScolaire);
        denonciation.setTypeDenonciation(typeDenonciation);
        denonciationRepository.save(denonciation);

        Ville ville = new Ville("Douala");
        Optional<Region> region = regionRepository.findById((long) 1);
        List<Ville> etablissements = region.get().getVilles();
        System.out.println(etablissements.toString());
        ville.setRegion(region);
        villeRepository.save(ville);



        Region region = regionRepository.save(new Region("Ouest", "West", "Bafoussam"));
        Ville ville = new Ville("Dschang");
        ville.setRegion(region);
        villeRepository.save(ville);
        
        Ville ville = villeRepository.findByNom("Dschang");
        System.out.println(ville.getNom());
        Quartier quartier = new Quartier("Mellah");
        Quartier quartier1 = new Quartier("Bonamoussadi");
        quartier.setVille(ville);
        quartier1.setVille(ville);
        quartierRepository.save(quartier);
        quartierRepository.save(quartier1);

        Etablissement etablissement = new Etablissement("Lycee 1", "8656446", "email");
        etablissement.setquartier(quartier);
        etablissementRepository.save(etablissement);

        etablissementRepository.findAll().forEach(e->{
            System.out.println("Etablissement"+e.getNom());
        });
        quartierRepository.findAll().forEach(q->{
            System.out.println("Quartier"+q.getNom());
        });*/
    }
}
