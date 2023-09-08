package ru.job4j.record;

import java.util.StringJoiner;

public record PersonRecord(String name, int age) implements Cloneable {

    public static int maxAge = 100;
    public static final int MAX_AGE = 100;

    public PersonRecord {
        System.out.println("oh really ?");
    }

    public static void setMaxAge(int maxAge) {
        PersonRecord.maxAge = maxAge;
    }

    private void off() {

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonRecord.class.getSimpleName() + "{", "}")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }
}
