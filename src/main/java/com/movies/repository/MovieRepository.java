package com.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.movies.model.Movie;

import java.util.Optional;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Find movie by IMDB ID
    Optional<Movie> findByImdbId(String imdbId);

    // Find movies by language
    List<Movie> findByLanguage(String language);

    // Find all distinct languages
    @Query("SELECT DISTINCT m.language FROM Movie m WHERE m.language IS NOT NULL")
    List<String> findDistinctLanguages();
}