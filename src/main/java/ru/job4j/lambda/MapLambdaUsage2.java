package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapLambdaUsage2 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");

        BiFunction<Integer, String, String> function = (key, value) -> value + "_" + key;
        String result = map.computeIfPresent(1, function);

        System.out.println("Current value: " + result);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Petr", 5);
        map2.remove("Petr");

        Function<String, Integer> function2 = String::length;
        System.out.println("Result: " + map2.computeIfAbsent("Petr", function2));
        System.out.println("Result: " + map2.computeIfAbsent("Petr", key -> key.length() + 10));
        map2.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}