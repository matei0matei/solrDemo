package com.example.demosolr.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "movies")
@Getter
@Setter
@NoArgsConstructor
public class Movie {

  @Id
  @Indexed(name = "id", type = "long")
  private Long id;

  @Indexed(name = "title", type = "string")
  private String title;

  @Indexed(name = "description", type = "string")
  private String description;

  @Indexed(name = "genre", type = "string")
  private Genre genre;

  @Indexed(name = "year", type = "string")
  private LocalDate year;

  @Indexed(name = "note", type = "long")
  private double note;

//  public Movie(Long id, String title, String description) {
//    this.id = id;
//    this.title = title;
//    this.description = description;
//    this.genre = Genre.COMEDY;
//    this.year = LocalDate.now();
//    this.note = 10;
//  }

  public Movie(Long id, String title, String description, Genre genre, LocalDate year, double note) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.genre = genre;
    this.year = year;
    this.note = note;
  }

}
