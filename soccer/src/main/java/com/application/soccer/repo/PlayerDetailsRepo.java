package com.application.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.soccer.entity.PlayerDetailsEntity;

public interface PlayerDetailsRepo extends JpaRepository<PlayerDetailsEntity, Long>{

	public PlayerDetailsEntity findByPlayerName(String playerName);
}
