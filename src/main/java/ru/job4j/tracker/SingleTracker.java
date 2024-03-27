package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public final class SingleTracker {
    private Store store = new MemTracker();
    private static SingleTracker singleTracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getSingleTracker() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) throws SQLException {
        return store.add(item);
    }

    public Item findById(int id) throws SQLException {
        return store.findById(id);
    }

    public List<Item> findByName(String key) throws SQLException {
        return store.findByName(key);
    }

    public List<Item> findAll() throws SQLException {
        return store.findAll();
    }

    public boolean replace(int id, Item item) throws SQLException {
        return store.replace(id, item);
    }

    public boolean delete(int id) throws SQLException {
        return store.delete(id);
    }
}
