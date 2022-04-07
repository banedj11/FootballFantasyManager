package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.domain.Player;
import com.bane.footballfantasymanager.repository.PlayerRepository;
import com.bane.footballfantasymanager.service.PlayerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Optional<Player> findOne(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
