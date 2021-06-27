package com.application.soccer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.soccer.dto.PlayerClub;
import com.application.soccer.entity.ClubEntity;
import com.application.soccer.entity.NationEntity;
import com.application.soccer.repo.ClubRepo;
import com.application.soccer.service.ClubService;
import com.application.soccer.service.NationService;

@Service
@Transactional
public class ClubServiceImpl implements ClubService{
	
	@Autowired
	private ClubRepo clubRepo;
	
	@Autowired
	private NationService nationService;
	
	@Override
	public List<String> findAllClubs(){
		List<ClubEntity> clubObjectList = clubRepo.findAll();
		List<String> clubList = new ArrayList<String>();
		for(ClubEntity eachClub : clubObjectList) {
			clubList.add(eachClub.getClubName());
		}
		return clubList.stream().sorted().collect(Collectors.toList());
	}
	
	@Override
	public PlayerClub addClub(PlayerClub playerClub) {
		NationEntity nation = nationService.getNationByName(playerClub.getClubNationName());
		
		ClubEntity clubEntity = new ClubEntity();
		clubEntity.setClubName(playerClub.getClubName());
		clubEntity.setClubCode(playerClub.getClubCode());
		clubEntity.setPlayerNation(nation);
		clubRepo.save(clubEntity);
		return playerClub;
	}
	
	@Override
	public List<ClubEntity> findAllClubObject() {
		return clubRepo.findAll();
	}
	
	@Override
	public ClubEntity findByClubName(String clubName) {
		return clubRepo.findByClubName(clubName);
	}

}
