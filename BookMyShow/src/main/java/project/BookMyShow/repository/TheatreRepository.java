package project.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.BookMyShow.entity.Theatre;

import java.util.List;
import java.util.Optional;

public interface TheatreRepository extends JpaRepository<Theatre , Long> {
    List<Theatre> findByIdIgnoreCaseOrderByName(String city);

    Optional<Theatre> findByNameAndCity(String name , String city);
}
