package ru.job4j.tracker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private List<Item> list = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        list.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? list.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(list);
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : list) {
            if (key.equals(item.getName())) {
                rsl.add(item);
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
            updateItem.setId(id);
            list.set(index, updateItem);
        }
        return rsl;
    }

    public void delete(int id) {
        int index = indexOf(id);
        list.remove(index);
    }

    @Override
    public void close() throws SQLException {
    }
}