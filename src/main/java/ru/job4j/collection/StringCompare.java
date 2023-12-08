package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result;
        int length = Math.min(left.length(), right.length());
        for (int i = 0; i < length; i++) {
            char firstStrChar = left.charAt(i);
            char secondStrChar = right.charAt(i);
            if (Character.isLetter(firstStrChar) && Character.isLetter(secondStrChar)) {
                result = Character.compare(firstStrChar, secondStrChar);
            } else if (Character.isDigit(firstStrChar) && Character.isDigit(secondStrChar)) {
                result = Integer.compare(firstStrChar, secondStrChar);
            } else {
                return Integer.compare(firstStrChar, secondStrChar);
            }
            if (result != 0) {
                return result;
            }
        }

        return Integer.compare(left.length(), right.length());
    }
}