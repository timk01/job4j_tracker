package ru.job4j.poly;

public class Bus implements Transport {

    private final static int FUEL_PRICE = 50;
    private int fuel;
    private int capacity;
    private String name;
    private String route;

    public Bus(int fuel, int capacity, String name, String route) {
        this.fuel = fuel;
        this.capacity = capacity;
        this.name = name;
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
