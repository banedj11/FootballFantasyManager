package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team save(Team team);

    Optional<Team> findOne(Long id);

    List<Team> findAll();

    void delete(Long id);
}
