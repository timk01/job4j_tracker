package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = Math.min(left.length(), right.length());
        for (int i = 0; i < length; i++) {
            char firstStrChar = left.charAt(i);
            char secondStrChar = right.charAt(i);
            if (areSymbolsDifferent(firstStrChar, secondStrChar)) {
                return Integer.compare(firstStrChar, secondStrChar);
            }

            if (areSymbolsChars(firstStrChar, secondStrChar)) {
                result = Character.compare(firstStrChar, secondStrChar);
            } else if (areSymbolsNumbers(firstStrChar, secondStrChar)) {
                result = Integer.compare(firstStrChar, secondStrChar);
            }
            if (result != 0) {
                return result;
            }
        }

        return Integer.compare(left.length(), right.length());
    }

    private boolean areSymbolsNumbers(char firstStrChar, char secondStrChar) {
        return Character.isDigit(firstStrChar) && Character.isDigit(secondStrChar);
    }

    private boolean areSymbolsChars(char firstStrChar, char secondStrChar) {
        return Character.isLetter(firstStrChar) && Character.isLetter(secondStrChar);
    }

    private boolean areSymbolsDifferent(char firstStrChar, char secondStrChar) {
        return Character.isLetter(firstStrChar) && Character.isDigit(secondStrChar)
                || Character.isLetter(secondStrChar) && Character.isDigit(firstStrChar);
    }
}