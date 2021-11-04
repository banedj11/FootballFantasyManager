package com.bane.footballfantasymanager.domain;

import lombok.*;

import javax.persistence.*;

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

    private String name;

    private Integer overallPoints;

    private Integer gameweekPoints;

    private Long overallRank;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;


}
