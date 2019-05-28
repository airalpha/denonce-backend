package com.air.etab.repository;

import com.air.etab.entities.Couverture;
import com.air.etab.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Autowired
    public Role findByCouverture(Couverture couverture);
}
