package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Country save(Country country);
    List<Country> findAll();
    Optional<Country> findOne(Long id);
    void deleteCountry(Long id);
}
