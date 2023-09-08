package ru.job4j.enumeration;

import static ru.job4j.enumeration.Status.*;

public class CarService {

    public static void main(String[] args) {
        Order order = new Order(1, "Mercedes-Benz GLS", Status.valueOf("IN_WORK"));
        System.out.println(order);
        Order order2 = new Order(1, "Mercedes-Benz GLS", IN_WORK);
        System.out.println("Заказ-наряд №" + order2.getNumber() + " на автомобиль " + order2.getCar()
                + ", статус ремонта: " + order2.getStatus().getInfo() + ", подробности: " + order2.getStatus().getMessage());
        System.out.println(order2);

        Status[] statuses = Status.values();
        for (Status s : statuses) {
            System.out.println("Название статуса: " + s.name() + ", Порядковый номер статуса: " + s.ordinal());
        }

        Status status = Status.valueOf("ACCEPTED");
        switch (status) {
            case ACCEPTED:
                System.out.println("Статус: Автомобиль принят на СТО");
                break;
            case IN_WORK:
                System.out.println("Статус: Автомобиль в работе");
                break;
            case WAITING:
                System.out.println("Статус: Автомобиль ожидает запчасти");
                break;
            case FINISHED:
                System.out.println("Статус: Все работы завершены");
                break;
            default:
        }
    }
}
