package ru.job4j.tracker.input;

public interface Input {

    static boolean between(int select, int start, int finish) {
        return select >= start && select < finish;
    }

    String askStr(String question);

    int askInt(String question);

}