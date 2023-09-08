package ru.job4j.enumeration;

import java.util.Objects;

public class Order2 {
    private int number;
    private String car;
    private Status2 status2;

    public enum Status2 {
        ACCEPTED,
        IN_WORK,
        WAITING,
        FINISHED
    }

    public Order2(int number, String car, Order2.Status2 status2) {
        this.number = number;
        this.car = car;
        this.status2 = status2;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order2 order = (Order2) o;
        return number == order.number && Objects.equals(car, order.car) && status2 == order.status2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, car, status2);
    }

    @Override
    public String toString() {
        return "Order{"
                + "number=" + number
                + ", car='" + car + '\''
                + ", status2=" + status2
                + '}';
    }
}
