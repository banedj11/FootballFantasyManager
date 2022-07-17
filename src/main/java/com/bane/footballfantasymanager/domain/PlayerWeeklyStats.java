package com.bane.footballfantasymanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class PlayerWeeklyStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer gameweek;

    private Double value;

    @ManyToOne
    private Player player;

    @ManyToOne
    private PlayerStatsType playerStatsType;

}
