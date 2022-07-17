package com.bane.footballfantasymanager.repository;

import com.bane.footballfantasymanager.domain.PlayerWeeklyStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerWeeklyStatsRepository extends JpaRepository<PlayerWeeklyStats, Long> {
}
