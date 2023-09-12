package dev.nipunr.movies.controller;

import dev.nipunr.movies.db.models.Review;
import dev.nipunr.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://main--super-llama-3d0b55.netlify.app/"})
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reivewService;

    @PostMapping("/")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reivewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }
}
