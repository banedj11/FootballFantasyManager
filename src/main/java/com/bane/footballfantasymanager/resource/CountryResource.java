package com.bane.footballfantasymanager.resource;

import com.bane.footballfantasymanager.domain.Country;
import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.dto.UserDTO;
import com.bane.footballfantasymanager.service.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CountryResource {

    private final CountryService countryService;

    @Autowired
    private ConversionService conversionService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/countries")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Country> createCountry(@RequestBody Country country) throws URISyntaxException {
        return ResponseEntity.created(new URI("/api/countries/" + country.getId())).body(countryService.createCountry(country));
    }

    @GetMapping("/countries")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<List<Country>> getAllCountries() {
        return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
    }

    @GetMapping("/countries/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Country> getCountry(@PathVariable Long id) {
        return new ResponseEntity<>(countryService.getCountryById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/countries/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
