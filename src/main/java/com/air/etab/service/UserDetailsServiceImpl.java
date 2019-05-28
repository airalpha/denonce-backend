package com.air.etab.service;

import com.air.etab.entities.Administrateur;
import com.air.etab.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AdministrateurService administrateurService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Administrateur administrateur = administrateurService.findAdministrateurByNom(userName);
        //System.out.println(userName);
        if (administrateur == null) throw new UsernameNotFoundException(userName);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Role r = administrateur.getRole();
        if (r.getCouverture().getId()==0){
            grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        }else{
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getCouverture().getClass().getSimpleName()+"-"+r.getCouverture().getId()));
        }
        return new User(administrateur.getNom(), administrateur.getPassword(), grantedAuthorities);
    }
}
