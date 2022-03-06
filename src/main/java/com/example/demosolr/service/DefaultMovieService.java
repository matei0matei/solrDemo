package com.example.demosolr.service;

import static com.example.demosolr.model.Genre.ACTION;
import static com.example.demosolr.model.Genre.COMEDY;
import static com.example.demosolr.model.Genre.THRILLER;
import static com.example.demosolr.model.Genre.getInstance;
import static io.netty.util.internal.StringUtil.EMPTY_STRING;
import static java.time.LocalDate.now;
import static java.util.List.of;
import static java.util.logging.Logger.getLogger;
import static java.util.stream.Collectors.toList;

import com.example.demosolr.model.Movie;
import com.example.demosolr.repository.solr.SolrMovieRepository;
import com.example.demosolr.rest.dto.MovieDTO;
import com.example.demosolr.rest.dto.MoviesWrapperDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class DefaultMovieService implements MovieService {

  private static final Logger log = getLogger(DefaultMovieService.class.getName());

  private final SolrMovieRepository solrMovieRepository;

  @Override
  public Iterable<Movie> findAll() {
    return solrMovieRepository.findAll();
  }

  @Override
  public void saveMockMovies() {
    Movie movie1 = new Movie(1L, "Movie 1 title", "Movie 1 description", ACTION, now(), 8.8);
    Movie movie2 = new Movie(2L, "Movie 2 title", "Movie 2 description", COMEDY, now(), 7.8);
    Movie movie3 = new Movie(3L, "Movie 3 title", "Movie 3 description", THRILLER, now(), 9.8);

    solrMovieRepository.save(movie1);
    solrMovieRepository.save(movie2);
    solrMovieRepository.save(movie3);
  }

  @Override
  public void importMovies(MoviesWrapperDTO wrapperDTO) {
    for (MovieDTO movie : wrapperDTO.getMovieDTOList()) {
      solrMovieRepository.save(getMovie(movie));
    }
  }

  @Override
  public List<MovieDTO> search(String query) {
    log.info("Searching for: " + query);
    return solrMovieRepository
        .findAllByDescriptionContainsOrTitleContains(query, query)
        .stream().map(this::getMovieDTO)
        .collect(toList());
  }

  private Movie getMovie(MovieDTO movie) {
    return new Movie(movie.getId(), movie.getTitle(), movie.getPlot(), getInstance(movie.getGenres().get(0).toUpperCase()),
                     LocalDate.ofYearDay(movie.getYear(), 1), 10);
  }

  private MovieDTO getMovieDTO(Movie movie) {
    return new MovieDTO(movie.getId(), movie.getTitle(), of(movie.getGenre().name()), EMPTY_STRING, EMPTY_STRING,
                        movie.getDescription(), EMPTY_STRING, 120, movie.getYear().getYear());
  }
}
