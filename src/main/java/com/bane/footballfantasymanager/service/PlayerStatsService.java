package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.PlayerStats;

import java.util.List;
import java.util.Optional;

public interface PlayerStatsService {

    PlayerStats save(PlayerStats playerStats);

    Optional<PlayerStats> findOne(Long id);

    List<PlayerStats> findAll();

    void delete(Long id);
}
