package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        int i = right[0].compareTo(left[0]);
        if (i != 0) {
            return i;
        }
        for (int j = 1; j < Math.min(left.length, right.length); j++) {
            if (!left[j].equals(right[j])) {
                return left[j].compareTo(right[j]);
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}