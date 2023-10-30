package ru.job4j.hh.hhcontest.coockieeater;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CookieEating {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int[] cookies = new int[askNumber()];
        int time = askNumber();
        fillArray(cookies);
        int minCookies = countMinCookies(cookies, time);
        System.out.println(minCookies);
    }

    public static int askNumber() {
        return SCANNER.nextInt();
    }

    private static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = askNumber();
        }
    }

    private static boolean isArraySorted(int[] cookies) {
        int length = cookies.length;
        if (length == 1) {
            return true;
        }

        return IntStream.range(0, length - 1).noneMatch(i -> cookies[i] > cookies[i + 1]);
    }

    private static int getTotalCookies(int[] cookies, int mid, int total) {
        for (int cookie : cookies) {
            total += (int) Math.ceil((double) cookie / mid);
        }
        return total;
    }

    public static int countMinCookies(int[] cookies, int time) {
        int length = cookies.length;

        if (!isArraySorted(cookies)) {
            Arrays.sort(cookies);
        }

        int min = 1;
        int max = cookies[length - 1];

        int minCookies = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int total = 0;

            total = getTotalCookies(cookies, mid, total);

            if (total <= time) {
                minCookies = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return minCookies;
    }
}

