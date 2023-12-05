package ru.job4j.wrappers;

public class Box {

    public static void main(String[] args) {
        int a = 1;
        Integer b;
        b = Integer.valueOf(a);
        System.out.println("Integer b = " + b);

        int x = 2;
        num(x);

        Integer m = 3;
        int n = m.intValue();
        System.out.println("int n = " + n);

        Integer k = 5;
        Integer l = 6;
        System.out.println(k * l);

        Integer g = 250;
        Integer h = 250;
        System.out.println(g == h);

        Integer v = 127;
        Integer w = 127;
        System.out.println(v == w);

        System.out.println("sad example");
        Integer sum = 0;
        for (int i = 128; i < 300; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void num(Integer x) {
        System.out.println("Значение типа Integer: " + x);
    }

    public static void num(int x) {
        System.out.println("Значение типа int: " + x);
    }

}