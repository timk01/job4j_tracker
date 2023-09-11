package ru.job4j.varargs;

public class VarArgs {

    public static String text(String str) {
        return str;
    }

    public static String text(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }
        return builder + " Количество соединенных элементов: " + strings.length;
    }

    public static String text(int x, String... strings) {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        for (String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static String text(int... numbers) {
        StringBuilder builder = new StringBuilder();
        for (int s : numbers) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"aaa", "bbb", "ccc"};
        String str = text(strings);
        System.out.println(str);
        System.out.println(text("1"));
        System.out.println(text(1, 2));
        System.out.println(text("aaa"));
        System.out.println(text("aaa", "bbb", "ccc"));
        System.out.println(text("aaa", "bbb", "ccc", "ddd", "eee"));
        System.out.println(text(30, "aaa", "bbb"));
    }

}