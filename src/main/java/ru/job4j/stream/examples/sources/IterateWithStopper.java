package ru.job4j.stream.examples.sources;

import java.util.stream.Stream;

/**
 * somewhat close to iterate, but not limitless.
 * stopper included.
 * similar to:
 *     for (i = seed; hasNext(i); i = f(i)) {
 *     }
 *  4
 * 16
 * 64
 * here we see 4 (like in loop)
 * and unary operator is applicable only after it
 */

public class IterateWithStopper {
    public static void main(String[] args) {
        Stream.iterate(4, x -> x < 100, x -> x * 4)
                .forEach(System.out::println);
    }
}
