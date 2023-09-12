package ru.job4j.polymorph;

public class MainAnoherClass {

    public static void main(String[] args) {
        ExampleClass.InnerExampleInterface exampleInterface = new AnotherClass();
        exampleInterface.foo();
    }
}
