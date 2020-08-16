package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private Movies first = new Movies(1, 01, "URL//1", "Бладшот", "боевик", false);
    private Movies second = new Movies(2, 02, "URL//2", "Вперёд", "мультфильм", false);
    private Movies third = new Movies(3, 03, "URL//3", "Отель Белград", "комедия", false);
    private Movies fourth = new Movies(4, 04, "URL//4", "Джентельмены", "боевик", false);
    private Movies fifth = new Movies(5, 05, "URL//5", "Человек-невидимка", "ужасы", false);
    private Movies sixth = new Movies(6, 06, "URL//6", "Тролли.Мировой тур", "мультфильм", true);
    private Movies seventh = new Movies(7, 07, "URL//7", "Номер один", "комедия", true);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

    }

    @Test
    void shouldAddAndShowDefaultWhenUnderDefault() {
        manager.add(sixth);
        manager.add(seventh);
        manager.add(first);


        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[]{first, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldAddAndShowDefaultWhenOverDefault() {
        manager.add(sixth);
        manager.add(seventh);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[]{fourth, third, second, first, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldShowRequestCountOver() {
        AfishaManager manager = new AfishaManager(3);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(first);


        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[]{first, seventh, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLessFilms() {
        AfishaManager manager = new AfishaManager(4);
        //manager.setUserRequestCount(4);

        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[]{fifth, fourth, third, second};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowNullFilms() {
        manager.setUserRequestCount(0);

        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[0];

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowBelowFilms() {
        AfishaManager manager = new AfishaManager(-1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(seventh);
        manager.add(sixth);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[]{fourth, third, second, first, sixth, seventh, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }
}
