package ru.job4j.stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapEx {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        System.out.println(matrix.stream().flatMap(Collection::stream).collect(Collectors.toList()));
    }
}
