package com.application.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.soccer.entity.NationEntity;

public interface NationRepo extends JpaRepository<NationEntity, Long>{

	public NationEntity findByNationName(String nationName);
}
