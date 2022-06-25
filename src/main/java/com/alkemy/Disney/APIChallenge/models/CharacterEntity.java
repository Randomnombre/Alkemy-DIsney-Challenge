package com.alkemy.Disney.APIChallenge.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE character_entity SET deleted = true WHERE character_id=?")
@Where(clause = "deleted=false")
public class CharacterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer character_id;
	
	private String image;
	private String name;
	private Integer age;
	private Double weight;
	private String story;
	private boolean deleted = Boolean.FALSE;
	
	@ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
	private List<MovieEntity> movies = new ArrayList<>();
	
	public CharacterEntity() {
		
	}

	public CharacterEntity(Integer character_id, String image, String name, Integer age, Double weight, String story, boolean deleted,
			List<MovieEntity> movies) {
		super();
		this.character_id = character_id;
		this.image = image;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.story = story;
		this.deleted = deleted;
		this.movies = movies;
	}

	public Integer getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(Integer character_id) {
		this.character_id = character_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	};
	
	
	
}
 