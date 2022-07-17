package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.dto.UserDTO;
import com.bane.footballfantasymanager.dto.UserRegisterDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findOne(Long id);
    List<User> findAll();
    Optional<User> findByEmail(String email);
    UserDTO registerUser(UserRegisterDTO user);
    User updateUser(User user);


}
