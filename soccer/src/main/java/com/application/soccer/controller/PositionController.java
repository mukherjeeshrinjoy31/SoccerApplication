package com.application.soccer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.soccer.service.PositionService;

import java.util.List;

@RestController
public class PositionController {
	
	@Autowired
	private PositionService playerPositionService;
	
	@RequestMapping(value = "/api/soccer/position", method = RequestMethod.GET)
	public ResponseEntity<List<String>> findAllPlayerPosition(){
		return new ResponseEntity<List<String>>(playerPositionService.getAllPositions(), HttpStatus.OK);
	}

}
