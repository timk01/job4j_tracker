package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        String regex = " ";
        String[] origin = originText.split(regex);
        Set<String> checker = new HashSet<>(Arrays.asList(origin));
        String[] text = duplicateText.split(regex);
        for (String word : text) {
            if (!checker.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
