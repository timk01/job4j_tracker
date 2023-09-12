package ru.job4j.polymorph;

public class AnotherClass implements ExampleClass.InnerExampleInterface {
    @Override
    public void foo() {
        System.out.println("another class implements internal interface of other class");
    }
}
