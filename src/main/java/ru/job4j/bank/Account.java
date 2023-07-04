package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывающий работу счета клиента
 * @author Mikhail Nagovitsin
 * @version 1.0
 */
public class Account {
    /**
     * Хранит номер счета
     */
    private String requisite;

    /**
     * Хранит баланс счета
     */
    private double balance;

    /**
     * Конструктор для создания счета
     * @param requisite номер счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить номер счета
     * @return возвращает номер счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет установить номер счета
     * @param requisite номер счета, который будет у счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет установить баланс счета
     * @param balance баланс, который будет присвоен счету
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Перегруженный метод equals
     * Уникальность определяется номером счета
     * @param o объект, который будет сравниваться с счетом
     * @return возвращает результат сравнения (true/false)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Перегруженный метод hashCode
     * @return возвращает хеш-код основанный на номере счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
