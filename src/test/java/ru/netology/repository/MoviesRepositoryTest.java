package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class MoviesRepositoryTest {

    private MoviesRepository repository = new MoviesRepository();
    private Movies first = new Movies(1, 01, "URL//1", "Бладшот", "боевик", false);
    private Movies second = new Movies(2, 02, "URL//2", "Вперёд", "мультфильм", false);
    private Movies third = new Movies(3, 03, "URL//3", "Отель Белград", "комедия", false);
    private Movies fourth = new Movies(4, 04, "URL//4", "Джентельмены", "боевик", false);
    private Movies fifth = new Movies(5, 05, "URL//5", "Человек-невидимка", "ужасы", false);
    private Movies sixth = new Movies(6, 06, "URL//6", "Тролли.Мировой тур", "мультфильм", true);
    private Movies seventh = new Movies(7, 07, "URL//7", "Номер один", "комедия", true);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldFind() {
        int idToFind = 2;

      assertEquals(repository.findById(idToFind) , second);
    }

    @Test
    public void shouldRemoveIfExist(){

        int idToRemove = 3;

        repository.removeById(idToRemove);

        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfNotExist(){

        int idToRemove = 4;

        repository.removeById(idToRemove);

        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldDeleteAll(){
        repository.removeAll();
        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[0];

        assertArrayEquals(expected, actual);

    }

}