package ru.job4j.api;

import java.util.List;

public class TakeWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 5, 6, 6, 7, 9, -20, -30).stream()
                .sorted()
                .takeWhile(value -> value < 7)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);
    }
}