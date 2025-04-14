package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Movie;
import com.ncu.MovieApp.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public int saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public int updateMovie(Movie movie) {
        return movieRepository.update(movie);
    }

    @Override
    public int deleteMovie(int movieId) {
        return movieRepository.deleteById(movieId);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public int[] batchSaveMovies(List<Movie> movies) {
        return movieRepository.batchSaveMovies(movies);
    }

    @Override
    public int[] updateMovies(List<Movie> movies) {
        return movieRepository.updateMovies(movies);
    }

    @Override
    public int[] deleteMovies(List<Integer> movieIds) {
        return movieRepository.deleteMovies(movieIds);
    }
    @Override
    public int deleteMovieById(int id) {
        return movieRepository.deleteById(id);
    }

}
