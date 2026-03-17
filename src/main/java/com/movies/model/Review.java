package com.movies.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;
    private String imdbId;

    // Constructors
    public Review() {}

    public Review(Long id, String body, String imdbId) {
        this.id = id;
        this.body = body;
        this.imdbId = imdbId;
    }

    // Getters
    public Long getId() { return id; }
    public String getBody() { return body; }
    public String getImdbId() { return imdbId; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setBody(String body) { this.body = body; }
    public void setImdbId(String imdbId) { this.imdbId = imdbId; }
}