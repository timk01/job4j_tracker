package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSort {
    public static void main(String[] args) {
        Set<Integer> numb = Set.of(3, 7, 8);
        System.out.println("unsorted! - umbodifible coll" + numb);
        Set<Integer> numb2 = new TreeSet<>(Arrays.asList(3, 7, 8));
        System.out.println(numb2);

        System.out.println();
        Set<Integer> numbers = new TreeSet<>(Collections.reverseOrder());
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        System.out.println(numbers);
    }
}
