package ru.job4j.stream.examples.sources;

import java.util.stream.Stream;

/**
 * creates MUTABLE stream without container usage
 *
 * 0
 * 1
 * 2
 * 4
 * 6
 * 8
 * 9
 * 10
 */

public class Builder {
    public static void main(String[] args) {
        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
                .add(0)
                .add(1);
        for (int i = 2; i <= 8; i += 2) {
            streamBuider.accept(i);
        }
        streamBuider
                .add(9)
                .add(10)
                .build()
                .forEach(System.out::println);
    }
}
