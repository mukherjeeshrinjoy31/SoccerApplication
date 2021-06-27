package com.application.soccer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.soccer.dto.PlayerDetails;
import com.application.soccer.entity.ClubEntity;
import com.application.soccer.entity.NationEntity;
import com.application.soccer.entity.PlayerDetailsEntity;
import com.application.soccer.entity.PlayerPositionEntity;
import com.application.soccer.enumobject.EnumPosition;
import com.application.soccer.repo.PlayerDetailsRepo;
import com.application.soccer.service.ClubService;
import com.application.soccer.service.NationService;
import com.application.soccer.service.PlayerService;
import com.application.soccer.service.PositionService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	private PlayerDetailsRepo playerDetailsRepo;
	@Autowired
	private NationService nationService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private ClubService clubService;
	
	@Override
	public List<PlayerDetails> getAllPlayerDetails(){
		List<PlayerDetailsEntity> playerDetailsEntityList = playerDetailsRepo.findAll();
		List<PlayerDetails> playerDetailsList = new ArrayList<PlayerDetails>();
		for(PlayerDetailsEntity eachPlayerDetails : playerDetailsEntityList) {
			PlayerDetails playerDetails = buildPlayerDetailsObject(eachPlayerDetails);
			playerDetailsList.add(playerDetails);
		}
		return playerDetailsList;
	}
	
	@Override
	public PlayerDetails getAllPlayerDetailsByName(String name) {
		PlayerDetailsEntity playerDetailsEntity = playerDetailsRepo.findByPlayerName(name.toUpperCase());
		return buildPlayerDetailsObject(playerDetailsEntity);
	}
	
	@Override
	public PlayerDetails addPlayer(PlayerDetails playerDetails) {
		NationEntity nation = nationService.getNationByName(playerDetails.getPlayerNationality());
		PlayerPositionEntity player = positionService.findByPositionName(playerDetails.getPlayerPosition());
		ClubEntity club = clubService.findByClubName(playerDetails.getPlayerClub());
		
		PlayerDetailsEntity playerDetailsEntity = buildPlayerDetailsEntityObject(playerDetails, nation, player, club);
		playerDetailsRepo.save(playerDetailsEntity);
		return playerDetails;
	}

	private PlayerDetailsEntity buildPlayerDetailsEntityObject(PlayerDetails playerDetails, NationEntity nation,
			PlayerPositionEntity player, ClubEntity club) {
		PlayerDetailsEntity playerDetailsEntity = new PlayerDetailsEntity();
		playerDetailsEntity.setPlayerName(playerDetails.getPlayerName());
		playerDetailsEntity.setPlayerAge(playerDetails.getPlayerAge());
		playerDetailsEntity.setPlayerGoals(playerDetails.getPlayerGoals());
		playerDetailsEntity.setPlayerAssists(playerDetails.getPlayerAssists());
		playerDetailsEntity.setPlayerPosition(player);
		playerDetailsEntity.setPlayerNation(nation);
		playerDetailsEntity.setPlayerClubEntity(club);
		playerDetailsEntity.setPlayerStarRating(playerDetails.getPlayerStarRating());
		if(playerDetails.getPlayerPosition().equalsIgnoreCase(EnumPosition.GK.value())) {
			playerDetailsEntity.setPlayerCleanSheets(playerDetails.getPlayerCleanSheets());
		}
		else {
			playerDetailsEntity.setPlayerCleanSheets(0);
		}
		return playerDetailsEntity;
	}
	
	private PlayerDetails buildPlayerDetailsObject(PlayerDetailsEntity eachPlayerDetails) {
		PlayerDetails playerDetails = new PlayerDetails();
		playerDetails.setPlayerId(eachPlayerDetails.getPlayerId());
		playerDetails.setPlayerName(eachPlayerDetails.getPlayerName());
		playerDetails.setPlayerAge(eachPlayerDetails.getPlayerAge());
		playerDetails.setPlayerGoals(eachPlayerDetails.getPlayerGoals());
		playerDetails.setPlayerAssists(eachPlayerDetails.getPlayerAssists());
		playerDetails.setPlayerCleanSheets(eachPlayerDetails.getPlayerCleanSheets());
		playerDetails.setPlayerPosition(eachPlayerDetails.getPlayerPosition().getPositionName());
		playerDetails.setPlayerClub(eachPlayerDetails.getPlayerClubEntity().getClubName());
		playerDetails.setPlayerNationality(eachPlayerDetails.getPlayerNation().getNationName());
		playerDetails.setPlayerStarRating(eachPlayerDetails.getPlayerStarRating());
		return playerDetails;
	}

}
