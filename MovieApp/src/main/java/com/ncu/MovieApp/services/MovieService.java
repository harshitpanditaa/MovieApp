package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Movie;
import java.util.List;

public interface MovieService {
    int saveMovie(Movie movie);
    int updateMovie(Movie movie);
    int deleteMovie(int movieId);
    int deleteMovieById(int id);
    Movie getMovieById(int movieId);
    List<Movie> getAllMovies();
    int[] batchSaveMovies(List<Movie> movies);
    int[] updateMovies(List<Movie> movies);
    int[] deleteMovies(List<Integer> movieIds);
}
