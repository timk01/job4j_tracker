package ru.job4j.stream.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        List<String> list1 = List.of("1", "2", "3", "1");
        Set<String> set = list1.stream()
                .map(String::valueOf)
                .collect(Collectors.toSet());

        System.out.println(set);
    }
}
