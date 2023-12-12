package ru.job4j.vartasks;

/**
 * first itt will be not changed (wrappers are IMMUTABLE) with method.
 * ((copy of link will be changed and discarded))
 * but ++ - other deal. unboxing, ++, boxing,
 */
public class RefTask {
    public static void main(String[] args) {
        Integer value = 1;
        RefTask.change(value);
        System.out.println(value);
        value++;
        System.out.println(value);
    }

    public static void change(Integer value) {
        ++value;
    }
}