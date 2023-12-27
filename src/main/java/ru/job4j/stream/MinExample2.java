package ru.job4j.stream;

import java.util.*;
import java.util.stream.IntStream;

public class MinExample2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 1, 3, 2);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.comparingInt(Integer::intValue)
                );
        System.out.println(minEl.get());

        System.out.println();
        Optional<Integer> minEl2 = list.stream()
                .min(Comparator.naturalOrder()
                );
        System.out.println(minEl2.get());

        System.out.println();
        Optional<Integer> minEl3 = list.stream()
                .min(Comparator.comparing(x1 -> x1)
                );
        System.out.println(minEl3.get());

        System.out.println();
        Optional<Integer> minEl4 = list.stream()
                .min((x1, x2) -> x1.compareTo(x2)
                );
        System.out.println(minEl4.get());

        System.out.println();
        OptionalInt min = IntStream
                .rangeClosed(1, 5)
                .min();
        System.out.println(min.getAsInt());
    }
}