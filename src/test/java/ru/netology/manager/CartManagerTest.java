package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.PurchaseRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

class CartManagerTest {

    @Mock
    PurchaseRepository repository;
    @InjectMocks
    private CartManager manager;

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
        PurchaseItem[] returned = new PurchaseItem[]{third, second, third,second,first};
        doReturn(returned).when(repository).findAll();


        manager.add(second);
        manager.add(third);


        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second, third,second,first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowFilms() {

        PurchaseItem[] returned = new PurchaseItem[]{third, second, first, third, second};
        doReturn(returned).when(repository).findAll();

        manager.add(first);
        manager.add(second);
        manager.add(third);

        PurchaseItem[] actual = manager.showFilms(5);
        PurchaseItem[] expected = new PurchaseItem[]{third, second, first, third, second};

        assertArrayEquals(expected, actual);
    }
}

