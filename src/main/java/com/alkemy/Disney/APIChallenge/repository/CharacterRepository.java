package com.alkemy.Disney.APIChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.Disney.APIChallenge.models.CharacterEntity;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer>{

	
}

