package com.ncu.MovieApp.controller;

import com.ncu.MovieApp.entities.Review;
import com.ncu.MovieApp.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/movie/{movieId}")
    public List<Review> getReviewsByMovie(@PathVariable int movieId) {
        return reviewService.getReviewsByMovieId(movieId);
    }
}
