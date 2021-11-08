package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Country createCountry(Country country);
    List<Country> getAllCountries();
    Optional<Country> getCountryById(Long id);
    void deleteCountry(Long id);
}
