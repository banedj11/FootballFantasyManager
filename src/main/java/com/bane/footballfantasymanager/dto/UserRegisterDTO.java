package com.bane.footballfantasymanager.dto;

import com.bane.footballfantasymanager.constants.Constants;
import com.bane.footballfantasymanager.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Country country;

    @Email
    @Pattern(regexp = Constants.EMAIL_REGEX)
    private String email;

    @Size(min = 4, max = 100)
    @NotNull
    private String password;
}
