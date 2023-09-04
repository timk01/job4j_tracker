package ru.job4j.oop;

public class StNested {

    private static int num1;
    public int num2;

    public StNested() { }

    static class StaticNested {

        void setStaticOuterVariable(int value) {
            num1 = value;
        }

        void setNonStaticOuterVariable(StNested outer) {
            outer.num2 = 5;
        }

    }

    public static void main(String[] args) {
        num1 = 1;
        StaticNested nested = new StaticNested();
        nested.setStaticOuterVariable(2);
        System.out.println("num1 = " + num1);
        StNested stNested = new StNested();
        nested.setNonStaticOuterVariable(stNested);
        System.out.println(stNested.num2);
    }
}
