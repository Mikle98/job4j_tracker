package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс хранит информацию о пользователе
 * @author Mikhail Nagovitsin
 * @version 1.0
 */
public class User {
    /**
     * Хранение данных паспорта пользователя типа String
     */
    private String passport;

    /**
     * Хранение данных имя пользователя типа String
     */
    private String username;

    /**
     * Конструктор принимает на вход паспорт и имя пользователя.
     * После чего присваивает их пользователю.
     * @param passport данные паспорта пользователя
     * @param username данные имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспорт пользователя
     * @return возвращает паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет установить паспорт пользователя
     * @param passport данные паспорта, которые будут присвоены пользователю
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя пользователя
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет установить имя пользователя
     * @param username имя, которое будет присвоено пользователю
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Перегруженный метод equals
     * Задает уникальность пользователей только по
     * номеру паспорта
     * @param o Объект, который будет сравниваться с пользователем
     * @return возвращает итог сравнения (true/false)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Перегруженный метод hashCode
     * Задает уникальный хэш-код на основе номера паспорта
     * @return возвращает хэш-код пользователя.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
