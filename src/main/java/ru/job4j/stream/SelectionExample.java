package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> result = strings
                .stream() 
                .skip(2)
                .toList(); 
        System.out.println(result);

        result = strings
                .stream()
                .limit(3)
                .toList();
        System.out.println(result);

        result = strings
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(result);

        String defaultStr = strings
                .stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(defaultStr);

        defaultStr = strings
                .stream()
                .skip(5)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(result);

        defaultStr = strings
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(result);
    }
}