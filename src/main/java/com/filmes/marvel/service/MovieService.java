package com.filmes.marvel.service;

import com.filmes.marvel.model.Movie;
import com.filmes.marvel.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    final private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    public ResponseEntity<Movie> save(Movie movie) {
        return ResponseEntity.ok(movieRepository.save(movie));
    }

    public ResponseEntity deleteBy(Long id) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movieRepository.delete(movie);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Movie> update(Movie movie) {
        return ResponseEntity.ok(movieRepository.save(movie));
    }

}
