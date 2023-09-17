package ru.job4j.patterns.fabric.animalsfabric;

import java.util.Scanner;

public class DogCreator extends AnimalFabric {

    Scanner scanner = new Scanner(System.in);

    @Override
    AnimalBehaviour createAnimal() {
        System.out.println("enter the dog age ");
        int age = Integer.parseInt(scanner.nextLine());
        AnimalBehaviour dog = new Dog(age);
        return dog;
    }
}
