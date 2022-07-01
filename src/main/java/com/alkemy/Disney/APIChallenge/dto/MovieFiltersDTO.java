package com.alkemy.Disney.APIChallenge.dto;


public class MovieFiltersDTO {

    private String title;

    private Integer genre_id;

    private String order;

    public MovieFiltersDTO() {
    }

    public MovieFiltersDTO(String title, Integer genre_id, String order) {
        this.title = title;
        this.genre_id = genre_id;
        this.order = order;
    }

    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
