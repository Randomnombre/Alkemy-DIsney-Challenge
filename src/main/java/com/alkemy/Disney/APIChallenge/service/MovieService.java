package com.alkemy.Disney.APIChallenge.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.Disney.APIChallenge.dto.MovieFiltersDTO;
import com.alkemy.Disney.APIChallenge.repository.specifications.MovieSpecification;
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

	private MovieSpecification movieSpecification;
	
	@Autowired
	public MovieService(MovieMapper movieMapper, MovieRepository movieRepository,MovieSpecification movieSpecification) {
		this.movieMapper = movieMapper;
		this.movieRepository = movieRepository;
		this.movieSpecification = movieSpecification;
		
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

	public MovieDTO update(Integer movie_id, MovieDTO dto) {

		Optional<MovieEntity> findEntity = movieRepository.findById(movie_id);
		MovieEntity entityToUpdate = null;
		if (findEntity.isPresent()) {
			entityToUpdate = findEntity.get();
		}

		MovieEntity entity = movieMapper.movieDto2EntityUpdated(dto, entityToUpdate);
		MovieEntity movieSaved = movieRepository.save(entity);
		MovieDTO result = movieMapper.movieEntity2Dto(movieSaved, false);

		return result;
	}

	public List<MovieDTO> getByFilters(String title, Integer genre_id, String order) {

		MovieFiltersDTO filtersDTO = new MovieFiltersDTO(title, genre_id, order);
		List<MovieEntity> entities = this.movieRepository.findAll(this.movieSpecification.getByFilters(filtersDTO));
		List<MovieDTO> result = this.movieMapper.movieEntityList2DtoList(entities, true);

		return result;
	}
}

