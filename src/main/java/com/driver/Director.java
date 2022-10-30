package com.driver;

public class Director {
    private int id;
    private String name;
    private int nuberOfMovies;
    double imdbRating;

    public Director(int id, String name, int nuberOfMovies, double imdbRating) {
        this.id = id;
        this.name = name;
        this.nuberOfMovies = nuberOfMovies;
        this.imdbRating = imdbRating;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getNuberOfMovies() {

        return nuberOfMovies;
    }

    public void setNuberOfMovies(int nuberOfMovies) {

        this.nuberOfMovies = nuberOfMovies;
    }

    public double getImdbRating() {

        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {

        this.imdbRating = imdbRating;
    }
}
//        Director.java Class - String name, int numberOfMovies, double imdbRating,
//        no-args constructor, all-args constructor and getters-setters