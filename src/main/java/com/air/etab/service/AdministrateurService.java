package com.air.etab.service;

import com.air.etab.entities.Administrateur;
import com.air.etab.entities.Couverture;

import java.util.List;
import java.util.Optional;

public interface AdministrateurService {
    public Administrateur save(Administrateur a);
    public Boolean delete(Long id);
    public Administrateur update(Long id, Administrateur a);
    public void addRoleToAdmin(String nom, Long id);
    public Administrateur findAdministrateurByNom(String nom);
    public List<Administrateur> getAdministrateur();
    public Optional<Administrateur> getAdministrateur(Long id);
    public List<Couverture> getCouvertures();
    public Optional<Couverture> getCouverture(Long id);
}
