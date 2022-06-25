package com.alkemy.Disney.APIChallenge.dto;

import com.alkemy.Disney.APIChallenge.models.MovieEntity;

public class GenreDTO {

	private Integer genre_id;
	private String name;
	private String image;
	private MovieEntity movie;

	public GenreDTO() {}

	public GenreDTO(String name) {
		this.name = name;
	}

	public GenreDTO(Integer genre_id, String name, String image, MovieEntity movie) {
		this.genre_id = genre_id;
		this.name = name;
		this.image = image;
		this.movie = movie;
	}

	public Integer getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(Integer genre_id) {
		this.genre_id = genre_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MovieEntity getMovie() {
		return movie;
	}
	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	
}
