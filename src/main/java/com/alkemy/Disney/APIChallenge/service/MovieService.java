package com.alkemy.Disney.APIChallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.Disney.APIChallenge.dto.MovieDTO;
import com.alkemy.Disney.APIChallenge.mapper.MovieMapper;
import com.alkemy.Disney.APIChallenge.models.MovieEntity;
import com.alkemy.Disney.APIChallenge.repository.MovieRepository;

@Service
public class MovieService {

	private MovieMapper movieMapper;
	private MovieRepository movieRepository;
	
	@Autowired
	public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
		this.movieMapper = movieMapper;
		this.movieRepository = movieRepository;
		
	}
	
	public MovieDTO save(MovieDTO dto) {
		MovieEntity entity = movieMapper.movieDto2Entity(dto);
		MovieEntity movieSaved = movieRepository.save(entity);
		MovieDTO result = movieMapper.movieEntity2Dto(movieSaved,true);
		
		return result;
	}
	
	public List<MovieDTO> getAllMovies() {
		
		List<MovieEntity> entity = movieRepository.findAll();
		List<MovieDTO> result = movieMapper.movieEntityList2DtoList(entity,false);
		
		return result;
	}

	public MovieDTO getMovieById(Integer movie_id) {

		Optional<MovieEntity> findEntity = movieRepository.findById(movie_id);
		MovieDTO result = null;
		if (findEntity.isPresent()) {
			MovieEntity entity = findEntity.get();
			result = movieMapper.movieEntity2Dto(entity, true);
		}

		return result;
	}

	public void delete(Integer movie_id) {
		movieRepository.deleteById(movie_id);
	}
}
