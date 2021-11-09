package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.domain.PlayerPosition;
import com.bane.footballfantasymanager.service.PlayerPositionRepository;
import com.bane.footballfantasymanager.service.PlayerPositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerPositionServiceImpl implements PlayerPositionService {

    private final PlayerPositionRepository playerPositionRepository;

    public PlayerPositionServiceImpl(PlayerPositionRepository playerPositionRepository) {
        this.playerPositionRepository = playerPositionRepository;
    }

    @Override
    public PlayerPosition createPlayerPosition(PlayerPosition playerPosition) {
        return playerPositionRepository.save(playerPosition);
    }

    @Override
    public Optional<PlayerPosition> findById(Long id) {
        return playerPositionRepository.findById(id);
    }

    @Override
    public List<PlayerPosition> findAll() {
        return playerPositionRepository.findAll();
    }

    @Override
    public void deletePlayerPosition(Long id) {
        playerPositionRepository.deleteById(id);
    }
}
