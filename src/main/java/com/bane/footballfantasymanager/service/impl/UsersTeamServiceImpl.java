package com.bane.footballfantasymanager.service.impl;

import com.bane.footballfantasymanager.domain.UsersTeam;
import com.bane.footballfantasymanager.repository.UsersTeamRepository;
import com.bane.footballfantasymanager.service.UsersTeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTeamServiceImpl implements UsersTeamService {

    private final UsersTeamRepository usersTeamRepository;

    public UsersTeamServiceImpl(UsersTeamRepository usersTeamRepository) {
        this.usersTeamRepository = usersTeamRepository;
    }

    @Override
    public UsersTeam createUsersTeam(UsersTeam usersTeam) {
        return usersTeamRepository.save(usersTeam);
    }

    @Override
    public UsersTeam updateUsersTeam(Long id) {
        return null;
    }

    @Override
    public UsersTeam getByUsersId(Long id) {
        return usersTeamRepository.findByUserId(id);
    }

    @Override
    public List<UsersTeam> findAll() {
        return usersTeamRepository.findAll();
    }
}
