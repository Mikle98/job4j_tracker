package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection connection;

    public SqlTracker() {
        init();
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public int statementExecute(String sql) throws SQLException {
        try (Statement statement = this.connection.createStatement()) {
           return statement.executeUpdate(sql);
        }
    }

    public List<Item> getSQLRows(String sql) throws SQLException {
        try (Statement statement = this.connection.createStatement()) {
            List<Item> rsl = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                rsl.add(new Item(resultSet.getString("name"),
                                    resultSet.getInt("id"),
                                    resultSet.getTimestamp("created").toLocalDateTime()));
            }
            return rsl;
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        String sql = String.format("insert into items(name, created) values('%s', '%s')",
                                    item.getName(),
                                    Timestamp.valueOf(item.getDateTime()));
        return statementExecute(sql) == 1 ? item : null;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        String sql = String.format("update items set name = '%s', created = '%s' where id = %s",
                                    item.getName(),
                                    Timestamp.valueOf(item.getDateTime()),
                                    id);
        return statementExecute(sql) == 1;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = String.format("delete from items where id = %s",
                                    id);
        return statementExecute(sql) == 1;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        String sql = String.format("select * from items");
        return getSQLRows(sql);
    }

    @Override
    public List<Item> findByName(String key) throws SQLException  {
        String sql = String.format("select * from items where name = '%s'",
                                    key);
        return getSQLRows(sql);
    }

    @Override
    public Item findById(int id) throws SQLException  {
        String sql = String.format("select * from items where id = %s",
                                    id);
        List<Item> rsl = getSQLRows(sql);
        return rsl.size() == 1 ? rsl.get(0) : null;
    }
}