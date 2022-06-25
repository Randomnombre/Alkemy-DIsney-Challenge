package com.alkemy.Disney.APIChallenge.dto;

import java.util.List;


public class CharacterDTO {

	private Integer character_id;
	private String image;
	private String name;
	private Integer age;
	private Double weight;
	private String story;
	private List<MovieDTO> movies;
	
	
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
	public List<MovieDTO> getMovies() {
		return movies;
	}
	public void setMovies(List<MovieDTO> movies) {
		this.movies = movies;
	}
	
}
