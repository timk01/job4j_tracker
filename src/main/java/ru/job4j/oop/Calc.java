package ru.job4j.oop;

public class Calc {

    public static class Multiple {

        private final int rsl;

        public Multiple(int number) {
            rsl = number;
        }

        public int getResult() {
            return rsl;
        }
    }

    public static Multiple getMult(int value) {
        int result = value * value;
        return new Multiple(result);
    }

    public int foo() {
        return -1;
    }

    public static void main(String[] args) {
        Calc.Multiple mult = new Multiple(2);
        System.out.println(mult.getResult());
        Calc.Multiple mult2 = Calc.getMult(3);
        System.out.println("Квадрат числа равен " + mult2.getResult());
    }

}