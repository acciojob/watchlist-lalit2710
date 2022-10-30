package com.driver;

public class Director {
    private String name;
    private int nuberOfMovies;
    double imdbRating;

    public Director(String name, int nuberOfMovies, double imdbRating) {
        this.name = name;
        this.nuberOfMovies = nuberOfMovies;
        this.imdbRating = imdbRating;
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