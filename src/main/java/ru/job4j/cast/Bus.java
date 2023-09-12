package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " moves via road");
    }

    @Override
    public int countMaximumSpeed() {
        return 60;
    }
}
