package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a",  "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("right string: " + left + "; left string: " + right);
            return Integer.compare(right.length(), left.length());
        };
        System.out.println();
        strings.sort(comparator);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}