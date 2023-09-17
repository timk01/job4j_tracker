package ru.job4j.patterns.fabric.animalsfabric;

public abstract class AnimalFabric {

    public void launchAnimalMethods() {
        AnimalBehaviour animal = createAnimal();
        animal.say();
        animal.eat();
        System.out.println(animal.getAnimalAge());
    }

    abstract AnimalBehaviour createAnimal();
}
