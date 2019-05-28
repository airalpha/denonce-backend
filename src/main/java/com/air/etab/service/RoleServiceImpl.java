package com.air.etab.service;

import com.air.etab.entities.Couverture;
import com.air.etab.entities.Role;
import com.air.etab.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role r) {
        //Role role = roleRepository.findByCouverture()
        return roleRepository.save(r);
    }

    @Override
    public Role findByCouverture(Couverture couverture) {
        return roleRepository.findByCouverture(couverture);
    }
}
