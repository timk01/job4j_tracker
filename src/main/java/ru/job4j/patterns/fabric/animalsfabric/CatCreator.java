package ru.job4j.patterns.fabric.animalsfabric;

import java.util.Scanner;

public class CatCreator extends AnimalFabric {

    Scanner scanner = new Scanner(System.in);

    @Override
    AnimalBehaviour createAnimal() {
        System.out.println("enter the cat age ");
        int age = Integer.parseInt(scanner.nextLine());
        AnimalBehaviour cat = new Cat(age);
        return cat;
    }
}
