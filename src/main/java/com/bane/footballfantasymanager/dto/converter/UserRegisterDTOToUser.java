package com.bane.footballfantasymanager.dto.converter;

import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.dto.UserRegisterDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterDTOToUser implements Converter<UserRegisterDTO, User> {
    @Override
    public User convert(UserRegisterDTO source) {
        User user = new User();
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setEmail(source.getEmail());
        user.setCountry(source.getCountry());
        user.setPassword(source.getPassword());

        return user;
    }
}
