package com.ncu.MovieApp.controller;

import com.ncu.MovieApp.entities.Movie;
import com.ncu.MovieApp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public int saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @PutMapping
    public int updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public int deleteMovie(@PathVariable int id) {
        return movieService.deleteMovieById(id);
    }

    @GetMapping("/{id}")
    public Movie findMovie(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
