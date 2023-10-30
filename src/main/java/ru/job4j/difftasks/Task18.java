package ru.job4j.difftasks;

import java.util.StringJoiner;

public class Task18 {
    public static void loop() {
        StringJoiner sj = new StringJoiner("", "Начало" + System.lineSeparator(), System.lineSeparator() + "Конец");
        for (int i = 10; i < 19; i += 2) {
            sj.add(String.valueOf(i));
            if (i % 4 == 0) {
                sj.add("# ");
            } else if (i != 18) {
                sj.add(" ");
            }

        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        loop();
    }
}