package com.bane.footballfantasymanager.repository;

import com.bane.footballfantasymanager.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
