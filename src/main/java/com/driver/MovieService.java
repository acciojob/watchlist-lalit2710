package com.driver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }
    public List<Movie> getAllMovies(){
        return movieRepository.getallmovies();
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public List<Director> getalldirectors(){
        return movieRepository.getalldirectors();
    }
    public Movie findMovieByName(String movieName){
        return movieRepository.findMovieByName(movieName);
    }
    public Director findDirectorByName(String directorName){
        return movieRepository.findDirectorByName(directorName);
    }
    public boolean addDirectorandMoviePair(String movieName, String directorName){
        return movieRepository.addDirectorandMoviePair(movieName, directorName);
    }
    public List<Movie> findMoviesByDirectorName(String directorName){
        return movieRepository.findMoviesByDirectorName(directorName);
    }
    public void deleteDirectorByName(String director){
        movieRepository.deleteDirectorByName(director);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }
}