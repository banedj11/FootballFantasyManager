package com.bane.footballfantasymanager.service;

import com.bane.footballfantasymanager.domain.PlayerPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerPositionRepository extends JpaRepository<PlayerPosition, Long> {
}
