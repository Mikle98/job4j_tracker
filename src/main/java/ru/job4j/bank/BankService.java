package ru.job4j.bank;

import java.util.*;

/**
 * Класс работает с пользователями и его счетами
 * @author Mikhail Nagovitsin
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных пользователя и его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя
     * @param user Пользователь, которого нужно добавить
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя.
     * @param passport номер паспорта пользователя, который будет удален
     * @return возвращает успешное или неуспешное удаление (true/false)
     */
    public boolean deleteUser(String passport) {
        return Objects.nonNull(this.users.remove(new User(passport, "")));
    }

    /**
     * Метод добавляет счет пользователю
     * @param passport номер паспорта пользователя, которому будет добавлен счет
     * @param account счет, который будет добавлен пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> userAccounts = this.users.get(user);
        if (Objects.nonNull(user) && !userAccounts.contains(account)) {
            userAccounts.add(account);
        }
    }

    /**
     * Метод определяет есть ли такой пользователь в системе
     * @param passport номер паспорта пользователя, по которому
     *                 будет вестись поиск
     * @return возвращает найденого пользователя, если пользователь
     *          не найден, вернется NULL
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : this.users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод находит счет пользователя.
     * @param passport номер паспорта пользователя, у которого
     *                 ищем счет
     * @param requisite номер счет, который должен быть у пользователя
     * @return возвращаем найденный счет, иначе NULL
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (Objects.nonNull(user)) {
            for (Account account : this.users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод осуществляет перевод средств между счетами
     * @param srcPassport номер паспорта пользователя,
     *                    у которого будут списаны средства
     * @param srcRequisite номер счета, с которого будут
     *                     списаны средства
     * @param destPassport номер паспорта пользователя,
     *                     которому будут зачислены средства
     * @param destRequisite номер счета, на который будут
     *                      зачислены средства
     * @param amount Сумма, которая будет списана с одного счета
     *               и зачислена на второй
     * @return возвращает успешность операции (true/false)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (Objects.nonNull(srcAccount)
            && Objects.nonNull(destAccount)
            && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(
                    srcAccount.getBalance() - amount);
            destAccount.setBalance(
                    destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод позволяет получить все счета пользователя
     * @param user пользователь, которого хотим узнать все счета
     * @return возвращает список счетов.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
