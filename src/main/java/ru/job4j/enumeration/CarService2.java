package ru.job4j.enumeration;

public class CarService2 {

    public static void main(String[] args) {
        Order2 order = new Order2(1, "Mercedes-Benz GLS", Order2.Status2.FINISHED);
        System.out.println(order);
    }
}
