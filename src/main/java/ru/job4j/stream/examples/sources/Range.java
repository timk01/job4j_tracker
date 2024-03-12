package ru.job4j.stream.examples.sources;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * from start (inclusive) to end (exclusive)
 *
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 *
 * -10
 * -9
 * -8
 * -7
 * -6
 */

public class Range {
    public static void main(String[] args) {
        IntStream.range(0, 10)
                .forEach(System.out::println);

        System.out.println();

        LongStream.range(-10L, -5L)
                .forEach(System.out::println);
    }
}
