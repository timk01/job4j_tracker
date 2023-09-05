package ru.job4j.inheritance;

public class Cat extends Animal {
    @Override
    public void instanceInvoke() {
        System.out.println("Вызов метода экземпляра Cat");
    }

    public static void staticInvoke() {
        System.out.println("Вызов статического метода Cat");
    }

    public static int staticInvoke(int i) {
        return -1;
    }

    public boolean canPurr() {
        return true;
    }
}
