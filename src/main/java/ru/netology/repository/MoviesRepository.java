package ru.netology.repository;

import ru.netology.domain.Movies;

public class MoviesRepository {

    private Movies[] films = new Movies[0];


    public Movies[] findAll() {

        Movies[] result = new Movies[films.length];

        for (int i = 0; i < result.length; i++) {
            int index = films.length - 1 - i;
            result[i] = films[index];
        }

        return result;

    }

    public void save(Movies item) {
        int length = films.length + 1;
        Movies[] tmp = new Movies[length];

        System.arraycopy(films, 0, tmp, 0, films.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;

        films = tmp;
    }

    public Movies findById(int id) {

        for (Movies film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        Movies[] tmp = new Movies[length];
        int index = 0;
        for (Movies item : films) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {

        Movies[] clear = new Movies[0];

        films = clear;
    }

}
