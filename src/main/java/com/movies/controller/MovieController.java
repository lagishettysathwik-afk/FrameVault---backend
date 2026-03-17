package com.movies.controller;

import com.movies.model.Movie;
import com.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "https://framevault-frontend.onrender.com")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // GET all movies
    // http://localhost:8080/api/v1/movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    // GET single movie by imdbId
    // http://localhost:8080/api/v1/movies/{imdbId}
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
 // ADD these two endpoints to your existing MovieController

 // Get movies by language - GET /api/movies/language/Telugu
 @GetMapping("/language/{language}")
 public ResponseEntity<List<Movie>> getMoviesByLanguage(@PathVariable String language) {
     List<Movie> movies = movieService.getMoviesByLanguage(language);
     return ResponseEntity.ok(movies);
 }

 // Get all available languages - GET /api/movies/languages
 @GetMapping("/languages")
 public ResponseEntity<List<String>> getAllLanguages() {
     List<String> languages = movieService.getAllLanguages();
     return ResponseEntity.ok(languages);
 }
}