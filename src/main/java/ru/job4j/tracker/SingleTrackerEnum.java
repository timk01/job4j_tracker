package ru.job4j.tracker;

import java.util.List;

public enum SingleTrackerEnum {

    TRACKER_SINGLETON();

    private final MemTracker memTracker = new MemTracker();

    private SingleTrackerEnum() {
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public void delete(int id) {
        memTracker.delete(id);
    }
}
