package com.bane.footballfantasymanager;

import com.bane.footballfantasymanager.config.Constants;
import com.bane.footballfantasymanager.domain.Authority;
import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.repository.AuthorityRepository;
import com.bane.footballfantasymanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FootballFantasyManagerApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@PostConstruct
	public void initUsers() {
		Set<Authority> authorities = new HashSet<>();
		Authority authority1 = new Authority(Constants.USER);
		Authority authority2 = new Authority(Constants.ADMIN);
		authorities.add(authority1);
		authorities.add(authority2);
		authorityRepository.saveAll(authorities);
		List<User> users = Stream.of(
				new User(101L, "Pera", "Peric", "pera@gmail.com", "12345", true),
				new User(102L, "Steva", "Stevic", "steva@gmail.com", "12345", true)
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(FootballFantasyManagerApplication.class, args);
	}

}
