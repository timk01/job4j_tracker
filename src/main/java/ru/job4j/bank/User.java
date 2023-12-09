package ru.job4j.bank;

import java.util.Objects;

/**
 * Simple class for User.
 * Has minimal needed working fields, methods.
 * Used in HashMap in BankService with Accounts.
 * Not the record-class, since we need to set some fields values later on.
 * User can have several account and used along with it in.
 *
 * See {@link Account} for account.
 * See {@link BankService} for BankService.
 * @author Timur Khasmamedov
 * @version 1.0
 */
public class User {

    /**
     * Bunch of private fields of type String (passport is unique)
     */
    private String passport;
    private String username;

    /**
     * Main (and solo) constructor, has 2 params
     * @param passport of String type
     * @param username of String type
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Simple getter for passport
     * @return passport of String type
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Simple setter for passport
     * @param passport of String type
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Simple getter for name
     * @return username of String type
     */
    public String getUsername() {
        return username;
    }

    /**
     * Simple setter for passport
     * @param username of String type
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Overrides equals with classic implementation.
     * Uses only {@code one} unique field: passport for comparison
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Overrides hashCode with classic implementation.
     * Uses only {@code one} unique field: passport for getting hash number
     * @return hashCode of User of type int
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}