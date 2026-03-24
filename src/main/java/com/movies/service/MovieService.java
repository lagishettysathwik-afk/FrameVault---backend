package com.movies.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movies.model.Movie;
import com.movies.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }
 // ADD these two methods to your existing MovieService

    public List<Movie> getMoviesByLanguage(String language) {
        return movieRepository.findByLanguage(language);
    }

    public List<String> getAllLanguages() {
        return movieRepository.findDistinctLanguages();
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
	}
