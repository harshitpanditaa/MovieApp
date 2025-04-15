package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Review;
import com.ncu.MovieApp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByMovieId(int movieId) {
        return reviewRepository.findByMovieId(movieId);
    }
}
