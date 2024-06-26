package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {
    Item add(Item item) throws SQLException;

    boolean replace(int id, Item item) throws SQLException;

    void delete(int id) throws SQLException;

    List<Item> findAll() throws SQLException;

    List<Item> findByName(String key) throws SQLException;

    Item findById(int id) throws SQLException;
}
