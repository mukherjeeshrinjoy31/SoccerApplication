package com.application.soccer.service;

import java.util.List;

import com.application.soccer.entity.NationEntity;

public interface NationService {

	List<String> getAllNations();

	NationEntity addNation(NationEntity nationEntity);

	List<NationEntity> getAllNationsObject();

	NationEntity getNationByName(String nationName);

}
