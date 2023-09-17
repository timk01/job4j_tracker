package ru.job4j.patterns.fabric.animalsfabric;

public class Dog implements AnimalBehaviour {

    private int age;

    public Dog(int age) {
        this.age = age;
    }

    @Override
    public void say() {
        System.out.println("woof");
    }

    @Override
    public void eat() {
        System.out.println("eating meat");
    }

    @Override
    public int getAnimalAge() {
        return age;
    }
}
