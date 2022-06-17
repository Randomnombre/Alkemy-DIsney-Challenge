package com.alkemy.Disney.APIChallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.Disney.APIChallenge.dto.GenreDTO;
import com.alkemy.Disney.APIChallenge.mapper.GenreMapper;
import com.alkemy.Disney.APIChallenge.models.GenreEntity;
import com.alkemy.Disney.APIChallenge.repository.GenreRepository;

@Service
public class GenreService {

	private GenreMapper genreMapper;

	private GenreRepository genreRepository;
	
	@Autowired
	public GenreService(GenreMapper genreMapper, GenreRepository genreRepository) {
		this.genreMapper = genreMapper;
		this.genreRepository = genreRepository;
	}
	
	public GenreDTO save(GenreDTO dto) {
		
		GenreEntity entity = genreMapper.genreDTO2Entity(dto);
		GenreEntity entitySaved = genreRepository.save(entity);
		GenreDTO result = genreMapper.Entity2genreDTO(entitySaved);
		
		return result;
	}
}
