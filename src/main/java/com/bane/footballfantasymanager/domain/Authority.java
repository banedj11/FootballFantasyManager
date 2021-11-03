package com.bane.footballfantasymanager.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    @NotNull
    @Size(max = 50)
    @Id
    private String name;
}
