// RatingRepository.java
package Movie_ratings.Movie_ratings.repository;

import Movie_ratings.Movie_ratings.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
