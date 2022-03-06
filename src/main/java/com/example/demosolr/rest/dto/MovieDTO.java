package com.example.demosolr.rest.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

@Immutable
@Getter
@Setter
@AllArgsConstructor
public class MovieDTO {

  private Long id;
  private final String title;
  private final List<String> genres;
  private final String director;
  private final String actors;
  private final String plot;
  private final String posterUrl;
  private final int runtime;
  private final int year;

}
