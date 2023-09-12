package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " fly");
    }

    @Override
    public int countMaximumSpeed() {
        return 360;
    }
}
