package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.PurchaseRepository;

public class CartManager {
    private PurchaseRepository repository;


    public CartManager(PurchaseRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItem item) {
        repository.save(item);
    }

    public PurchaseItem[] getAll() {
        PurchaseItem[] items = repository.findAll();

        return items;
    }

    public PurchaseItem[] showFilms(int number) {
        PurchaseItem[] items = repository.findAll();
        PurchaseItem[] lastFilms = new PurchaseItem[number];

        for (int i = 0; i < number; i++) {
            int index = items.length - 1 - i;
            lastFilms[i] = items[i];
        }
        return lastFilms;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }


}
