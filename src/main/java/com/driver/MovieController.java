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
    HashMap<String, Movie> movies = new HashMap<>();
    HashMap<String,Director> directorname = new HashMap<>();

    HashMap<String,List<Movie>> directormoviepair = new HashMap<>();

    @GetMapping("/get-all-movies")
    public ResponseEntity <List<Movie>> findAllMovies() {

        List<Movie> listofMovie = new ArrayList<>();
        for (Movie movie : movies.values()) {
            listofMovie.add(movie);

//        for(Map.Entry<Integer,Movie> entry: movies.entrySet()){
//            listofMovie.add(entry.getValue());
        }
        return new ResponseEntity<>(listofMovie, HttpStatus.OK);
    }
    @GetMapping("/get-director")
    public ResponseEntity <List<Director>> getAllDirector() {

        List<Director> listofDirector = new ArrayList<>();
        for (Director director : directorname.values()) {
            listofDirector.add(director);
        }
        return new ResponseEntity<>(listofDirector, HttpStatus.OK);
    }

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie){
        movies.put(movie.getName(),movie);
        return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody()Director director){
        directorname.put(director.getName(),director);
        return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair (@RequestParam String moviename,@RequestParam String directorname){
        if(directormoviepair.containsKey(directorname)){
            directormoviepair.get(directorname).add(movies.get(moviename));
        }else {
         directormoviepair.put(directorname,new ArrayList<>());
            directormoviepair.get(directorname).add(movies.get(moviename));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
