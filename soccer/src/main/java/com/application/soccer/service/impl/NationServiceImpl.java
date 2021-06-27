package com.application.soccer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.soccer.entity.NationEntity;
import com.application.soccer.repo.NationRepo;
import com.application.soccer.service.NationService;

@Service
@Transactional
public class NationServiceImpl implements NationService{
	
	@Autowired
	private NationRepo nationRepo;
	
	@Override
	public List<String> getAllNations() {
		List<NationEntity> nationsObjList = nationRepo.findAll();
		List<String> nationsList = new ArrayList<String>();
		for(NationEntity eachNation : nationsObjList) {
			nationsList.add(eachNation.getNationName());
		}
		return nationsList.stream().sorted().collect(Collectors.toList());
	}
	
	@Override
	public List<NationEntity> getAllNationsObject() {
		return nationRepo.findAll();
	}
	
	@Override
	public NationEntity addNation(NationEntity nationEntity) {
		return nationRepo.save(nationEntity);
	}
	
	@Override
	public NationEntity getNationByName(String nationName) {
		return nationRepo.findByNationName(nationName);
	}

}
