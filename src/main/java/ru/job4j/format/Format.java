package ru.job4j.format;

import java.util.Calendar;

public class Format {

    public static void getGreeting(String name) {
        System.out.println(String.format("Привет! Я %s", name));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Привет, %s! Текущая дата: %tF, Текущее время: %tT", name, instance, instance));
    }

    public static void main(String[] args) {
        getGreeting("Елена");
        String format = String.format("%d, %s, %c", 10, "Elena", 'M');
        System.out.println(format);
        System.out.println(String.format("Привет! Я %s, мой возраст: %d", "name", 100));
        System.out.println(String.format("Аргумент передан? %b", 55));
        System.out.println(String.format("Jo%c4j", 'b'));
        System.out.format("Строка1%nСтрока2");
        System.out.println();
        getGreetingAndTime("Timur");
        System.out.println(String.format("Задаем число 0.99 - %f", 0.99));
        System.out.println(String.format("Задаем число 0.99 - %.2f", 0.99));
        System.out.println(String.format("%1$,+016.2f", 5000000.0000));
        System.out.println(String.format("|%2$+016.5f| %1d", 5000000, 2000000.0));
    }

}