package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "X x x x x x x X" + ln
                + "x             x" + ln
                + "x             x" + ln
                + "x             x" + ln
                + "x             x" + ln
                + "x             x" + ln
                + "x             x" + ln
                + "X x x x x x x X" + ln;
    }
}
