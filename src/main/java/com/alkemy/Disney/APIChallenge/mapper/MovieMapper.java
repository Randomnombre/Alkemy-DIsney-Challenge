package com.alkemy.Disney.APIChallenge.mapper;

import org.springframework.stereotype.Component;

import com.alkemy.Disney.APIChallenge.dto.MovieDTO;
import com.alkemy.Disney.APIChallenge.models.MovieEntity;

@Component
public class MovieMapper {

	public MovieEntity movieDto2Entity(MovieDTO dto) {
		MovieEntity entity = new MovieEntity();
		entity.setImage(dto.getImage());
		entity.setTitle(dto.getTitle());
		entity.setDateOfCreation(dto.getDateOfCreation());
		entity.setRating(dto.getRating());
		entity.setCharacters(dto.getCharacters());
		
		return entity;
	}
	
	public MovieDTO movieEntity2Dto(MovieEntity movieEntity) {
		MovieDTO dto = new MovieDTO();
		dto.setMovie_id(movieEntity.getMovie_id());
		dto.setImage(movieEntity.getImage());
		dto.setTitle(movieEntity.getTitle());
		dto.setDateOfCreation(movieEntity.getDateOfCreation());
		dto.setRating(movieEntity.getRating());
		dto.setCharacters(movieEntity.getCharacters());
		
		return dto;
	}
}
