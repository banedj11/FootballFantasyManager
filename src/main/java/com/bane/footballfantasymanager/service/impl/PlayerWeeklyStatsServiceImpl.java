package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.domain.PlayerWeeklyStats;
import com.bane.footballfantasymanager.repository.PlayerWeeklyStatsRepository;
import com.bane.footballfantasymanager.service.PlayerWeeklyStatsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerWeeklyStatsServiceImpl implements PlayerWeeklyStatsService {

    private final PlayerWeeklyStatsRepository playerWeeklyStatsRepository;

    public PlayerWeeklyStatsServiceImpl(PlayerWeeklyStatsRepository playerStatsRepository) {
        this.playerWeeklyStatsRepository = playerStatsRepository;
    }

    @Override
    public PlayerWeeklyStats save(PlayerWeeklyStats playerWeeklyStats) {
        return playerWeeklyStatsRepository.save(playerWeeklyStats);
    }

    @Override
    public Optional<PlayerWeeklyStats> findOne(Long id) {
        return playerWeeklyStatsRepository.findById(id);
    }

    @Override
    public List<PlayerWeeklyStats> findAll() {
        return playerWeeklyStatsRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        playerWeeklyStatsRepository.deleteById(id);
    }
}
