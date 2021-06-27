package com.application.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.soccer.dto.PlayerDetails;
import com.application.soccer.service.PlayerService;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value = "/api/soccer/player/all", method = RequestMethod.GET)
	public ResponseEntity<List<PlayerDetails>> getAllPlayerDetails(){
		return new ResponseEntity<List<PlayerDetails>>(playerService.getAllPlayerDetails(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/soccer/player/{playerName}", method = RequestMethod.GET)
	public ResponseEntity<PlayerDetails> getAllPlayerDetailsByName(@PathVariable String playerName){
		return new ResponseEntity<PlayerDetails>(playerService.getAllPlayerDetailsByName(playerName), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/soccer/player/add", method = RequestMethod.POST)
	public ResponseEntity<PlayerDetails> addPlayer(@RequestBody PlayerDetails playerDetails){
		if(playerDetails != null) {
			return new ResponseEntity<PlayerDetails>(playerService.addPlayer(playerDetails), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
