package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("cannot find the key: " + key);
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"one", "two"}, "three");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
