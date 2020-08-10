package ru.netology.manager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movies;


@Data

public class AfishaManager {

    private int defaultPoster = 10;
    private Movies[] afisha = new Movies[0];
    private  int userRequestCount;

    public AfishaManager()    {
        this.userRequestCount = defaultPoster;
    }

    public AfishaManager(int userRequestCount) {
        this.userRequestCount = userRequestCount;
    }


    public void add(Movies film) {
        int length = afisha.length + 1;
        Movies[] tmp = new Movies[length];

        System.arraycopy(afisha, 0, tmp, 0, afisha.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;

        afisha = tmp;
    }

    public Movies[] getAll() {

      return afisha;
    }

    public Movies[] showFilms() {


        int movieCount = afisha.length;

        if (userRequestCount < 0) {
            movieCount = defaultPoster;
        }
        if (userRequestCount < movieCount) {
            movieCount = userRequestCount;
        }

        Movies[] result = new Movies[movieCount];
        for (int i = 0; i < movieCount; i++) {
            int index = afisha.length - 1 - i;
            result[i] = afisha[index];
        }

        return result;
    }
}
