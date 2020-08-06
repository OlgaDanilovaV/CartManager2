package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movies;
import ru.netology.repository.MoviesRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)

class AfishaManagerTest {

    @Mock
    MoviesRepository repository;

    @InjectMocks
    private AfishaManager manager;
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
        Movies[] returned = new Movies[]{first, seventh, sixth, fifth, fourth, third, second, first};
        doReturn(returned).when(repository).findAll();


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
        Movies[] returned = new Movies[]{third,second,first, seventh, sixth, fifth, fourth, third, second, first};
        doReturn(returned).when(repository).findAll();

        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[]{third,second,first, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldShowRequestCountOver() {
        manager.add(sixth);
        manager.add(seventh);
        manager.setUserRequestCount(15);
        Movies[] returned = new Movies[]{seventh, sixth, fifth, fourth, third, second, first};
        doReturn(returned).when(repository).findAll();


        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[]{seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }
@Test
    void shouldShowLessFilms(){
        manager.setUserRequestCount(4);
    Movies[] returned = new Movies[]{fifth, fourth, third, second};
    doReturn(returned).when(repository).findAll();

    Movies[] actual = manager.showFilms();
    Movies[] expected = new Movies[]{fifth, fourth, third, second};

    assertArrayEquals(expected, actual);

}

    @Test
    void shouldShowNullFilms(){
        manager.setUserRequestCount(0);
        Movies[] returned = new Movies[0];
        doReturn(returned).when(repository).findAll();

        Movies[] actual = manager.showFilms();
        Movies[] expected = new Movies[0];

        assertArrayEquals(expected, actual);

    }


}
