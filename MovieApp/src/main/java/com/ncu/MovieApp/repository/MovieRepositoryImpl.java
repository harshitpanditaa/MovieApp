package com.ncu.MovieApp.repository;

import com.ncu.MovieApp.entities.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final SessionFactory sessionFactory;

    public MovieRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int save(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(movie);
            tx.commit();
            return 1;
        }
    }

    @Override
    public int update(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(movie);
            tx.commit();
            return 1;
        }
    }

    @Override
    public int deleteById(int movieId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Movie movie = session.get(Movie.class, movieId);
            if (movie != null) {
                session.remove(movie);
                tx.commit();
                return 1;
            }
            return 0;
        }
    }

    @Override
    public Movie findById(int movieId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Movie.class, movieId);
        }
    }

    @Override
    public List<Movie> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Movie", Movie.class).list();
        }
    }

    @Override
    public int[] batchSaveMovies(List<Movie> movies) {
        int[] results = new int[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            results[i] = save(movies.get(i));
        }
        return results;
    }

    @Override
    public int[] updateMovies(List<Movie> movies) {
        int[] results = new int[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            results[i] = update(movies.get(i));
        }
        return results;
    }

    @Override
    public int[] deleteMovies(List<Integer> movieIds) {
        int[] results = new int[movieIds.size()];
        for (int i = 0; i < movieIds.size(); i++) {
            results[i] = deleteById(movieIds.get(i));
        }
        return results;
    }
}
