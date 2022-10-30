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
    HashMap<Integer, Movie> movies = new HashMap<>();
    HashMap<Integer,Director> directorname = new HashMap<>();

    HashMap<Director,List<Movie>> directormoviepair = new HashMap<>();

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity <List<Movie>> getAllMovies() {

        List<Movie> listofMovie = new ArrayList<>();
        for (Movie movie : movies.values()) {
            listofMovie.add(movie);

//        for(Map.Entry<Integer,Movie> entry: movies.entrySet()){
//            listofMovie.add(entry.getValue());
        }
        return new ResponseEntity<>(listofMovie, HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity <List<Director>> getAllDirector() {

        List<Director> listofDirector = new ArrayList<>();
        for (Director director : directorname.values()) {
            listofDirector.add(director);
        }
        return new ResponseEntity<>(listofDirector, HttpStatus.OK);
    }

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie){
        movies.put(movie.getId(),movie);
        return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody()Director director){
        directorname.put(director.getId(),director);
        return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED);
    }
//    @PutMapping("/add-movie-director-pair")
//    public ResponseEntity addMovieDirectorPair (@RequestParam String moviename,@RequestParam String directorname){
//        directormoviepair.put();
//    }


}
