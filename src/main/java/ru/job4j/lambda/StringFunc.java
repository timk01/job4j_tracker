package ru.job4j.lambda;

interface StringFunc {
    String func(String n);
}

class LambdasAsArgumentsDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;
        System.out.println("Этo исходная строка:" + inStr);
        outStr = stringOp((str) -> str.toUpperCase(), inStr);

        StringFunc func = str -> str.toUpperCase();
        System.out.println(stringOp(func, "timur"));

        System.out.println("Этo строка прописными буквами:" + outStr);

        outStr = stringOp((str) -> {
            String result = "";
            int i;
            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }
            return result;
        }, inStr);

        System.out.println("Этo строка с удаленными пробелами:"
                + outStr);
        StringFunc reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Этo обращенная строка: "
                + stringOp(reverse, inStr));
    }
}
