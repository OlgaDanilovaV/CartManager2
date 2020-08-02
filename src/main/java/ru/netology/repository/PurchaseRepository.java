package ru.netology.repository;

import ru.netology.domain.PurchaseItem;

public class PurchaseRepository {

    private PurchaseItem[] items = new PurchaseItem[0];


    public PurchaseItem[] findAll() {

        PurchaseItem[] result = new PurchaseItem[items.length];

        for (int i = 0; i < result.length; i++) {
            int index = items.length - 1 - i;
            result[i] = items[index];
        }

        return result;

    }

    public void save(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;

        items = tmp;
    }

    public PurchaseItem findById(int id) {
        PurchaseItem[] tmp = new PurchaseItem[items.length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                index++;
            }
            tmp[index] = item;
        }

        return items[index];
    }

    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll() {

        PurchaseItem[] clear = new PurchaseItem[0];

        items = clear;
    }

}
