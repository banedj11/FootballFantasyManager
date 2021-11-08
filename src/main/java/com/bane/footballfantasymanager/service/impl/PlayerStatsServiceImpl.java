package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.domain.PlayerStats;
import com.bane.footballfantasymanager.repository.PlayerStatsRepository;
import com.bane.footballfantasymanager.service.PlayerStatsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerStatsServiceImpl implements PlayerStatsService {

    private final PlayerStatsRepository playerStatsRepository;

    public PlayerStatsServiceImpl(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    @Override
    public PlayerStats createPlayerStats(PlayerStats playerStats) {
        return playerStatsRepository.save(playerStats);
    }

    @Override
    public Optional<PlayerStats> findById(Long id) {
        return playerStatsRepository.findById(id);
    }

    @Override
    public List<PlayerStats> findAll() {
        return playerStatsRepository.findAll();
    }

    @Override
    public void deletePlayerStats(Long id) {
        playerStatsRepository.deleteById(id);
    }
}
