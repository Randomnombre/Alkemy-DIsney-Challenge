package com.alkemy.Disney.APIChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alkemy.Disney.APIChallenge.dto.CharacterDTO;
import com.alkemy.Disney.APIChallenge.service.CharacterService;

@RestController
@RequestMapping("characters")
public class CharacterController {


	@Autowired
	private CharacterService characterService;
	
	@PostMapping
	public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO characterDto) {
		
		CharacterDTO characterSaved = characterService.save(characterDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
	}
	
	@RequestMapping
	public ResponseEntity<List<CharacterDTO>> getAll() {
		
		List<CharacterDTO> characters = characterService.getAllCharacters();
		
		return ResponseEntity.ok().body(characters);
	}

	@RequestMapping("/{character_id}")
	public ResponseEntity<CharacterDTO> findCharacterById(@PathVariable Integer character_id) {

		CharacterDTO character = characterService.getCharacterById(character_id);

		return ResponseEntity.ok().body(character);
	}

	@DeleteMapping("/{character_id}")
	public ResponseEntity<Void> delete(@PathVariable Integer character_id) {
		
		characterService.delete(character_id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{character_id}")
	public ResponseEntity<CharacterDTO> update(@PathVariable Integer character_id, @RequestBody CharacterDTO characterDto) {

		CharacterDTO characterUpdated = characterService.update(character_id, characterDto);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(characterUpdated);
	}
}
