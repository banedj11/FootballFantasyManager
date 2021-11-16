package com.bane.footballfantasymanager.resource;

import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.dto.UserDTO;
import com.bane.footballfantasymanager.service.UserService;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        User newUser = userService.registerUser(user);
        return ResponseEntity.created(new URI("/api/users/" + newUser.getEmail())).body(newUser);
    }



    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
