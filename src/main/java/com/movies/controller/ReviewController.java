package com.movies.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.movies.model.Review;
import com.movies.service.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://framevault-frontend.onrender.com"
})

public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(
                reviewService.createReview(
                        payload.get("reviewBody"),
                        payload.get("imdbId")),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<List<Review>> getReviews(@PathVariable String imdbId) {
        return new ResponseEntity<>(
                reviewService.getReviewsByImdbId(imdbId),
                HttpStatus.OK
        );
    }
}