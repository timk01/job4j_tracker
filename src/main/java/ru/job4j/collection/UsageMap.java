package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> people = new HashMap<>();
        people.put("timk01@mail.ru", "Timur Khasmamedov");
        people.put("parsentev@yandex.ru", "Petr Arsentev");
        people.put("ivanov123@mail.ru", "Ivan Ivanov");
        people.put("timk01@mail.ru", "Timur Khasmamedov #2");

        for (String key : people.keySet()) {
            String value = people.get(key);
            System.out.println(key + " " + value);
        }
    }
}
