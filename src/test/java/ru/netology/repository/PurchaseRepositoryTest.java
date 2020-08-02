package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseRepositoryTest {

    private PurchaseRepository repository = new PurchaseRepository();
    private PurchaseItem first = new PurchaseItem(1, 01, "first", 11, 1);
    private PurchaseItem second = new PurchaseItem(2, 02, "second", 11, 1);
    private PurchaseItem third = new PurchaseItem(3, 03, "third", 11, 1);

    @BeforeEach
public void SetUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldFind() {
        int idToFind = 2;

        repository.findById(idToFind);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExist(){

        int idToRemove = 3;

        repository.removeById(idToRemove);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfNotExist(){

        int idToRemove = 4;

        repository.removeById(idToRemove);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldDeleteAll(){
        repository.removeAll();
        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[0];

        assertArrayEquals(expected, actual);

    }

}