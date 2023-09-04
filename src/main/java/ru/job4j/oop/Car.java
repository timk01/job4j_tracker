package ru.job4j.oop;

public class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public static TripComputer getTripComputer() {
        Car car = new Car("Марка", "Модель");
        Car.TripComputer tripComputer = car.new TripComputer();
        return tripComputer;
    }

    public void startEngine() {
        System.out.println("Двигатель запущен");
    }

    public void setTransmissionToDefaultCar() {
        Transmission transmission = new Transmission();
        transmission.transmissionSpeed = 2;
    }

    public void setBrakesToDefaultCar() {
        Brakes brakes = new Brakes();
        brakes.goodBrakes = true;
    }

    public void seeCarInfo(Car car) {
        System.out.println("brand " + brand + " model " + model);
    }

    public void makeInnerParts() {
        Car car = new Car("1", "2");
        Car.InnerCarParts innerCarParts = car.new InnerCarParts();
        innerCarParts.innerPart = "something inner";
        innerCarParts.seeCar();
    }

    public class Transmission {

        private int transmissionSpeed;

        public void accelerate() {
            System.out.println("Ускорение");
        }

        public int getTransmissionSpeed() {
            return transmissionSpeed;
        }

    }

    public class Brakes {

        private boolean goodBrakes;

        public void brake() {
            System.out.println("Торможение");
        }

        public boolean getBrakesStatus() {
            return goodBrakes;
        }
    }

    public class TripComputer {

        public String tripData = "Бортовой компьютер";
        private String model = "Модель TripComputer";

        public void getInfo() {
            System.out.println("Модель TripComputer: " + this.model);
            System.out.println("Модель Car: " + Car.this.model);
        }

    }

    private class InnerCarParts {

        private String innerPart;

        public void seeCar() {
            System.out.println(brand);
            System.out.println(model);
        }

    }
}
