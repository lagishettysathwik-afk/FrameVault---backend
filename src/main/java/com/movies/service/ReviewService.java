package com.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movies.model.Movie;
import com.movies.model.Review;
import com.movies.repository.MovieRepository;
import com.movies.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = new Review();
        review.setBody(reviewBody);
        review.setImdbId(imdbId);
        Review savedReview = reviewRepository.save(review);

        // Link review to movie
        Optional<Movie> movie = movieRepository.findByImdbId(imdbId);
        movie.ifPresent(m -> {
            m.getReviews().add(savedReview);
            movieRepository.save(m);
        });

        return savedReview;
    }

    public List<Review> getReviewsByImdbId(String imdbId) {
        return reviewRepository.findByImdbId(imdbId);
    }
}