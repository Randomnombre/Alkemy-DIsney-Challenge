package com.alkemy.Disney.APIChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@DeleteMapping("/{character_id}")
	public ResponseEntity<Void> delete(@PathVariable Integer character_id) {
		
		characterService.delete(character_id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
