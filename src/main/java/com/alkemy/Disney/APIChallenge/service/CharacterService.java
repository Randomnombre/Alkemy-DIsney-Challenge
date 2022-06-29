package com.alkemy.Disney.APIChallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.Disney.APIChallenge.dto.CharacterDTO;
import com.alkemy.Disney.APIChallenge.mapper.CharacterMapper;
import com.alkemy.Disney.APIChallenge.models.CharacterEntity;
import com.alkemy.Disney.APIChallenge.repository.CharacterRepository;

@Service
public class CharacterService {

	private CharacterMapper characterMapper;
	
	private CharacterRepository characterRepository;
	
	@Autowired
	public CharacterService(CharacterMapper characterMapper, CharacterRepository characterRepository) {
		this.characterMapper = characterMapper;
		this.characterRepository = characterRepository;
	}
	
	public CharacterDTO save(CharacterDTO dto) {
		
		CharacterEntity entity = characterMapper.characterDto2Entity(dto);
		CharacterEntity characterSaved = characterRepository.save(entity);
		CharacterDTO result = characterMapper.characterEntity2Dto(characterSaved,true);
		
		return result;
	}
	
	public List<CharacterDTO> getAllCharacters() {
		
		List<CharacterEntity> entites = characterRepository.findAll();
		List<CharacterDTO> result = characterMapper.characterEntityList2DtoList(entites, false);
		
		return result;
	}
	
	public void delete(Integer character_id) {
		characterRepository.deleteById(character_id);
	}
	
	public CharacterDTO update(Integer character_id, CharacterDTO dto) {

		Optional<CharacterEntity> findEntity = characterRepository.findById(character_id);
		CharacterEntity entityToUpdate = null;
		if (findEntity.isPresent()) {
			entityToUpdate = findEntity.get();
		} else {
			System.out.println("Character id not present in the database");
		}

		CharacterEntity entity = characterMapper.characterDto2EntityUpdated(dto, entityToUpdate);

		CharacterEntity characterSaved = characterRepository.save(entity);
		CharacterDTO result = characterMapper.characterEntity2Dto(characterSaved, false);

		return result;
	}
}
