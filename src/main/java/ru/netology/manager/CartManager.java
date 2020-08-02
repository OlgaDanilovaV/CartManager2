package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class CartManager {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;

        items = tmp;
    }

    public PurchaseItem[] getAll() {
        PurchaseItem[] result = new PurchaseItem[items.length];

        for (int i = 0; i < result.length; i++) {
            int index = items.length - 1 - i;
            result[i] = items[index];
        }

        return result;
    }

    public PurchaseItem[] showFilms() {
        PurchaseItem[] lastFilms = new PurchaseItem[items.length];
        int numberFilms = 10;

        for (int i = 0; i < numberFilms; i++) {
            int index = items.length - 1 - i;
            lastFilms[i] = items[i];
        }
        return lastFilms;
    }




}
