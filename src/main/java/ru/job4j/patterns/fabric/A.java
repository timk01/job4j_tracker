package ru.job4j.patterns.fabric;

public class A {
    private String fooA = "default fooA";

    public A() {
    }

    public A(String fooA) {
        this.fooA = fooA;
    }

    public void foo() {
        System.out.println(fooA);
    }
}
