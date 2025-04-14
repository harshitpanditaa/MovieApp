package com.ncu.MovieApp.repository;

import com.ncu.MovieApp.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByMovieMovieId(int movieId);
}
