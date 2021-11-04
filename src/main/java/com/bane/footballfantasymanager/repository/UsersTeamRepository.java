package com.bane.footballfantasymanager.repository;

import com.bane.footballfantasymanager.domain.UsersTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTeamRepository extends JpaRepository<UsersTeam, Long> {

    UsersTeam findByUserId(Long id);
}
