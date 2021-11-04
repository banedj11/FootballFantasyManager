package com.bane.footballfantasymanager.dto.converter;

import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.Transactional;

public class UserToUserDTO implements Converter<User, UserDTO> {

    @Transactional
    @Override
    public UserDTO convert(User source) {
        UserDTO user = new UserDTO();
        user.setId(source.getId());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setEmail(source.getEmail());
        user.setCountry(source.getCountry());

        return user;
    }
}
