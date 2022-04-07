package com.bane.footballfantasymanager;

import com.bane.footballfantasymanager.constants.RoleConstants;
import com.bane.footballfantasymanager.domain.Authority;
import com.bane.footballfantasymanager.domain.Country;
import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.repository.AuthorityRepository;
import com.bane.footballfantasymanager.repository.CountryRepository;
import com.bane.footballfantasymanager.service.CountryService;
import com.bane.footballfantasymanager.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FootballFantasyManagerApplication {

	private final UserService userService;

	private final AuthorityRepository authorityRepository;

	private final CountryRepository countryRepository;

	public FootballFantasyManagerApplication(UserService userService, AuthorityRepository authorityRepository, CountryRepository countryRepository) {
		this.userService = userService;
		this.authorityRepository = authorityRepository;
		this.countryRepository = countryRepository;
	}

	@PostConstruct
	public void initUsers() {

		Country serbia = new Country(1L,"Serbia");
		Country italy = new Country(2L, "France");
		Country spain = new Country(3L, "Spain");
		List<Country> countries = new ArrayList<>();
		countries.add(serbia);
		countries.add(italy);
		countries.add(spain);
		countryRepository.saveAll(countries);

		Set<Authority> authorities = new HashSet<>();
		Authority roleUser = new Authority(RoleConstants.USER);
		Authority roleAdmin = new Authority(RoleConstants.ADMIN);
		authorities.add(roleUser);
		authorities.add(roleAdmin);
		authorityRepository.saveAll(authorities);

		User user = new User("Pera", "Peric", "pera@gmail.com", "12345", true);
		userService.registerUser(user);

		User user1 = new User( "Steva", "Stevic", "steva@gmail.com", "12345", true);
		userService.registerUser(user1);


	}

	public static void main(String[] args) {
		SpringApplication.run(FootballFantasyManagerApplication.class, args);
	}

}
