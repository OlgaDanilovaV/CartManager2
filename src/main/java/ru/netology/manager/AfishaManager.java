package ru.netology.manager;
import ru.netology.domain.Movies;

public class AfishaManager {
    private Movies[] afisha = new Movies[0];

    public void add(Movies film) {
        int length = afisha.length + 1;
        Movies[] tmp = new Movies[length];

        System.arraycopy(afisha, 0, tmp, 0, afisha.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;

        afisha = tmp;
    }

    public Movies[] getAll() {
        Movies[] result = new Movies[afisha.length];

        for (int i = 0; i < result.length; i++) {
            int index = afisha.length - 1 - i;
            result[i] = afisha[index];
        }

        return result;
    }

    public Movies[] showFilms() {
        Movies[] lastFilms = new Movies[afisha.length];
        int numberFilms = 10;

        for (int i = 0; i < numberFilms; i++) {
            int index = afisha.length - 1 - i;
            lastFilms[i] = afisha[i];
        }
        return lastFilms;
    }


}
