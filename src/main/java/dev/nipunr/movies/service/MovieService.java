package dev.nipunr.movies.service;

import dev.nipunr.movies.db.models.Movie;
import dev.nipunr.movies.db.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> findMovieByImdbId(String id) {
        return movieRepository.findMovieByImdbId(id);
    }
}