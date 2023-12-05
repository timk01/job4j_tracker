package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBasics {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Petr");
        names.set(0, "fiva");
        names.add("proldg");
        names.add("fivaproldg");
        for (String name : names) {
            System.out.println(name);
        }
        names.remove("proldg");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
