package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.Player;
import com.bane.footballfantasymanager.domain.PlayerPosition;

import java.util.List;
import java.util.Optional;

public interface PlayerPositionService {

    PlayerPosition save(PlayerPosition playerPosition);

    Optional<PlayerPosition> findOne(Long id);

    List<PlayerPosition> findAll();

    void delete(Long id);
}
