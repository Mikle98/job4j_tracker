package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;

public class Tracker {
    private List<Item> list = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public List<Item> add(Item item) {
        list.add(list.size(), item);
        return list;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? list.get(index) : null;
    }

    public List<Item> findAll() {
        return list;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (key.equals(list.get(i).getName())) {
                rsl.add(list.get(i));
                count++;
            }
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item updateItem) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            list.remove(index);
            list.add(index, updateItem);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            list.remove(index);
        }
        return rsl;
    }
}