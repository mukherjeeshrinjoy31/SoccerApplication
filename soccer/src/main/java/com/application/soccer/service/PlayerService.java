package com.application.soccer.service;

import java.util.List;

import com.application.soccer.dto.PlayerDetails;

public interface PlayerService {

	List<PlayerDetails> getAllPlayerDetails();

	PlayerDetails getAllPlayerDetailsByName(String name);

	PlayerDetails addPlayer(PlayerDetails playerDetails);

}
