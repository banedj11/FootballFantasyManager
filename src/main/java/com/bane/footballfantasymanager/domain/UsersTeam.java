package com.bane.footballfantasymanager.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class UsersTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 70)
    private String name;

    private Integer overallPoints;

    private Integer gameweekPoints;

    private Integer monthlyPoints;

    private Long overallRank;

    private Long gameweekRank;

    private Long monthlyRank;

    private Double budget;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;


}
