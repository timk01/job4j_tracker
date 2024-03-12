package ru.job4j.stream.examples.sources;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * same as Range, but from both start and end are (inclusive)
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * -8
 * -7
 * -6
 */

public class RangeClosed {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 5)
                .forEach(System.out::println);

        System.out.println();

        LongStream.range(-8L, -5L)
                .forEach(System.out::println);
    }
}
