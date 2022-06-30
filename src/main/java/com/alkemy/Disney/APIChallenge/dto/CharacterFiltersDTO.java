package com.alkemy.Disney.APIChallenge.dto;


import java.util.List;

public class CharacterFiltersDTO {

    private String name;
    private Integer age;
    private Double weight;
    private List<Integer> movies;

    public CharacterFiltersDTO() {
    }

    public CharacterFiltersDTO(String name, Integer age, Double weight, List<Integer> movies) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
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

    public List<Integer> getMovies() {
        return movies;
    }

    public void setMovies(List<Integer> movies) {
        this.movies = movies;
    }
}
