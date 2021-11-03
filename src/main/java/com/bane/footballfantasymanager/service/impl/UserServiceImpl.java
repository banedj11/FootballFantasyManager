package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.config.Constants;
import com.bane.footballfantasymanager.domain.Authority;
import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.repository.UserRepository;
import com.bane.footballfantasymanager.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByID(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User registerUser(User user) {
        Set<Authority> authorities = user.getAuthorities();
        Authority authority = new Authority(Constants.USER);
        authorities.add(authority);
        user.setAuthorities(authorities);

//        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
//        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User updateUser = userRepository.getById(user.getId());
        updateUser.setEmail(user.getEmail());
        updateUser.setFirstName(user.getFirstName());
        return updateUser;
    }
}