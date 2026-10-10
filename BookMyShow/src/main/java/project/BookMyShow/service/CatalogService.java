package project.BookMyShow.service;

import org.springframework.stereotype.Service;
import project.BookMyShow.dto.MovieResponse;
import project.BookMyShow.dto.ShowResponse;
import project.BookMyShow.dto.TheatreResponse;
import project.BookMyShow.entity.Movie;
import project.BookMyShow.repository.MovieRepository;
import project.BookMyShow.repository.ShowRepository;
import project.BookMyShow.repository.ShowSeatRepository;
import project.BookMyShow.repository.TheatreRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CatalogService {

    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;

    public CatalogService(MovieRepository movieRepository, TheatreRepository theatreRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository) {
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public List<MovieResponse> movies(){
        return  movieRepository.findByActiveTrueOrderByTitle().stream().map(MovieResponse::from).toList();
    }

    public List<TheatreResponse> theatres(String city){
        return theatreRepository.findByIdIgnoreCaseOrderByName(city).stream().map(TheatreResponse::from).toList();
    }

    public List<ShowResponse> shows(String city , LocalDate date){
        LocalDateTime from = date.atStartOfDay();
        return showRepository.findActiveShows(city, from, from.plusDays(1)).stream().map(show-> ShowResponse.from(show,showSeatRepository.findAvailableLabels(show.getId()))).toList();
    }

}
