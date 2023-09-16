package ru.job4j.patterns;

public class B extends A {
    private String fooB;

    public B(String fooB) {
        super();
        this.fooB = fooB;
    }

    @Override
    public void foo() {
        super.foo();
        System.out.print(fooB);
    }
}

class TestAB {
    public static void main(String[] args) {
        A b = new B("fooB");
        b.foo();
    }
}
