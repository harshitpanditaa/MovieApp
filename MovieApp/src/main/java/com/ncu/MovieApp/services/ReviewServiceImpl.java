package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Review;
import com.ncu.MovieApp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review review) {
        reviewRepository.save(review);
        return review;
    }

    @Override
    public List<Review> getReviewsByMovieId(int movieId) {
        return reviewRepository.findByMovieMovieId(movieId);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
