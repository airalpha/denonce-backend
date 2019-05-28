package com.air.etab.service;

import com.air.etab.entities.TypeDenonciation;

import java.util.List;
import java.util.Optional;

public interface TypeDenonciationService {
    public List<TypeDenonciation> getTypeDenonciation();
    public Optional<TypeDenonciation> getTypeDenonciation(Long id);
}
