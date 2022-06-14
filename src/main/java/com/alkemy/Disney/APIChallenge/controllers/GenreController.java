package com.alkemy.Disney.APIChallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.Disney.APIChallenge.dto.GenreDTO;
import com.alkemy.Disney.APIChallenge.service.GenreService;

@RestController
@RequestMapping("genre")
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@PostMapping
	public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genreDto) {
		
		GenreDTO genreSaved = genreService.save(genreDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(genreSaved);
	}
}
