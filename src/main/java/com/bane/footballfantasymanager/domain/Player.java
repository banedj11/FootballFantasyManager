package com.bane.footballfantasymanager.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Double price;

    private Integer overallPoints;

    private Integer gameweekPoints;

    private boolean captain = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;




}
