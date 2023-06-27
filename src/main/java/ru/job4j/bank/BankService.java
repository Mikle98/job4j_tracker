package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return Objects.nonNull(this.users.remove(new User(passport, "")));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> userAccounts = this.users.get(user);
        if (Objects.nonNull(user) && !userAccounts.contains(account)) {
            userAccounts.add(account);
        }
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
