package ru.job4j.collection;

import java.util.*;

public class CollectionUsage {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        for (String str : collection) {
            System.out.println(str);
        }

        Collection<String> list = new ArrayList<>();
        list.addAll(collection);
        list.addAll(collection);
        for (String str : list) {
            System.out.println(str);
        }

        System.out.println();
        Collection<String> set = new TreeSet<>();
        set.addAll(collection);
        set.addAll(Set.of("one"));
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("delete with iterator");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("two".equals(next)) {
                iterator.remove();
            }
        }
        set.stream().forEach((i) -> System.out.println(i));

        System.out.print("\n");
        System.out.print("delete without iterator" + System.lineSeparator());
        collection.remove("one");
        collection.stream().forEach(System.out::println);

        System.out.println(System.lineSeparator() + "removeAll");
        collection.add("one");
        collection.removeAll(List.of("two", "one"));
        collection.stream().forEach(System.out::println);

        System.out.println();
        collection.add("one");
        collection.add("onee");
        collection.add("oneee");
        collection.retainAll(List.of("one", "three"));
        collection.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("other methods");
        System.out.println("Размер коллекции равен: " + collection.size());
        System.out.println("Коллекция содержит элемент two: " + collection.contains("two"));
        System.out.println("Содержимое в виде массива: " + Arrays.toString(collection.toArray()));
        collection.clear();
        System.out.println("Коллекция после очистки пуста: " + collection.isEmpty());
        collection.add("one");
        System.out.println(collection.equals(List.of("one")));
        System.out.println("one".hashCode());
        System.out.println("plus hashcode (which is one) * 31 + original hashcode (in loop)");
        System.out.println(collection.hashCode());
    }
}