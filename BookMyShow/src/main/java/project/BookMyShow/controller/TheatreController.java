package project.BookMyShow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.BookMyShow.dto.TheatreResponse;
import project.BookMyShow.service.CatalogService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theatres")
public class TheatreController {

    private final CatalogService catalogService;


    public TheatreController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<TheatreResponse> theatres(@RequestParam String city)
    {
        return catalogService.theatres(city);
    }
}
