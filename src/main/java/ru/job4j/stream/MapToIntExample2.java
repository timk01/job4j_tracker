package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MapToIntExample2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        strings.stream()
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        List<Integer> integers = List.of(1, 10, 20, 0, 3);
        int[] ints = integers
                .stream()
                .mapToInt(Integer::valueOf)
                .map(i -> i * 2)
                .toArray();
        System.out.println(Arrays.toString(ints));
    }
}