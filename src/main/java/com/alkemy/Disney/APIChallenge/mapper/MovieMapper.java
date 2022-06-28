package com.alkemy.Disney.APIChallenge.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.Disney.APIChallenge.dto.CharacterDTO;
import com.alkemy.Disney.APIChallenge.dto.MovieDTO;
import com.alkemy.Disney.APIChallenge.models.MovieEntity;

@Component
public class MovieMapper {

	@Autowired
	private CharacterMapper characterMapper;
	
	@Autowired
	private GenreMapper genreMapper;
	
	
	public MovieEntity movieDto2Entity(MovieDTO dto) {
		
		MovieEntity entity = new MovieEntity();
		entity.setImage(dto.getImage());
		entity.setTitle(dto.getTitle());
		entity.setDateOfCreation(dto.getDateOfCreation());
		entity.setRating(dto.getRating());
		entity.setCharacters(this.characterMapper.characterDTOList2EntityList(dto.getCharacters())); //si tengo que agregar los personajes cuando se crean, a diferencia de characters
		return entity;
	}
	
	public MovieDTO movieEntity2Dto(MovieEntity movieEntity, boolean charactersLoaded) {
		
		MovieDTO dto = new MovieDTO();
		dto.setMovie_id(movieEntity.getMovie_id());
		dto.setImage(movieEntity.getImage());
		dto.setTitle(movieEntity.getTitle());
		dto.setDateOfCreation(movieEntity.getDateOfCreation());
		dto.setRating(movieEntity.getRating());
		
		if(charactersLoaded == true) {
			
			List<CharacterDTO> moviesDto = this.characterMapper.characterEntityList2DtoList(movieEntity.getCharacters(), false);
			
			dto.setCharacters(moviesDto);
		}
		
		return dto;
	}
	
	public List<MovieDTO> movieEntityList2DtoList(List<MovieEntity> entities, boolean charactersLoaded) {
		
		List<MovieDTO> dtoList = new ArrayList<>();
		
		for (MovieEntity entity : entities) {
			dtoList.add(this.movieEntity2Dto(entity, charactersLoaded));
		}
		
		return dtoList;
	}
}
