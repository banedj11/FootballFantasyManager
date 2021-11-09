package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.Player;
import com.bane.footballfantasymanager.domain.PlayerPosition;

import java.util.List;
import java.util.Optional;

public interface PlayerPositionService {

    PlayerPosition createPlayerPosition(PlayerPosition playerPosition);

    Optional<PlayerPosition> findById(Long id);

    List<PlayerPosition> findAll();

    void deletePlayerPosition(Long id);
}
