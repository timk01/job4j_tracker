package ru.job4j.tracker.action;

import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;

public class FindItemById implements UserAction {

    private final Input input;
    private final Output out;
    private final Store memTracker;

    public FindItemById(Input input, Output out, Store memTracker) {
        this.input = input;
        this.out = out;
        this.memTracker = memTracker;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute() {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = memTracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Item with id " + id + " cannot be found");
        }
        return true;
    }
}
