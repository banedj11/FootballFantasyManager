package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.constants.RoleConstants;
import com.bane.footballfantasymanager.domain.Authority;
import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.dto.UserDTO;
import com.bane.footballfantasymanager.dto.UserRegisterDTO;
import com.bane.footballfantasymanager.errors.UserNotFoundException;
import com.bane.footballfantasymanager.repository.UserRepository;
import com.bane.footballfantasymanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    @Lazy
    private ConversionService conversionService;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findOne(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException("User with id: " + id + " doesn't exist");
        }
        return user.get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDTO registerUser(UserRegisterDTO userDTO) {
        Set<Authority> authorities = new HashSet<>();
        Authority authority = new Authority(RoleConstants.USER);
        authorities.add(authority);
        User user = conversionService.convert(userDTO, User.class);
        user.setAuthorities(authorities);
        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        user.setIsActive(true);

        return conversionService.convert(userRepository.save(user), UserDTO.class);
    }

    @Override
    public User updateUser(User user) {
        User updateUser = userRepository.getById(user.getId());
        updateUser.setEmail(user.getEmail());
        updateUser.setFirstName(user.getFirstName());
        return updateUser;
    }
}
