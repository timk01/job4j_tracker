package ru.job4j.stream.examples.itermediate;

import java.util.stream.Stream;

/**
 *     Stream.of("10", "11", "")
 *         .map(x -> Integer.parseInt(x, 16))
 *         .forEach(System.out::println);
 *      , , 50
 */

public class MapTask {
    public static void main(String[] args) {
        Stream.of("10", "11", "32")
                .map(x -> Integer.parseInt(x, 16))
                .forEach(System.out::println);
    }
}
