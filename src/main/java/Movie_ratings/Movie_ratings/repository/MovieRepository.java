// MovieRepository.java
package Movie_ratings.Movie_ratings.repository;

import Movie_ratings.Movie_ratings.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
