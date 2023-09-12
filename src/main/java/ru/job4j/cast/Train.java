package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " moves via rails");
    }

    @Override
    public int countMaximumSpeed() {
        return 140;
    }
}
