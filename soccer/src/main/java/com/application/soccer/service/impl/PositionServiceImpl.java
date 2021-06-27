package com.application.soccer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.soccer.entity.PlayerPositionEntity;
import com.application.soccer.repo.PlayerPositionRepo;
import com.application.soccer.service.PositionService;

@Service
@Transactional
public class PositionServiceImpl implements PositionService{
	
	@Autowired
	private PlayerPositionRepo playerPositionRepo;
	
	@Override
	public List<String> getAllPositions() {
		List<String> positionList = new ArrayList<>();
		List<PlayerPositionEntity> playerPositionList = playerPositionRepo.findAll();
		for (PlayerPositionEntity eachPlayerPosition : playerPositionList) {
			positionList.add(eachPlayerPosition.getPositionName());
		}
		return positionList.stream().sorted().collect(Collectors.toList());
	}
	
	@Override
	public PlayerPositionEntity findByPositionName(String playerPostion) {
		return playerPositionRepo.findByPositionName(playerPostion);
	}
}
