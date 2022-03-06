package com.example.demosolr.rest;

import com.example.demosolr.mvc.forms.SearchForm;
import com.example.demosolr.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MovieMVCController {

  private final MovieService movieService;

  @GetMapping(value = "/search")
  public String getAll(Model model) {
    model.addAttribute("searchForm", new SearchForm());
    return "searchPage";
  }

  @PostMapping(value = "/search")
  public String search(Model model, @ModelAttribute SearchForm form) {
    SearchForm searchForm = new SearchForm();
    searchForm.setResult(movieService.search(form.getQuery()));
    model.addAttribute("searchForm", searchForm);
    return "searchPage";
  }

}
