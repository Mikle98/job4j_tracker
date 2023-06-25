package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return !Objects.isNull(this.users.remove(findByPassport(passport)));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!this.users.get(user).contains(account)) {
            this.users.get(user).add(account);
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
        if (!Objects.isNull(user)) {
            for (Account account : this.users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    rsl = account;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (!Objects.isNull(findByRequisite(srcPassport, srcRequisite))
            && !Objects.isNull(findByRequisite(destPassport, destRequisite))
            && findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            findByRequisite(srcPassport, srcRequisite).setBalance(
                    findByRequisite(srcPassport, srcRequisite).getBalance() - amount);
            findByRequisite(destPassport, destRequisite).setBalance(
                    findByRequisite(destPassport, destRequisite).getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
