package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        if (item == null) {
            return null;
        }
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    private int indexOf(int id) {
        int rsl = -1;
        if (id < 1) {
            return -1;
        }
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1 && item != null;
        if (result) {
            items[index].setName(item.getName());
        }
        return result;
    }

    public void delete(int id) {
        int elemIndex = indexOf(id);
        if (elemIndex == -1) {
            return;
        }
        items[elemIndex] = null;
        System.arraycopy(items, elemIndex + 1, items, elemIndex, size - 1 - elemIndex);
        items[size - 1] = null;
        size--;
    }
}