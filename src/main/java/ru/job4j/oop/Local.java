package ru.job4j.oop;

public class Local {

    public static int somethingLocal = 1;
    private String name = "Petr";

    public void getFullName() {
        final String surname = "Arsentev";

        class FullName {

            public static final String PATRONYMIC = "Empty";

            static {
                int x = 0;
            }

            public void printFullName() {
                System.out.println(name + " " + surname);
            }

        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }

    public static void foo() {

        final class Foo2 {

            public static void sayGoodbye() {
                somethingLocal = 2;
                System.out.println(somethingLocal);
                System.out.println("Bye bye");
            }

            public int return22() {
                return 22;
            }
        }

        Foo2 foo2 = new Foo2();
        Foo2.sayGoodbye();
    }

    public int returnANumber() {

        final class Foo2 {

            public int return22() {
                return 22;
            }
        }

        Foo2 foo2 = new Foo2();
        return foo2.return22();
    }

    public static void main(String[] args) {
        Local local = new Local();
        local.getFullName();
        foo();
        System.out.println(local.returnANumber());
    }

}
