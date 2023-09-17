package ru.job4j.patterns.fabric.animalsfabric;

public class Cat implements AnimalBehaviour {

    private int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public void say() {
        System.out.println("miaou");
    }

    @Override
    public void eat() {
        System.out.println("eats cafood");
    }

    @Override
    public int getAnimalAge() {
        return age;
    }
}
