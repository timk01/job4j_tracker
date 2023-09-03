package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int number) {
        return number - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int number) {
        return number / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + multiply(number) + minus(number) + divide(number);
    }

    public static void main(String[] args) {
        int sumResult = sum(10);
        Calculator calculator = new Calculator();
        int multiplyResult = calculator.multiply(10);
        int minusResult = minus(10);
        int divideResult = calculator.divide(10);
        int summaryResult = calculator.sumAllOperation(10);
        System.out.printf("sumResult is: %d%n", sumResult);
        System.out.printf("multiplyResult is: %d%n", multiplyResult);
        System.out.printf("minusResult is: %d%n", minusResult);
        System.out.printf("divideResult is: %d%n", divideResult);
        System.out.printf("summaryResult is: %d", summaryResult);
    }
}