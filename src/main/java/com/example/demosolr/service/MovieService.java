package com.example.demosolr.service;

import com.example.demosolr.model.Movie;
import com.example.demosolr.rest.dto.MovieDTO;
import com.example.demosolr.rest.dto.MoviesWrapperDTO;
import java.util.List;

public interface MovieService {

  Iterable<Movie> findAll();

  void saveMockMovies();

  void importMovies(MoviesWrapperDTO wrapperDTO);

  List<MovieDTO> search(String query);
}
