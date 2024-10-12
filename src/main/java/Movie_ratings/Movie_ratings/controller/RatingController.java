// RatingController.java
package Movie_ratings.Movie_ratings.controller;

import Movie_ratings.Movie_ratings.model.Rating;
import Movie_ratings.Movie_ratings.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final MovieService movieService;

    public RatingController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<?> createRating(@RequestBody RatingRequest ratingRequest) {
        try {
            Rating createdRating = movieService.createRating(ratingRequest.getMovieId(), ratingRequest.getValue());
            return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

// Helper class for rating request
class RatingRequest {
    private Long movieId;
    private int value;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
