package com.firstapp.filmapp.objects;

public class Filmler {
    private int film_id;
    private String film_name;
    private int film_year;
    private String film_image;
    private Categories category;
    private Directors director;

    public Filmler() {
    }

    public Filmler(int film_id, String film_name, int film_year, String film_image, Categories category, Directors director) {
        this.film_id = film_id;
        this.film_name = film_name;
        this.film_year = film_year;
        this.film_image = film_image;
        this.category = category;
        this.director = director;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public int getFilm_year() {
        return film_year;
    }

    public void setFilm_year(int film_year) {
        this.film_year = film_year;
    }

    public String getFilm_image() {
        return film_image;
    }

    public void setFilm_image(String film_image) {
        this.film_image = film_image;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Directors getDirector() {
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }
}
