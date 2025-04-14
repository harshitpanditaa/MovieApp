package com.ncu.MovieApp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review() {}

    public Review(String comment, int rating, Movie movie) {
        this.comment = comment;
        this.rating = rating;
        this.movie = movie;
    }

    public Integer getReviewId() { return reviewId; }
    public void setReviewId(Integer reviewId) { this.reviewId = reviewId; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
}

