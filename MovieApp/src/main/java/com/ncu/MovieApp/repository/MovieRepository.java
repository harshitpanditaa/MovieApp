package com.ncu.MovieApp.repository;

import com.ncu.MovieApp.entities.Movie;
import java.util.List;

public interface MovieRepository {
    int save(Movie movie);
    int update(Movie movie);
    int deleteById(int movieId);
    Movie findById(int movieId);
    List<Movie> findAll();
    int[] batchSaveMovies(List<Movie> movies);
    int[] updateMovies(List<Movie> movies);
    int[] deleteMovies(List<Integer> movieIds);
}
