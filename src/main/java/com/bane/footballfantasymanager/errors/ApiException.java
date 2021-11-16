package com.bane.footballfantasymanager.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Data
public class ApiException {

    private final String message;
    private final ZonedDateTime zonedDateTime;
    private final HttpStatus status;


}
