package ru.job4j.stream.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FlatMapToIntEx {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3",
                "4", "5");
        IntStream stream = list.stream().flatMapToInt(num -> IntStream.of(Integer.parseInt(num)));
        stream.forEach(System.out::println);

        System.out.println();
        List<String> list2 = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");
        list2.stream().flatMapToInt(str -> IntStream.of(str.length())).
                forEach(System.out::println);
    }
}
