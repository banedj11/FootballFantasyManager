package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.PlayerStatsType;

import java.util.List;
import java.util.Optional;

public interface PlayerStatsTypeService {

    PlayerStatsType save(PlayerStatsType playerStatsType);

    Optional<PlayerStatsType> findOne(Long id);

    List<PlayerStatsType> findAll();

    void delete(Long id);
}
