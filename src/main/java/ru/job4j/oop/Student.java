package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void sing() {
        System.out.println("i believe i can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.sing();
        petya.sing();
        petya.sing();
    }
}
