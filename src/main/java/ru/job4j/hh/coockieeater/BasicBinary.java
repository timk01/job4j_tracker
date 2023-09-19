package ru.job4j.hh.coockieeater;

public class BasicBinary {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        int guessedNumber = 57;
        int findTheNumber = findTheNumber(numbers, guessedNumber);
        System.out.println(findTheNumber);
    }

    private static int findTheNumber(int[] numbers, int guessedNumber) {
        int low = numbers[0];
        int high = numbers[numbers.length - 1];

        int tries = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = numbers[mid];

            tries++;

            if (guess == guessedNumber) {
                return tries;
            } else if (guess > guessedNumber) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return tries;
    }
}
