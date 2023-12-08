package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class UserCopy implements Comparable<UserCopy> {
    private String name;

    private int age;

    public UserCopy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * instead of clumsy structure you below:
     * int namesCompareRes = this.name.compareTo(o.name);
     * return namesCompareRes == 0 ? Integer.compare(this.age, o.age) : namesCompareRes;
     * <p>
     * you can create getters and:
     * return Comparator.comparing(User::getName).thenComparing(User::getAge).compare(this, o);
     * <p>
     * or if you have comparison via fiels witohut methods links:
     * return Comparator.comparing((UserCopy u) -> u.name).thenComparing((u) -> u.age).compare(this, o);
     *
     * @param o
     * @return comparison result
     */

    @Override
    public int compareTo(UserCopy o) {
        return Comparator.comparing((UserCopy u) -> u.name).thenComparing((u) -> u.age).compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserCopy user = (UserCopy) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
