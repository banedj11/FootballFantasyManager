package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team createTeam(Team team);

    Optional<Team> findById(Long id);

    List<Team> findAll();

    void deleteTeam(Long id);
}
