package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int resultSize = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (Objects.equals(item.getName(), key)) {
                result[resultSize++] = item;
            }
        }
        return Arrays.copyOf(result, resultSize);
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        int resultSize = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item != null) {
                result[resultSize++] = item;
            }
        }
        return Arrays.copyOf(result, resultSize);
    }
}