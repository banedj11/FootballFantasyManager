package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.PlayerStatsType;

import java.util.List;
import java.util.Optional;

public interface PlayerStatsTypeService {

    PlayerStatsType createPlayerStatsType(PlayerStatsType playerStatsType);

    Optional<PlayerStatsType> findById(Long id);

    List<PlayerStatsType> findAll();

    void deletePlayerStatsType(Long id);
}
