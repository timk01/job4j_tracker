package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (key, value)
                -> map.put(key, value);
        BiConsumer<List<Integer>, List<String>> arrayBiConsumer =
                (key, value) -> {
                    for (int i = 0; i < key.size(); i++) {
                        map.put(key.get(i), value.get(i));
                    }
                };

        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        arrayBiConsumer.accept(List.of(3, 4, 5, 6, 7),
                List.of("three", "four", "five", "six", "seven"));
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("k: " + entry.getKey() + " v: " + entry.getValue());
        }
        System.out.println();

        BiPredicate<Integer, String> biPredicate =
                (key, value) -> key % 2 == 0 || map.get(key).length() == 4;
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }
        System.out.println();

        Supplier<List<String>> supplier =
                () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();

        Consumer<String> consumer =
                (string) -> System.out.println(string);
        Function<String, String> function
                = (string) -> string.toUpperCase();
        for (String string : strings) {
            consumer.accept(function.apply(string));
        }
    }
}