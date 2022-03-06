package com.example.demosolr.model;

import static java.util.Arrays.stream;

public enum Genre {

    COMEDY, FANTASY, CRIME, DRAMA, MUSIC, ADVENTURE, HISTORY, THRILLER, ANIMATION, FAMILY, MYSTERY, BIOGRAPHY,
  ACTION, FILM_NOIR, ROMANCE, SCI_FI, WAR, WESTERN, HORROR, MUSICAL, SPORT;

  public static Genre getInstance(String name) {
    return stream(values())
        .filter(val -> val.name().equalsIgnoreCase(name.replace("-", "_")))
        .findFirst().orElse(null);
  }

}
