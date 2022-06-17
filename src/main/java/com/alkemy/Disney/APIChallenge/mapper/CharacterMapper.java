package com.alkemy.Disney.APIChallenge.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.Disney.APIChallenge.dto.CharacterDTO;
import com.alkemy.Disney.APIChallenge.models.CharacterEntity;

@Component
public class CharacterMapper {

	public CharacterEntity characterDto2Entity(CharacterDTO dto) {
		
		CharacterEntity entity = new CharacterEntity();
		entity.setImage(dto.getImage());
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setWeight(dto.getWeight());
		entity.setStory(dto.getStory());
		entity.setMovies(dto.getMovies());
		
		return entity;
	}
	
	public CharacterDTO characterEntity2Dto(CharacterEntity entity) {
		
		CharacterDTO dto = new CharacterDTO();
		dto.setCharacter_id(entity.getCharacter_id());
		dto.setImage(entity.getImage());
		dto.setName(entity.getName());
		dto.setAge(entity.getAge());
		dto.setWeight(entity.getWeight());
		dto.setStory(entity.getStory());
		dto.setMovies(entity.getMovies());
		
		return dto;
	}
	
	public List<CharacterDTO> characterEntityList2DtoList(List<CharacterEntity> entities) {
		
		List<CharacterDTO> list = new ArrayList<>();
		
		for (CharacterEntity entity : entities) {
			list.add(this.characterEntity2Dto(entity));
		}
		
		return list;
	}
}
