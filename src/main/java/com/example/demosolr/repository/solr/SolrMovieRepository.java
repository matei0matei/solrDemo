package com.example.demosolr.repository.solr;

import com.example.demosolr.model.Movie;
import java.util.List;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolrMovieRepository extends SolrCrudRepository<Movie, Long> {

  List<Movie> findAllByDescriptionContainsOrTitleContains(String descParam, String titleParam);

}
