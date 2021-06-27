package com.application.soccer.service;

import java.util.List;

import com.application.soccer.dto.PlayerClub;
import com.application.soccer.entity.ClubEntity;

public interface ClubService {

	List<String> findAllClubs();

	PlayerClub addClub(PlayerClub playerClub);

	List<ClubEntity> findAllClubObject();

	ClubEntity findByClubName(String clubName);

}
