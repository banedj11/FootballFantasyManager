package com.bane.footballfantasymanager.repository;

import com.bane.footballfantasymanager.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

    Authority findByName(String name);
}
