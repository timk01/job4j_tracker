package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car2 car2 = new Car2();
        Transport tp = car2;
        Object obj = car2;
        Object ocar = new Car2();
        Car2 carFromObject = (Car2) ocar;

        Object bicycle = new Bicycle();
        Car cb = (Car) bicycle;
    }
}
