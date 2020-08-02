package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {
    private CartManager manager = new CartManager();
    private PurchaseItem first = new PurchaseItem(1, 01, "first", 11, 1);
    private PurchaseItem second = new PurchaseItem(2, 02, "second", 11, 1);
    private PurchaseItem third = new PurchaseItem(3, 03, "third", 11, 1);

    @BeforeEach
    public void SetUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldAdd() {
        manager.add(second);
        manager.add(third);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second, third,second,first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowFilms() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second, first, third, second, first};

        assertArrayEquals(expected, actual);
    }
}