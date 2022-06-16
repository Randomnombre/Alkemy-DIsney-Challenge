package com.alkemy.Disney.APIChallenge.dto;

import java.util.Date;
import java.util.Set;

import com.alkemy.Disney.APIChallenge.models.CharacterEntity;

public class MovieDTO {

	private Integer movie_id;
	private String image;
	private String title;
	private Date dateOfCreation;
	private Double rating;
	private Set<CharacterEntity> characters;
	
	
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
	public Set<CharacterEntity> getCharacters() {
		return characters;
	}
	public void setCharacters(Set<CharacterEntity> characters) {
		this.characters = characters;
	}
	
	
}
