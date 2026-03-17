package com.movies.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private String genre;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> backdrops;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getImdbId() { return imdbId; }
    public void setImdbId(String imdbId) { this.imdbId = imdbId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public String getTrailerLink() { return trailerLink; }
    public void setTrailerLink(String trailerLink) { this.trailerLink = trailerLink; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public List<String> getBackdrops() { return backdrops; }
    public void setBackdrops(List<String> backdrops) { this.backdrops = backdrops; }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
 // Add this field to your existing Movie.java model
    @Column(name = "language")
    private String language;

    // Add getter and setter
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}