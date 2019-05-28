package com.air.etab.service;

import com.air.etab.entities.Administrateur;
import com.air.etab.entities.Couverture;
import com.air.etab.entities.Role;
import com.air.etab.repository.AdministrateurRepository;
import com.air.etab.repository.CouvertureRepository;
import com.air.etab.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdministrateurServiceImpl implements AdministrateurService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AdministrateurRepository administrateurRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CouvertureRepository couvertureRepository;

    @Override
    public Administrateur save(Administrateur a) {
        String hashPassword = bCryptPasswordEncoder.encode(a.getPassword());
        a.setPassword(hashPassword);
        return administrateurRepository.save(a);
    }

    @Override
    public Boolean delete(Long id) {
        administrateurRepository.deleteById(id);
        return true;
    }

    @Override
    public Administrateur update(Long id, Administrateur a) {
        a.setId(id);
        return administrateurRepository.save(a);
    }


    @Override
    public void addRoleToAdmin(String nom, Long id) {
        Couverture couverture = couvertureRepository.getOne(id);
        Role role = roleRepository.findByCouverture(couverture);
        if (role==null){
            role = new Role();
            role.setCouverture(couverture);
            roleRepository.save(role);
            Administrateur administrateur = administrateurRepository.findAdministrateurByNom(nom);
            administrateur.setRole(role);
        }else{
            System.out.println(role.getId());
            Administrateur administrateur = administrateurRepository.findAdministrateurByNom(nom);
            administrateur.setRole(role);
        }
    }

    @Override
    public Administrateur findAdministrateurByNom(String nom) {
        return administrateurRepository.findAdministrateurByNom(nom);
    }

    @Override
    public List<Administrateur> getAdministrateur() {
        return administrateurRepository.findAll();
    }

    @Override
    public List<Couverture> getCouvertures() {
        return couvertureRepository.findAll();
    }

    @Override
    public Optional<Couverture> getCouverture(Long id) {
        return couvertureRepository.findById(id);
    }
    @Override
    public Optional<Administrateur> getAdministrateur(Long id) {
        return administrateurRepository.findById(id);
    }
}
