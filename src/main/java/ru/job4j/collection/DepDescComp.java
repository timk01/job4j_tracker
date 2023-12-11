package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        return right[0].compareTo(left[0]) != 0 ? right[0].compareTo(left[0])
        : o1.substring(left[0].length()).compareTo(o2.substring(right[0].length()));
    }
}