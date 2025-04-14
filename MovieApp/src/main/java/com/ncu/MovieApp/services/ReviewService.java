package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Review;
import java.util.List;

public interface ReviewService {
    Review addReview(Review review);
    List<Review> getReviewsByMovieId(int movieId);
    List<Review> getAllReviews();
}
