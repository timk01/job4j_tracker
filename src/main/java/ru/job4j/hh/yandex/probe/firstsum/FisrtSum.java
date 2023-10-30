package ru.job4j.hh.yandex.probe.firstsum;

import java.util.Scanner;

public class FisrtSum {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(sum(askNumber(), askNumber()));
    }

    public static int sum(int fisrt, int second) {
        return fisrt + second;
    }

    public static int askNumber() {
        return SCANNER.nextInt();
    }
}