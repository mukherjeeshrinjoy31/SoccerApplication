package com.application.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.soccer.entity.ClubEntity;

public interface ClubRepo extends JpaRepository<ClubEntity, Long>{
	
	public ClubEntity findByClubName(String clubName);

}
