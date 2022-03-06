package com.example.demosolr.rest;

import static com.example.demosolr.model.Genre.ACTION;
import static com.example.demosolr.model.Genre.COMEDY;
import static com.example.demosolr.model.Genre.THRILLER;
import static com.example.demosolr.model.Genre.getInstance;
import static java.time.LocalDate.now;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.demosolr.model.Genre;
import com.example.demosolr.model.Movie;
import com.example.demosolr.repository.solr.SolrMovieRepository;
import com.example.demosolr.rest.dto.MovieDTO;
import com.example.demosolr.rest.dto.MoviesWrapperDTO;
import com.example.demosolr.service.MovieService;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

  private final MovieService movieService;

  @GetMapping("/all")
  public Iterable<Movie> getAll() {
    return movieService.findAll();
  }

  @GetMapping("/add")
  public String addMovies() {
    movieService.saveMockMovies();
    return "OK";
  }

  @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
  public String importMovies(@RequestBody MoviesWrapperDTO wrapperDTO) {
    movieService.importMovies(wrapperDTO);
    return "Added";
  }
}
