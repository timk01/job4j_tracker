package ru.job4j.stream.examples.sources;

import java.util.Random;
import java.util.stream.Stream;

/**
 * same as iterate, limitless loop! (need to put limit)
 * -732876569
 * 409151928
 * -1392392376
 * 678349710
 * 1934737774
 */

public class Generate {
    public static void main(String[] args) {
        Stream.generate(new Random()::nextInt)
                .limit(5).forEach(System.out::println);
    }
}
