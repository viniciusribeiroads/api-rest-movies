package com.filmes.marvel.controller;

import com.filmes.marvel.model.Movie;
import com.filmes.marvel.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/all")
    public List<Movie> listAllMovies(){
        return movieService.listAll();
    }

    @PostMapping(path = "/new")
        public ResponseEntity<Movie> insertNew(@RequestBody Movie movie){
            return movieService.save(movie);
        }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Movie> deleteBy(@PathVariable Long id){
            return movieService.deleteBy(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Movie> update(@RequestBody Movie movie){
        return movieService.update(movie);
    }

}
