package ru.job4j.hh.yandex.probe.thirdsum;

import java.util.Scanner;

public class ThirdSum {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        sum(askNumber(), askNumber());
    }

    public static int askNumber() {
        return SCANNER.nextInt();
    }

    public static void sum(int fisrt, int second) {
        System.out.println(fisrt + second);
    }
}
