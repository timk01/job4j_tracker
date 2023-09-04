package ru.job4j.oop;

public class BirdMain {

    public static void main(String[] args) {
        Bird parrot = new Bird() {

            static int k;
            private int i;

            @Override
            public void fly() {
                System.out.println("Попугай пролетает над лужайкой");
            }

            public void flyInside() {
                System.out.println("Попугай летает только внутри анонимного класса");
                i = 3;
                System.out.println();
                Bird bird = new Bird() {
                    @Override
                    public void fly() {
                        System.out.println("Попугай пролетает над лужайкой");
                    }
                };
                bird.fly();
            }
        };
        parrot.fly();
    }
}
