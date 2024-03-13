package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class ShowAllItems implements UserAction {

    private final Output out;
    private final Store memTracker;

    public ShowAllItems(Output out, Store memTracker) {
        this.out = out;
        this.memTracker = memTracker;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute() {
        out.println("=== Show all items ===");
        List<Item> items = memTracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Storage has no items");
        }
        return true;
    }
}
