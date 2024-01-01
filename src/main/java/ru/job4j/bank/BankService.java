package ru.job4j.bank;

import java.util.*;

/**
 * Main class for BankService
 * As a main field has HashMap of users
 * And also several working methods for basic CRUD bank operations:
 * add use/account, searing for user by requisite or by passport and requisite,
 * searing for account and getting list of accounts, deletion of user.
 * Also it's possible to transfer money from one account to another.
 *
 * See {@link User} for user
 * See {@link Account} for account
 * @author Timur Khasmamedov
 * @version 1.0
 */
public class BankService {

    /**
     * Final HashMap is chosen for unique Key - not-unique Value implementation
     * Key is User (unique by passport), while Value is a list of his accounts
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Adds unique user to map of users.
     * If this map already has the user which we want to add, addition isn't implemented.
     * @param user of User type
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Deletes the user from the map of users, but only if it can find it by passport beforehand.
     * See {@link #findByPassport(String)} for user
     * @param passport of String type
     */
    public void deleteUser(String passport) {
        Optional<User> user = findByPassport(passport);
        user.ifPresent(users::remove);
    }

    /**
     * Add the account of user to the list of users,
     * but only if it can find the user by passport beforehand and the same account isn't found.
     * See {@link #findByPassport(String)} for user
     * @param passport of String type
     * @param account of Account type
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = getAccounts(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Searches the user in map above by its unique passport; if not found, returns null
     * See {@link #findByPassport(String)} for user
     * @param passport of String type
     * @return user of User type or null
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> result = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return Optional.of(user);
            }
        }
        return result;
    }

    /**
     * Searches the account of user,
     * but only if it can find the user by passport beforehand
     * and also unique account requisite is the same
     * See {@link #findByPassport(String)} for user
     * @param passport of String type
     * @return account of Account type or null if account isn't found
     */
    public Account findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = getAccounts(user.get());
            for (Account userAccount : accounts) {
                if (userAccount.getRequisite().equals(requisite)) {
                    return userAccount;
                }
            }
        }
        return null;
    }

    /**
     * Transfers money from one user account to another one.
     * Both accounts should exist beforehand,
     * which is confirmed by findByRequisite(srcPassport, srcRequisite) method
     * See {@link #findByRequisite(String passport, String requisite)}
     * Also the money amount on first account should be more that withdrawal sum
     * If all conditions above are good, reduces money on one account and increases money on another.
     * @param srcPassport of String type
     * @param srcRequisite of String type
     * @param destPassport of String type
     * @param destRequisite of String type
     * @param amount of double type
     * @return true if transfer is done or false if any issues above came in play
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account from = findByRequisite(srcPassport, srcRequisite);
        Account to = findByRequisite(destPassport, destRequisite);
        if (from == null || to == null) {
            return false;
        }
        double prevFromBalance = from.getBalance();
        if (prevFromBalance < amount) {
            return false;
        }
        from.setBalance(prevFromBalance - amount);
        double toPrevBalance = to.getBalance();
        to.setBalance(toPrevBalance + amount);
        return true;
    }

    /**
     * Searches the accounts of user,
     * @param user of User type
     * @return list of accounts of Account type or null if accounts aren't found
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }

    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> user = bank.findByPassport("3211");
        user.ifPresent(value -> System.out.println(value.getUsername()));
    }
}