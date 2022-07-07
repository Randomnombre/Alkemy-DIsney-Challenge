package com.alkemy.Disney.APIChallenge.dto;

import java.util.Date;
import java.util.List;



public class MovieDTO {

	private Integer movie_id;
	private String image;
	private String title;
	private Date dateOfCreation;
	private Double rating;
	private List<CharacterDTO> characters;

	private GenreDTO genreDTO;
	
	public MovieDTO(){}

	public MovieDTO(Integer movie_id, String image, String title, Date dateOfCreation, Double rating, List<CharacterDTO> characters, GenreDTO genreDTO) {
		this.movie_id = movie_id;
		this.image = image;
		this.title = title;
		this.dateOfCreation = dateOfCreation;
		this.rating = rating;
		this.characters = characters;
		this.genreDTO = genreDTO;
	}

	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public List<CharacterDTO> getCharacters() {
		return characters;
	}
	public void setCharacters(List<CharacterDTO> characters) {
		this.characters = characters;
	}

	public GenreDTO getGenreDTO() {
		return genreDTO;
	}

	public void setGenreDTO(GenreDTO genreDTO) {
		this.genreDTO = genreDTO;
	}
}
