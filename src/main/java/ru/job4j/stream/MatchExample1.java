package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MatchExample1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result = strings
                .stream()
                .noneMatch(str -> str.length() > 6);
        System.out.println(result);

        List<Integer> ints = Arrays.asList(4, 0, 6, 2);
        boolean answer
                = ints.stream().noneMatch(num -> num < 0);
        System.out.println(answer);

        Stream<String> stream
                = Stream.of("Geeks", "fOr", "GEEKSQUIZ",
                "GeeksforGeeks", "CSe");
        boolean answer2 = stream.noneMatch(
                str
                        -> Character.isUpperCase(str.charAt(1))
                        && Character.isLowerCase(str.charAt(2))
                        && str.charAt(0) == 'f');
        System.out.println(answer2);

        result = strings
                .stream()
                .noneMatch(x -> x.contains("Шесть"));
        System.out.println(result);

        result = strings
                .stream()
                .noneMatch("Шесть"::contains);
        System.out.println(result);
    }
}