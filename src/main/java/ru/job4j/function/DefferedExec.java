package ru.job4j.function;

import java.util.*;
import java.util.function.Function;

public class DefferedExec {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Petr"
        };

        Comparator<Integer> intComparator = Integer::compare;
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        Arrays.sort(names, lengthComparator);

        Function<Integer, Integer> function = number -> {
            System.out.println("just a funnction on 1 el");
            return number * 5;
        };
        Set<String> set = new HashSet<>();
        set.add("1");
        Iterator<String> iterator = set.iterator();
        Integer number = Integer.parseInt(iterator.next());
        int i = function.apply(number);
    }
}
