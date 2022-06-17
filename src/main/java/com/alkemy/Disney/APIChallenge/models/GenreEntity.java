package com.alkemy.Disney.APIChallenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GenreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer genre_id;
	
	private String name;
	private String image;
	private boolean deleted = Boolean.FALSE;
	
	@OneToOne
	private MovieEntity movie;

	public GenreEntity() {
		
	}

	public GenreEntity(Integer genre_id, String name, String image, boolean deleted, MovieEntity movie) {
		super();
		this.genre_id = genre_id;
		this.name = name;
		this.image = image;
		this.deleted = deleted;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}
	
	
}
