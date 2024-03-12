package ru.job4j.stream.examples.itermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Stream.mapToDouble(ToDoubleFunction mapper)
 * Stream.mapToInt(ToIntFunction mapper)
 * Stream.mapToLong(ToLongFunction mapper)
 * IntStream.mapToObj(IntFunction mapper)
 * IntStream.mapToLong(IntToLongFunction mapper)
 * IntStream.mapToDouble(IntToDoubleFunction mapper)
 *
 * 5
 * 3
 * 3
 * 13
 * 9
 *
 * -15
 * -14
 * -13
 * -12
 * -11
 */

public class MapTo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Geeks", "for", "gfg",
                "GeeksforGeeks", "GeeksQuiz");
        list.stream().mapToInt(str -> str.length()).forEach(System.out::println);

        System.out.println();

        IntStream stream = IntStream.range(5, 10);
        LongStream stream1 = stream.mapToLong(num -> (long) num - 20);
        stream1.forEach(System.out::println);
    }
}
