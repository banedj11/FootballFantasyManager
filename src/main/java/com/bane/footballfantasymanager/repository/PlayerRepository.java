package com.bane.footballfantasymanager.repository;

import com.bane.footballfantasymanager.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
