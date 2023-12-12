package ru.job4j.vartasks;

public class PrimitiveParam {
    public static void main(String[] args) {
        int value = 1;
        PrimitiveParam.change(value);
        System.out.print(value);
        ++value;
        System.out.println(value);
    }

    public static void change(Integer value) {
        ++value;
    }
}