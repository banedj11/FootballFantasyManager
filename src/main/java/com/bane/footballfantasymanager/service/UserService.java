package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByID(Long id);
    List<User> getAllUsers();
    Optional<User> findByEmail(String email);
    User registerUser(User user);
    User updateUser(User user);


}
