package Movie_ratings.Movie_ratings.service;

import Movie_ratings.Movie_ratings.model.Movie;
import Movie_ratings.Movie_ratings.model.Rating;
import Movie_ratings.Movie_ratings.repository.MovieRepository;
import Movie_ratings.Movie_ratings.repository.RatingRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;

    public RatingService(RatingRepository ratingRepository, MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
    }

    public Rating createRating(Long movieId, int value) throws Exception {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new Exception("Movie not found"));

        if (value < 1 || value > 5) {
            throw new Exception("Invalid rating value");
        }

        Rating rating = new Rating();
        rating.setMovie(movie);
        rating.setValue(value);
        return ratingRepository.save(rating);
    }
}
