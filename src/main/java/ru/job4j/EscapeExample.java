package ru.job4j;

public class EscapeExample {
    public static void main(String[] args) {
        String str = "Я изучаю на \"Job4j\" экранирование символов";
        System.out.println(str);
        char escape = '\"';
        System.out.println(escape);
        String str2 = "Я изучаю на 'Job4j' экранирование символов";
        System.out.println(str2);
        char cs = '"';
        System.out.println(cs);
        String str3 = "C:\\projects\\job4j\\File.java";
        System.out.println(str3);
        System.out.println();
        System.out.print("Старый длинный текст\r");
        System.out.println("Новый текст");
        System.out.println();
        System.out.print("Первая строка\r\nВторая строка");
        System.out.println();
        System.out.println("Первая строка\n\rВторая строка");
        System.out.println("Первая строка\nВторая строка");
        System.out.println("Без отступа");
        System.out.println("\tОдин отступ");
        System.out.println("\t\tДва отступа");
        System.out.println("Job4jjj\b\b");

    }
}
