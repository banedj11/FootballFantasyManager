package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    Player save(Player player);

    Optional<Player> findOne(Long id);

    List<Player> findAll();

    void delete(Long id);
}
