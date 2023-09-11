package ru.job4j.poly;

public interface Store {

    void save(String data);

    String read();

    default void foo() {
        System.out.println("foo");
    }
}