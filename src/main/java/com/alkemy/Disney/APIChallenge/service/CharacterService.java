package com.alkemy.Disney.APIChallenge.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.Disney.APIChallenge.dto.CharacterFiltersDTO;
import com.alkemy.Disney.APIChallenge.repository.specifications.CharacterSpecification;
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

	private CharacterSpecification characterSpecification;

	@Autowired
	public CharacterService(CharacterMapper characterMapper, CharacterRepository characterRepository, CharacterSpecification characterSpecification) {
		this.characterMapper = characterMapper;
		this.characterRepository = characterRepository;
		this.characterSpecification = characterSpecification;
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

	public CharacterDTO getCharacterById(Integer character_id) {

		Optional<CharacterEntity> findEntity = characterRepository.findById(character_id);
		CharacterDTO result = null;
		if (findEntity.isPresent()) {
			CharacterEntity entity = findEntity.get();
			result = characterMapper.characterEntity2Dto(entity, true);
		}
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

	public List<CharacterDTO> getByFilters(String name, Integer age, Double weight, List<Integer> movies) {

		CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, weight, movies);
		List<CharacterEntity> entities = this.characterRepository.findAll(this.characterSpecification.getByFilters(filtersDTO));
		List<CharacterDTO> result = this.characterMapper.characterEntityList2DtoList(entities, true);

		return result;
	}
}
