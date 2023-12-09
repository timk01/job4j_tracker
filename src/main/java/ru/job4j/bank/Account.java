package ru.job4j.bank;

import java.util.Objects;

/**
 * Simple class for Account.
 * Has minimal needed working fields, methods.
 * Used in HashMap in BankService with Accounts.
 * Not the Record, since we need to set some fields values later on.
 * One particular account have only one User (though, 1 User can have multiple accounts).
 *
 * See {@link User} for account.
 * See {@link BankService} for BankService .
 * @author Timur Khasmamedov
 * @version 1.0
 */
public class Account {

    /**
     * Bunch of private fields of:
     * requisite of type String (unique)
     * balance of type double (used in transactions)
     */
    private String requisite;
    private double balance;

    /**
     * Main (and solo) constructor, has 2 params
     * @param requisite of String type
     * @param balance of double type
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Simple getter for passport
     * @return requisite of String type
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Simple setter for passport
     * @param requisite of String type
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Simple getter for passport
     * @return balance of double type
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Simple setter for passport
     * @param balance of double type
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Overrides equals with classic implementation.
     * Uses only {@code one} unique field: requisite for comparison
     * @param o of Object type
     * @return comparison result of boolean type
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
     * Overrides hashCode with classic implementation.
     * Uses only {@code one} unique field: requisite for getting hash number
     * @return hashCode of Account of type int
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}