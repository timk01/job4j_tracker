package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class ShowAllItems implements UserAction {

    private final Output out;
    private final Tracker tracker;

    public ShowAllItems(Output out, Tracker tracker) {
        this.out = out;
        this.tracker = tracker;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute() {
        out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
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
