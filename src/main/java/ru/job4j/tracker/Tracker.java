package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<Item> findByName(String key) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (Objects.equals(item.getName(), key)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        Item oldItem = findById(id);
        if (oldItem == null) {
            return false;
        }
        int oldItemIndex = items.indexOf(oldItem);
        item.setId(id);
        items.set(oldItemIndex, item);
        return true;
    }

    public void delete(int id) {
        Item oldItem = findById(id);
        int oldItemIndex = items.indexOf(oldItem);
        for (Item item : items) {
            if (item.getId() == id) {
                items.remove(oldItemIndex);
                break;
            }
        }
    }
}