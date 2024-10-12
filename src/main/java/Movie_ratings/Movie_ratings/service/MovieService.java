package Movie_ratings.Movie_ratings.service;

import Movie_ratings.Movie_ratings.model.Movie;
import Movie_ratings.Movie_ratings.model.Rating;
import Movie_ratings.Movie_ratings.repository.MovieRepository;
import Movie_ratings.Movie_ratings.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final RatingRepository ratingRepository;

    public MovieService(MovieRepository movieRepository, RatingRepository ratingRepository) {
        this.movieRepository = movieRepository;
        this.ratingRepository = ratingRepository;
    }

    public Rating createRating(Long movieId, int value) throws Exception {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new Exception("Movie not found"));

        if (value < 1 || value > 5) {
            throw new Exception("Invalid rating value");
        }

        Rating rating = new Rating();
        rating.setMovie(movie);  // Set the movie object here
        rating.setValue(value);
        ratingRepository.save(rating);

        // Update movie average rating
        movie.setRating(calculateAverageRating(movie));
        movieRepository.save(movie);

        return rating;
    }

    public Float calculateAverageRating(Movie movie) {
        List<Rating> ratings = movie.getRatings();
        if (ratings.isEmpty()) {
            return null;
        }
        float sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getValue();
        }
        return sum / ratings.size();
    }

    public Movie createMovie(String title) {
        return null;
    }

    public Optional<Movie> getMovie(Long id) {
        return Optional.empty();
    }

    public List<Movie> getAllMovies() {
        return List.of();
    }

    public void deleteMovie(Long id) {
    }
}