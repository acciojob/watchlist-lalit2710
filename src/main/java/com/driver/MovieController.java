package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @GetMapping("/get-all-movies")
    public ResponseEntity getAllMovies() {
        List movieList = movieService.getAllMovies();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }
    @GetMapping("/get-all-directors")
    public ResponseEntity getAllDirector() {
        List directorList = movieService.getalldirectors();
        return new ResponseEntity<>(directorList, HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity findDirectorByName(@PathVariable("name")String directorName){
            Director mov = movieService.findDirectorByName(directorName);
            return new ResponseEntity<>(mov, HttpStatus.OK);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity findMovieByName(@PathVariable("name")String movieName){
            Movie mov = movieService.findMovieByName(movieName);
            return new ResponseEntity<>(mov, HttpStatus.OK);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
            List movies = movieService.findMoviesByDirectorName(director);
            return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity("Success", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity("Success", HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        boolean check = movieService.addDirectorandMoviePair(movieName,directorName);
        if(!check){
            return new ResponseEntity<>("Check movie and director name", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String name){
            movieService.deleteDirectorByName(name);
            return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){

        movieService.deleteAllDirectors();
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
