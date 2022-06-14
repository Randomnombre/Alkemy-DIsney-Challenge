package com.alkemy.Disney.APIChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.Disney.APIChallenge.models.GenreEntity;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Integer>{

	
}
