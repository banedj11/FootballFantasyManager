package com.bane.footballfantasymanager.resource;

import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.dto.UserDTO;
import com.bane.footballfantasymanager.dto.UserRegisterDTO;
import com.bane.footballfantasymanager.errors.UserNotFoundException;
import com.bane.footballfantasymanager.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
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
public class UserResource {

    private final UserService userService;

    @Autowired
    @Lazy
    private ConversionService conversionService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserRegisterDTO user) throws URISyntaxException {
        UserDTO newUser = userService.registerUser(user);
        return ResponseEntity.created(new URI("/api/users/" + newUser.getEmail())).body(newUser);
    }

    @GetMapping("/users")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAll().stream().map(u -> conversionService.convert(u, UserDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = conversionService.convert(userService.findOne(id), UserDTO.class);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
