package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findOne(Long id);
    List<User> findAll();
    Optional<User> findByEmail(String email);
    User registerUser(User user);
    User updateUser(User user);


}
