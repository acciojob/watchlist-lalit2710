package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {

    HashMap<String, Movie> movies = new HashMap<>();
    List<Movie>getallmovies(){
        List<Movie>movieList = new ArrayList<>();
        for(Movie movie:movies.values()){
            movieList.add(movie);
        }
        return movieList;
    }
    HashMap<String,Director> directorname = new HashMap<>();
    List<Director> getalldirectors(){
        List<Director>directorList = new ArrayList<>();
        for(Director director:directorname.values()){
            directorList.add(director);
        }
        return directorList;
    }
    HashMap<String, List<Movie>> directormoviepair = new HashMap<>();
}
