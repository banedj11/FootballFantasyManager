package com.bane.footballfantasymanager.repository;

import com.bane.footballfantasymanager.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
