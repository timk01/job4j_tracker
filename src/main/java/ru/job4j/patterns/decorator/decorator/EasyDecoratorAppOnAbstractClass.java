package ru.job4j.patterns.decorator.decorator;

public class EasyDecoratorAppOnAbstractClass {
    public static void main(String[] args) {
        PrinterInterface2 decorator =
                new QuotesDecorator2(new RightBracketDecorator2(new LeftBracketDecorator2(new Printer2("hello"))));
        decorator.print();
    }
}

interface PrinterInterface2 {
    void print();
}

class Printer2 implements PrinterInterface2 {

    private String value;

    public Printer2(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class Decorator implements PrinterInterface2 {
    PrinterInterface2 component;

    public Decorator(PrinterInterface2 component) {
        this.component = component;
    }
}

class QuotesDecorator2 extends Decorator {

    public QuotesDecorator2(PrinterInterface2 component) {
       super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator2 extends Decorator {

    public LeftBracketDecorator2(PrinterInterface2 component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RightBracketDecorator2 extends Decorator {

    public RightBracketDecorator2(PrinterInterface2 component) {
        super(component);
    }

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}


