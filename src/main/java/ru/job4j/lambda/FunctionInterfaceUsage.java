package ru.job4j.lambda;

import java.util.*;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "one", "two", "three");
        Comparator<String> comparator =
                (o1, o2) -> {
                    return Integer.compare(o2.length(), o1.length() == 0
                            ? o2.compareTo(o1) : Integer.compare(o2.length(), o1.length()));
                };
        Supplier<Queue<String>> setSupplier =
                () -> new PriorityQueue<>(24, comparator);
        Queue<String> queue = setSupplier.get();
        queue.addAll(list);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println();
        Supplier<Set<String>> supplier2 = () -> new HashSet<>(list);
        Set<String> strings = supplier2.get();
        for (String string : strings) {
            System.out.println(string);
        }
        BiConsumer<Integer, String> consumer = (first, second) -> System.out.println(first + second);
        int i = 1;
        for (String string : strings) {
            consumer.accept(i++, " is " + string);
        }

        Supplier<String> supplier = () -> "New String For Interface";
        System.out.println(supplier.get());
        BiConsumer<String, String> consumer2 = (first, second) -> System.out.println(first + second);
        consumer2.accept(supplier.get(), " and Second String");

        System.out.println();
        Predicate<String> predicate = string -> string.isEmpty();
        System.out.println("Строка пустая: " + predicate.test(""));
        System.out.println("Строка пустая: " + predicate.test("test"));

        System.out.println();
        BiPredicate<String, Integer> condition = (string, number) -> string.contains(number.toString());
        System.out.println("Строка содержит подстроку: " + condition.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + condition.test("Name", 123));

        System.out.println();
        Function<String, Character> function = string -> string.charAt(2);
        System.out.println("Третий символ в строке: " + function.apply("first"));
        System.out.println("Третий символ в строке: " + function.apply("second"));

        System.out.println();
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));

        BinaryOperator<StringBuilder> builder2 = (first, second) -> first.append(" ").append(second);
        System.out.println(
                "Строка после объединения: " + builder2.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}