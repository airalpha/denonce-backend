package com.air.etab.service;

import com.air.etab.entities.Couverture;
import com.air.etab.entities.Role;

public interface RoleService {
    public Role save(Role r);
    public Role findByCouverture(Couverture couverture);
}
