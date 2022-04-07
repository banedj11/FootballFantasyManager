package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.domain.Country;
import com.bane.footballfantasymanager.repository.CountryRepository;
import com.bane.footballfantasymanager.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findOne(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }


}
