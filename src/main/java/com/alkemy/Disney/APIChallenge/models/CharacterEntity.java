package com.alkemy.Disney.APIChallenge.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class CharacterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer character_id;
	
	private String image;
	private String name;
	private Integer age;
	private Double weight;
	private String story;
	
	@ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
	private Set<MovieEntity> movies = new HashSet<>();
	
	public CharacterEntity() {
		
	}

	public CharacterEntity(Integer character_id, String image, String name, Integer age, Double weight, String story,
			Set<MovieEntity> movies) {
		super();
		this.character_id = character_id;
		this.image = image;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.story = story;
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

	public Set<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(Set<MovieEntity> movies) {
		this.movies = movies;
	};
	
	
	
}
 