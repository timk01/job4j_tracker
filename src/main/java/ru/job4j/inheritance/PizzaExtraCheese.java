package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private final static String CHEESE = " + extra cheese";

    @Override
    public String name() {
        return super.name() + CHEESE;
    }
}
