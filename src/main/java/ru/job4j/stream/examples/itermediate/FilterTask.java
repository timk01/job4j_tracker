package ru.job4j.stream.examples.itermediate;

import java.util.stream.IntStream;

/**
 * need:
 * 3
 * 6
 */

public class FilterTask {
    public static void main(String[] args) {
        IntStream.range(2, 9)
                .filter(x -> x % 3 == 0)
                .forEach(System.out::println);
    }
}
