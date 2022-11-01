package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class MovieRepository {
    HashMap<String, Movie> movies = new HashMap<>();
    public void addMovie(Movie movie){
        movies.put(movie.getName(), movie);
    }
    public Movie findMovieByName(String movieName){
        if(movies.containsKey(movieName)){
            return movies.get(movieName);
        }
        return null;
    }
    List<Movie>getallmovies(){
        List<Movie>movieList = new ArrayList<>();
        for(Movie movie:movies.values()){
            movieList.add(movie);
        }
        return movieList;
    }
    HashMap<String,Director> directorname = new HashMap<>();
    public void addDirector(Director director){
        directorname.put(director.getName(), director);
    }
    List<Director> getalldirectors(){
        List<Director>directorList = new ArrayList<>();
        for(Director director:directorname.values()){
            directorList.add(director);
        }
        return directorList;
    }
    public Director findDirectorByName(String directorName){

        if(directorname.containsKey(directorName)){
            return directorname.get(directorName);
        }
        return null;
    }
    HashMap<String, List<Movie>> directormoviepair = new HashMap<>();
    public boolean addDirectorandMoviePair(String movieName, String directorName){
        boolean m = false;
        for(Movie movie : movies.values()){
            if(movie.getName().equals(movieName)){
                m = true;
            }
        }
        boolean d = false;

        for(Director director : directorname.values()){
            if(director.getName().equals(directorName)){
                d = true;
            }
        }
        if(!m ||!d){
            return false;
        }
        if(directormoviepair.containsKey(directorName)){
            directormoviepair.get(directorName).add(movies.get(movieName));
        }else{
            directormoviepair.put(directorName, new ArrayList<>());
            directormoviepair.get(directorName).add(movies.get(movieName));
        }
        return true;
    }
    public void deleteDirectorByName(String director){
        List<Movie> movieList;
        if(directormoviepair.containsKey(director)){
            movieList = directormoviepair.get(director);
        }else{
            movieList = new ArrayList<>();
        }

        for(int i=0; i<movieList.size(); i++){
            if(movies.containsKey(movieList.get(i).getName())){
                movies.remove(movieList.get(i).getName());
            }
        }

        if(directorname.containsKey(director)){
            directorname.remove(director);
        }

        if(directormoviepair.containsKey(director)){
            directormoviepair.remove(director);
        }
    }
    public void deleteAllDirector(){
        List<String> allDirector = new ArrayList<>();

        for(String dir : directorname.keySet()){
            allDirector.add(dir);
        }

        for(int i=0; i<allDirector.size(); i++){
            deleteDirectorByName(allDirector.get(i));
        }
    }
    public List<Movie> findMoviesByDirectorName(String directorName){
        if(directormoviepair.containsKey(directorName)){
            return directormoviepair.get(directorName);
        }
        return new ArrayList<>();
    }
}
