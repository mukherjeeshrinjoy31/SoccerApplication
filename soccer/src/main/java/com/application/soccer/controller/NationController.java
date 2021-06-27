package com.application.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.soccer.entity.NationEntity;
import com.application.soccer.service.NationService;

@RestController
public class NationController {
	
	@Autowired
	private NationService nationService;
	
	@RequestMapping(value = "/api/soccer/nation", method = RequestMethod.GET)
	public ResponseEntity<List<String>> findAllNations(){
		return new ResponseEntity<List<String>>(nationService.getAllNations(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/soccer/nation/all", method = RequestMethod.GET)
	public ResponseEntity<List<NationEntity>> findAllNationsObject(){
		return new ResponseEntity<List<NationEntity>>(nationService.getAllNationsObject(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/soccer/nation/add", method = RequestMethod.POST)
	public ResponseEntity<NationEntity> saveNation(@RequestBody NationEntity nationEntity){
		if(nationEntity != null) {
			return new ResponseEntity<NationEntity>(nationService.addNation(nationEntity), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	

}
