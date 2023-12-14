package ru.job4j.function.training;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Cat", "Hello", "Timur", "Java"));

        list.removeIf(new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        });

        System.out.println(list);
    }
}
