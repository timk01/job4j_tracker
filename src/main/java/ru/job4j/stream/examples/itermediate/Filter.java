package ru.job4j.stream.examples.itermediate;

import java.util.stream.Stream;

/**
 * 120
 * 410
 * 314
 */

public class Filter {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .filter(x -> x == 10)
                .forEach(System.out::print);

        Stream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x > 100)
                .forEach(System.out::println);
    }
}
