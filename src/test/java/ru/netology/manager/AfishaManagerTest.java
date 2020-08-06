package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private Movies first = new Movies(1,01,"URL//1","Бладшот", "боевик",false);
    private Movies second = new Movies(2,02,"URL//2","Вперёд", "мультфильм",false);
    private Movies third = new Movies(3,03,"URL//3","Отель Белград", "комедия",false);
    private Movies fourth = new Movies(4,04,"URL//4","Джентельмены", "боевик",false);
    private Movies fifth = new Movies(5,05,"URL//5","Человек-невидимка", "ужасы",false);
    private Movies sixth = new Movies(6,06,"URL//6","Тролли.Мировой тур", "мультфильм",true);
    private Movies seventh = new Movies(7,07,"URL//7","Номер один", "комедия",true);

    @BeforeEach
    public void SetUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

    }

    @Test
    void shouldAdd() {
        manager.add(sixth);
        manager.add(seventh);

        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{seventh, sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowFilms() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{third, second, first, third, second};

        assertArrayEquals(expected, actual);
    }
}