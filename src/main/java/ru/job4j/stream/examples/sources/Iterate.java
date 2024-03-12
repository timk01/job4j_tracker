package ru.job4j.stream.examples.sources;

import java.util.stream.Stream;

/**
 * same as generate, limitless loop!
 * 1
 * 2
 * 4
 * 8
 * 16
 * 32
 */

public class Iterate {
    public static void main(String[] args) {
        Stream.iterate(1, x -> x * 2)
                .limit(6)
                .forEach(System.out::println);
    }
}
