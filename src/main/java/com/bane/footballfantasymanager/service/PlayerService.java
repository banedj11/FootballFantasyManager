package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    Player createPlayer(Player player);

    Optional<Player> findById(Long id);

    List<Player> findAll();

    void deletePlayer(Long id);
}
