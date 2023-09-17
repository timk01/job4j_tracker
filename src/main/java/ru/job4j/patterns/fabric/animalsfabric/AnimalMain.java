package ru.job4j.patterns.fabric.animalsfabric;

import java.util.Arrays;
import java.util.Scanner;

public class AnimalMain {

    private AnimalFabric animalFabric;

    public AnimalMain(AnimalFabric animalFabric) {
        this.animalFabric = animalFabric;
    }

    public void demonstrate() {
        this.animalFabric.launchAnimalMethods();
    }

    public static AnimalFabric getAnimalByType(String animalType) {
        if (animalType.equals("dog")) {
            return new DogCreator();
        } else if (animalType.equals("cat")) {
            return new CatCreator();
        }

        throw new IllegalArgumentException("don't know such type and can't crete it");
    }

    public static void main(String[] args) {
        String dog = "dog";
        String cat = "cat";
        Scanner scanner = new Scanner(System.in);
        System.out.printf("enter type of animal: %s or %s%n", dog, cat);
        String animal = scanner.nextLine();
        AnimalFabric type = getAnimalByType(animal);
        AnimalMain animalMain = new AnimalMain(type);
        animalMain.demonstrate();

        /*AnimalFabric animalFabric;
        System.out.println("enter 1 to create dog or any number to create cat (yes, i do like cats)");
        Scanner scanner = new Scanner(System.in);
        int select = Integer.parseInt(scanner.nextLine());
        animalFabric = select == 1 ? new DogCreator() : new CatCreator();
        AnimalMain animalMain = new AnimalMain(animalFabric);
        animalMain.demonstrate();*/

        /*AnimalBehaviour[] animals = new AnimalBehaviour[2];
        int age = Integer.parseInt(scanner.nextLine());
        AnimalBehaviour dog = new Dog(age);
        System.out.println("enter the second age ");
        age = Integer.parseInt(scanner.nextLine());
        AnimalBehaviour cat = new Cat(age);
        animals[0] = dog;
        animals[1] = cat;
        for (AnimalBehaviour animal : animals) {
            animal.say();
            animal.eat();
            System.out.println(animal.getAnimalAge());
        }*/
    }
}
