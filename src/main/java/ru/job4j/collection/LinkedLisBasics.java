package ru.job4j.collection;

import java.util.LinkedList;

public class LinkedLisBasics {
    public static void main(String[] args) {
        System.out.println();
        LinkedList<String> names2 = new LinkedList<String>();
        names2.add(0, "Petr");
        names2.add(0, "Ivan");
        names2.add(0, "Stepan");
        for (String value : names2) {
            System.out.println(value);
        }
    }
}
