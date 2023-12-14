package ru.job4j.function.training;

public class SimpleGen {
    private int number;

    public SimpleGen() {
        super();
    }

    public SimpleGen(int number) {
        super();
        this.number = number;
    }

    public int getNumber() {
        int temp = number;
        number++;
        return temp;
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
