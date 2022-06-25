package com.alkemy.Disney.APIChallenge.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer movie_id;
	
	private String image;
	private String title;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfCreation;
	
	private Double rating;
	private boolean deleted = Boolean.FALSE;
	
	@ManyToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(
			name = "characters_movies",
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "character_id"))
	private List<CharacterEntity> characters = new ArrayList<>();
	
	public MovieEntity() {
		
	}

	public MovieEntity(Integer movie_id, String image, String title, Date dateOfCreation, Double rating, boolean deleted,
			List<CharacterEntity> characters) {
		super();
		this.movie_id = movie_id;
		this.image = image;
		this.title = title;
		this.dateOfCreation = dateOfCreation;
		this.rating = rating;
		this.deleted = deleted;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public List<CharacterEntity> getCharacters() {
		return characters;
	}

	public void setCharacters(List<CharacterEntity> characters) {
		this.characters = characters;
	}
}
