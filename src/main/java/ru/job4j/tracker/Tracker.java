package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Objects;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                rsl[i] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item updateItem) {
        if (id != -1) {
            int index = indexOf(id);
            if (index != -1) {
                updateItem.setId(id);
                items[index] = updateItem;
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        if (id != -1) {
            int index = indexOf(id);
            if (index != -1) {
                System.arraycopy(items, index, items, index + 1, size - 1);
                items[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
}