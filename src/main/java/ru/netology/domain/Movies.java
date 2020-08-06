package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movies {
    private int id;
    private int movieId;
    private String urlMovie;
    private String movieName;
    private String movieType;
    private boolean newFilm;
}
