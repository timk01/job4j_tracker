package ru.job4j.patterns.decorator.decorator;

public class EasyDecoratorApp {
    public static void main(String[] args) {
        PrinterInterface decorator =
                new QuotesDecorator(new RightBracketDecorator(new LeftBracketDecorator(new Printer("hello"))));
        decorator.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {

    private String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

class QuotesDecorator implements PrinterInterface {

    private PrinterInterface component;

    public QuotesDecorator(PrinterInterface printerInterface) {
        this.component = printerInterface;
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator implements PrinterInterface {
    private PrinterInterface component;

    public LeftBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RightBracketDecorator implements PrinterInterface {
    private PrinterInterface component;

    public RightBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}


