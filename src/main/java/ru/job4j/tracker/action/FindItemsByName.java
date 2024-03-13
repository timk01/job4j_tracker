package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class FindItemsByName implements UserAction {

    private final Input input;
    private final Output out;
    private final Store memTracker;

    public FindItemsByName(Input input, Output out, Store memTracker) {
        this.input = input;
        this.out = out;
        this.memTracker = memTracker;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute() {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = memTracker.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Cannot find items with name: " + name);
        }
        return true;
    }
}
