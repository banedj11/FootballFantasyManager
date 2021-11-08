package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.PlayerStats;

import java.util.List;
import java.util.Optional;

public interface PlayerStatsService {

    PlayerStats createPlayerStats(PlayerStats playerStats);

    Optional<PlayerStats> findById(Long id);

    List<PlayerStats> findAll();

    void deletePlayerStats(Long id);
}
