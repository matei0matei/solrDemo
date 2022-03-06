package com.example.demosolr.mvc.forms;

import com.example.demosolr.rest.dto.MovieDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchForm {

  private String query;
  private List<MovieDTO> result = new ArrayList<>();

}
