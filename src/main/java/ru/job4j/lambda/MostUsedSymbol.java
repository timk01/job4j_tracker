package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MostUsedSymbol {
    public static void main(String[] args) {
        String input = "slogan of java language: write once, run everywhere".replaceAll(" ", "");
        Map<Character, Integer> map = new HashMap<>();
        BiFunction<Integer, Integer, Integer> function = (oldValue, newValue) -> oldValue + 1;
        for (char character : input.toCharArray()) {
            map.merge(character, 1, function);
        }
        int max = 0;
        char result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        System.out.println("Most used symbol: " + result);
    }
}