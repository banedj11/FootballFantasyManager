package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.domain.PlayerStatsType;
import com.bane.footballfantasymanager.repository.PlayerStatsTypeRepository;
import com.bane.footballfantasymanager.service.PlayerStatsTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerStatsTypeServiceImpl implements PlayerStatsTypeService {

    private final PlayerStatsTypeRepository playerStatsTypeRepository;

    public PlayerStatsTypeServiceImpl(PlayerStatsTypeRepository playerStatsTypeRepository) {
        this.playerStatsTypeRepository = playerStatsTypeRepository;
    }

    @Override
    public PlayerStatsType createPlayerStatsType(PlayerStatsType playerStatsType) {
        return playerStatsTypeRepository.save(playerStatsType);
    }

    @Override
    public Optional<PlayerStatsType> findById(Long id) {
        return playerStatsTypeRepository.findById(id);
    }

    @Override
    public List<PlayerStatsType> findAll() {
        return playerStatsTypeRepository.findAll();
    }

    @Override
    public void deletePlayerStatsType(Long id) {
        playerStatsTypeRepository.deleteById(id);
    }
}
