package ru.job4j.polymorph;

import ru.job4j.oop.Car;

interface Parking<T> {
    void park(T car);
}

class CarParking implements Parking<Car> {
    public void park(Car car) { }
}

class TankParking<Tank> implements Parking<Tank> {

    @Override
    public void park(Tank car) {

    }
}
