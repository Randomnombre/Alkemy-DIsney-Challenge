package com.alkemy.Disney.APIChallenge.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.Disney.APIChallenge.dto.CharacterDTO;
import com.alkemy.Disney.APIChallenge.dto.MovieDTO;
import com.alkemy.Disney.APIChallenge.models.CharacterEntity;

@Component
public class CharacterMapper {

	@Autowired
	private MovieMapper movieMapper;
	
	public CharacterEntity characterDto2Entity(CharacterDTO dto) {
		
		CharacterEntity entity = new CharacterEntity();
		entity.setImage(dto.getImage());
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setWeight(dto.getWeight());
		entity.setStory(dto.getStory());
		//Adding movies its not part of this method, movies should be added in a different function
		
		return entity;
	}
	
	public CharacterDTO characterEntity2Dto(CharacterEntity entity , boolean loadedMovie) {
		
		CharacterDTO dto = new CharacterDTO();
		dto.setCharacter_id(entity.getCharacter_id());
		dto.setImage(entity.getImage());
		dto.setName(entity.getName());
		dto.setAge(entity.getAge());
		dto.setWeight(entity.getWeight());
		dto.setStory(entity.getStory());
		
		if(loadedMovie = true) {
			
			List<MovieDTO> moviesDto = this.movieMapper.movieEntityList2DtoList(entity.getMovies(), false);
			
			dto.setMovies(moviesDto);
		}
		
		return dto;
	}
	
	public List<CharacterDTO> characterEntityList2DtoList(List<CharacterEntity> entities, boolean moviesLoaded ) {
		
		List<CharacterDTO> dtoList = new ArrayList<>();
		
		for (CharacterEntity entity : entities) {
			dtoList.add(characterEntity2Dto(entity, moviesLoaded));
		}
		
		return dtoList;
	}
	
	public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtoList) {
		
		List<CharacterEntity> entityList = new ArrayList<>();
		
		for(CharacterDTO dto : dtoList) {
			entityList.add(characterDto2Entity(dto));
		}
		return entityList;
	}
}
