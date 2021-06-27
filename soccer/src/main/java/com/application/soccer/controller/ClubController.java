package com.application.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.soccer.dto.PlayerClub;
import com.application.soccer.entity.ClubEntity;
import com.application.soccer.service.ClubService;

@RestController
public class ClubController {
	
	@Autowired
	private ClubService clubService;
	
	@RequestMapping(value = "/api/soccer/club", method = RequestMethod.GET)
	public ResponseEntity<List<String>> findAllClubs(){
		return new ResponseEntity<List<String>>(clubService.findAllClubs(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/soccer/club/add", method = RequestMethod.POST)
	public ResponseEntity<PlayerClub> addClub(@RequestBody PlayerClub playerClub){
		if(playerClub != null) {
			return new ResponseEntity<PlayerClub>(clubService.addClub(playerClub), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@RequestMapping(value = "/api/soccer/club/all", method = RequestMethod.GET)
	public ResponseEntity<List<ClubEntity>> findAllClubsObject(){
		return new ResponseEntity<List<ClubEntity>>(clubService.findAllClubObject(), HttpStatus.OK);
	}

}
