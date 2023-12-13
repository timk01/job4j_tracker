package ru.job4j.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class MyClass {
    public static void main(String[] args) {
        /**
         * должно вывести : мир привет hello world
         */

        var words = List.of("hello", "привет", "world", "мир");
        List<String> mutableList = new ArrayList<>();
        Supplier<List<String>> supplier = () -> new ArrayList<String>(words);
        mutableList = supplier.get();
        Comparator<String> comparator = (string1, string2) -> {
            for (int i = 0; i < Math.min(string1.length(), string2.length()); i++) {
                if (Character.UnicodeBlock.of(string1.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)
                && !Character.UnicodeBlock.of(string2.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
                    return -1;
                } else if ((!Character.UnicodeBlock.of(string1.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)
                        && Character.UnicodeBlock.of(string2.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC))) {
                    return 1;
                } else {
                    return string1.compareTo(string2);
                }
            }
            return 0;
        };
        mutableList.sort(comparator);
        System.out.println(mutableList);

        /**
         * это к делу не относится (напрямую), и не работает как должно быть - по идее выше код можно дописать
         */
        char a = 'У';
        System.out.println((int) a + " wrong approach below");
        String one = "hello";
        String two = "привет";
        Comparator<String> comparator1 = (string1, string2) -> {
            for (int i = 0; i < Math.min(string1.length(), string2.length()); i++) {
                if (string1.charAt(i) != string2.charAt(i)) {
                    return Character.compare(string1.charAt(i), string2.charAt(i));
                }
            }
            return Integer.compare(string1.length(), string2.length());
        };
        System.out.println(comparator1.compare(one, two));
    }
}