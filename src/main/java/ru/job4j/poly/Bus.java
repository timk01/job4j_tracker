package ru.job4j.poly;

public class Bus implements Transport {

    private final static int FUEL_PRICE = 50;
    private int capacity;
    private String route;

    public Bus(int capacity, String route) {
        this.capacity = capacity;
        this.route = route;
    }

    @Override
    public void drive() {
        System.out.println("this bus goes along the route " + route);
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("the bus with capacity of " + capacity + " has " + passengers + " now");
    }

    @Override
    public int reload(int fuel) {
        return fuel * FUEL_PRICE;
    }
}
