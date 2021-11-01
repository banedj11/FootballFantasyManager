package com.bane.footballfantasymanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class Authority {

    @NotNull
    @Size(max = 50)
    @Id
    private String name;
}
