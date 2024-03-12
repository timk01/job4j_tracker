package ru.job4j.stream.examples.itermediate;

import java.util.stream.Stream;

/**
 * Returns a stream consisting of the results of applying the given function to the elements of this stream.
 * (so, applies funsction first to all elems and returns the stream-result-of-elements)
 * not really need to convert first to second.
 *
 * 13
 * 14
 * 15
 *
 * 131
 * 421
 * 96
 * 43
 * 325
 * 23
 */

public class Map {
    public static void main(String[] args) {
        Stream.of("3", "4", "5")
                .map(Integer::parseInt)
                .map(x -> x + 10)
                .forEach(System.out::println);

        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .map(x -> x + 11)
                .forEach(System.out::println);
    }
}
