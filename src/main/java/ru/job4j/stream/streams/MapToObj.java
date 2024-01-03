package ru.job4j.stream.streams;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToObj {
    public static void main(String[] args) {
        IntStream stream = IntStream.range(3, 8);

        Stream<String> stream1 = stream.mapToObj(num
                -> Integer.toBinaryString(num));
        stream1.forEach(System.out::println);

        System.out.println();
        IntStream stream2 = IntStream.of(3, 5, 7, 9, 11);
        Stream<BigInteger> stream3 = stream2
                .mapToObj(BigInteger::valueOf);
        stream3.forEach(num -> System.out.println(num.add(BigInteger.TEN)));
    }
}
