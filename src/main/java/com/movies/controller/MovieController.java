package com.movies.controller;

import com.movies.model.Movie;
import com.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // ✅ GET ALL MOVIES
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // ✅ ADD THIS (POST API)
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
}