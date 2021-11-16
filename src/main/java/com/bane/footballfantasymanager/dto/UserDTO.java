package com.bane.footballfantasymanager.dto;

import com.bane.footballfantasymanager.constants.Constants;
import com.bane.footballfantasymanager.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    @Email
    @Pattern(regexp = Constants.EMAIL_REGEX)
    private String email;

    private Country country;
}
