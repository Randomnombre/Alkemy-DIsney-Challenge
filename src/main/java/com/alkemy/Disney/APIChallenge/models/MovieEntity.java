package com.alkemy.Disney.APIChallenge.models;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer movie_id;
	
	private String image;
	private String title;
	private Date dateOfCreation;
	private Double rating;
	
	@ManyToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(
			name = "characters_movies",
			joinColumns = @JoinColumn(name = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<CharacterEntity> characters = new HashSet<>();
	
	public MovieEntity() {
		
	}

	public MovieEntity(Integer movie_id, String image, String title, Date dateOfCreation, Double rating,
			Set<CharacterEntity> characters) {
		super();
		this.movie_id = movie_id;
		this.image = image;
		this.title = title;
		this.dateOfCreation = dateOfCreation;
		this.rating = rating;
		this.characters = characters;
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

	public Set<CharacterEntity> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<CharacterEntity> characters) {
		this.characters = characters;
	}
	
	
}
