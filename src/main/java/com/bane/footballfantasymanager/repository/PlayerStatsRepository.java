package com.bane.footballfantasymanager.repository;

import com.bane.footballfantasymanager.domain.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
}
