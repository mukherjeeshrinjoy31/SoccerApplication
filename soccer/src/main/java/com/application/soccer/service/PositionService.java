package com.application.soccer.service;

import java.util.List;

import com.application.soccer.entity.PlayerPositionEntity;

public interface PositionService {

	List<String> getAllPositions();

	PlayerPositionEntity findByPositionName(String playerPostion);

}
