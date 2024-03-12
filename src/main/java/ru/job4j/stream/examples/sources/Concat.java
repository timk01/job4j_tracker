package ru.job4j.stream.examples.sources;

import java.util.stream.Stream;

/**
 * unites two stream.
 * first we see fist stream elems till end, after second
 * 10
 * 4
 * 16
 */

public class Concat {
    public static void main(String[] args) {
        Stream.concat(
                        Stream.of(10),
                        Stream.of(4, 16))
                .forEach(System.out::println);
    }
}
