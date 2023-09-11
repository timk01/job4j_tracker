package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    private static final int THRESHOLD = 3;
    private Scanner scanner;
    private Random random = new Random();

    public MagicBall(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MagicBall magicBall = new MagicBall(scanner);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = magicBall.getQuestion();
        int answer = magicBall.randomizeNumber(THRESHOLD);
        magicBall.getOraculAnswer(answer);
    }

    public int randomizeNumber(int till) {
        return random.nextInt(till);
    }

    public String getQuestion() {
        String s = null;
        if (scanner.hasNextLine()) {
             s = scanner.nextLine();
        }
        return s;
    }

    public void getOraculAnswer(int guessedNumber) {
        switch (guessedNumber) {
            case 0 -> System.out.println("Да");
            case 1 -> System.out.println("Нет");
            default -> System.out.println("Может быть");
        }
    }
}
