package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movies;
import ru.netology.repository.MoviesRepository;


@Data
@NoArgsConstructor
public class AfishaManager {

    private int defaultPoster = 10;
    private MoviesRepository repository;
    private int userRequestCount;

    public AfishaManager(MoviesRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(int userRequestCount) {

        this.userRequestCount = userRequestCount;
    }


    public void add(Movies film) {
        repository.save(film);
    }


    public Movies[] getAll() {
        Movies[] films = repository.findAll();

        return films;
    }


    public Movies[] showFilms() {

        int movieCount = repository.findAll().length;

        if (userRequestCount < 0) {
            movieCount = defaultPoster;
        }
        if (userRequestCount < movieCount) {
            movieCount = userRequestCount;
        }

        Movies[] result = new Movies[movieCount];
        for (int i = 0; i < movieCount; i++) {
            int index = repository.findAll().length - 1 - i;
            result[i] = repository.findAll()[index];
        }

        return repository.findAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
