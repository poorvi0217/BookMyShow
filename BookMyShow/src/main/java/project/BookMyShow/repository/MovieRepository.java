package project.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.BookMyShow.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie , Long> {

    List<Movie> findByActiveTrueOrderByTitle();

    Optional<Movie> findByTitle(String title);

}
