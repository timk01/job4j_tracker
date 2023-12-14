package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInsideMethod {
    public static void main(String[] args) {
        String ayyyy = "ayyyyy";
        ayyyy = "aaaaaa";
        String temp = ayyyy;
        String name = echo(
                () -> {
                    return temp;
                }
        );
        System.out.println(ayyyy);
        System.out.println(name);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}
