package com.application.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.soccer.entity.PlayerPositionEntity;

public interface PlayerPositionRepo extends JpaRepository<PlayerPositionEntity, Long>{
	
	public PlayerPositionEntity findByPositionName(String postionName);

}
