package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.PlayerWeeklyStats;

import java.util.List;
import java.util.Optional;

public interface PlayerWeeklyStatsService {

    PlayerWeeklyStats save(PlayerWeeklyStats playerWeeklyStats);

    Optional<PlayerWeeklyStats> findOne(Long id);

    List<PlayerWeeklyStats> findAll();

    void delete(Long id);
}
