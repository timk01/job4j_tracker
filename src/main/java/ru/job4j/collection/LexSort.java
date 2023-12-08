package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String splitter = "\\.";
        String[] splitLeft = left.split(splitter);
        String[] splitRight = right.split(splitter);
        return Integer.compare(Integer.parseInt(splitLeft[0]), Integer.parseInt(splitRight[0]));
    }
}