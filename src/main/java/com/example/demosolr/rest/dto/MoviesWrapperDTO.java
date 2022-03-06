package com.example.demosolr.rest.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoviesWrapperDTO {
  private List<MovieDTO> movieDTOList;

  public MoviesWrapperDTO() {
  }
}