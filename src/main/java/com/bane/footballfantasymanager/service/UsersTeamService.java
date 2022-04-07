package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.UsersTeam;

import java.util.List;

public interface UsersTeamService {

    UsersTeam save(UsersTeam usersTeam);

    UsersTeam getByUsersId(Long id);

    List<UsersTeam> findAll();

    void delete(Long id);
}
