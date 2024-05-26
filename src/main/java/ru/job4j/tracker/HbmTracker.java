package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
          session.getTransaction().begin();
          session.save(item);
          session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        Optional<Item> optionalItem = Optional.empty();
        try {
            session.getTransaction().begin();
            optionalItem = session.createQuery(
                    "UPDATE Item SET name = :name WHERE id = :id")
                            .setParameter("name", item.getName())
                                    .setParameter("id", id)
                    .uniqueResultOptional();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return optionalItem.isPresent();
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        try {
            session.getTransaction().begin();
            session.createQuery(
                    "DELETE FROM Item WHERE id = :id")
                            .setParameter("id", id)
                                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> listItem = new ArrayList<>();
        try {
            session.getTransaction().begin();
            Query<Item> query = session.createQuery(
                    "FROM Item");
            for (var item : query.list()) {
                listItem.add(item);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return listItem;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> itemList = new ArrayList<>();
        try {
            session.getTransaction().begin();
            Query<Item> query = session.createQuery(
                    "FROM Item WHERE name = :name")
                    .setParameter("name", key);
            for (var item : query.list()) {
                itemList.add(item);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item item = null;
        try {
            session.getTransaction().begin();
            Query<Item> query = session.createQuery(
                    "FROM Item WHERE id = :id")
                    .setParameter("id", id);
            item = query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
