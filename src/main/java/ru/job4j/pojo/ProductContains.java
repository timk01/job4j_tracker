package ru.job4j.pojo;

public class ProductContains {
    public static void main(String[] args) {
        Product first = new Product("Milk", 100);
        Product second = new Product("Milk", 100);
        boolean eq = first == second;
        System.out.println(eq);
        boolean eq2 = first.equals(second);
        System.out.println(eq2);
    }
}