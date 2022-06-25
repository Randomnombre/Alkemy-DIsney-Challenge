package com.alkemy.Disney.APIChallenge.mapper;

import org.springframework.stereotype.Component;

import com.alkemy.Disney.APIChallenge.dto.GenreDTO;
import com.alkemy.Disney.APIChallenge.models.GenreEntity;

@Component
public class GenreMapper {

	public GenreEntity genreDTO2Entity(GenreDTO dto) {
		GenreEntity genreEntity = new GenreEntity();
		genreEntity.setName(dto.getName());
		genreEntity.setImage(dto.getImage());
		genreEntity.setMovie(dto.getMovie());
		
		return genreEntity;
	}
	
	public GenreDTO Entity2genreDTO(GenreEntity entity) {
		GenreDTO genreDTO = new GenreDTO();
		genreDTO.setGenre_id(entity.getGenre_id());
		genreDTO.setName(entity.getName());
		genreDTO.setImage(entity.getImage());
		genreDTO.setMovie(entity.getMovie());
		
		return genreDTO;
	}

	public GenreEntity genreDTO2EntityBasic(GenreDTO dto) {
		GenreEntity genreEntity = new GenreEntity();
		genreEntity.setName(dto.getName());

		return genreEntity;
	}

	public GenreDTO Entity2genreDTOBasic(GenreEntity entity) {
		GenreDTO genreDTO = new GenreDTO();
		genreDTO.setGenre_id(entity.getGenre_id());
		genreDTO.setName(entity.getName());

		return genreDTO;
	}
}
