package com.bane.footballfantasymanager;

import com.bane.footballfantasymanager.constants.Constants;
import com.bane.footballfantasymanager.constants.RoleConstants;
import com.bane.footballfantasymanager.domain.Authority;
import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.repository.AuthorityRepository;
import com.bane.footballfantasymanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FootballFantasyManagerApplication {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityRepository authorityRepository;

	@PostConstruct
	public void initUsers() {
		Set<Authority> authorities = new HashSet<>();
		Authority authority1 = new Authority(RoleConstants.USER);
		Authority authority2 = new Authority(RoleConstants.ADMIN);
		authorities.add(authority1);
		authorities.add(authority2);
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
