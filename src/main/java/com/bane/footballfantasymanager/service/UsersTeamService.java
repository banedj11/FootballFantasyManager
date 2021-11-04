package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.UsersTeam;

import java.util.List;

public interface UsersTeamService {

    UsersTeam createUsersTeam(UsersTeam usersTeam);
    UsersTeam updateUsersTeam(Long id);
    UsersTeam getByUsersId(Long id);
    List<UsersTeam> findAll();
}
