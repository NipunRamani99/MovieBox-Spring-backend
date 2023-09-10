package dev.nipunr.movies.controller;
import com.mongodb.client.MongoClient;
import dev.nipunr.movies.db.models.Movie;
import dev.nipunr.movies.service.MovieService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
@Log
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MongoClient mongoClient;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies() {
        for(String s : mongoClient.listDatabaseNames())
            log.log(Level.INFO,s);
        List<Movie> allMovies = movieService.getAllMovies();
        return ResponseEntity.ok(allMovies );
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return ResponseEntity.ok(movieService.findMovieByImdbId(imdbId));
    }
}
