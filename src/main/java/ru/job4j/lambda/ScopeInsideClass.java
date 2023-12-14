package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInsideClass {

    private static String first = "Гав";
    private static String second = "Муу";

    public static void main(String[] args) {
        String test = echo(
                () -> {
                    second = "Мяу";
                    return first + second;
                }
        );
        System.out.println(test);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}