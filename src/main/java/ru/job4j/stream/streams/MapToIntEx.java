package ru.job4j.stream.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MapToIntEx {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("3", "6", "8",
                "14", "15");

        IntStream intStream = list.stream().mapToInt(Integer::parseInt)
                .filter(num -> num % 3 == 0);
        intStream.forEach(System.out::println);

        List<String> list2 = Arrays.asList("Geeks", "for", "gfg",
                "GeeksforGeeks", "GeeksQuiz");

        list2.stream().mapToInt(String::length).forEach(System.out::println);
    }
}
