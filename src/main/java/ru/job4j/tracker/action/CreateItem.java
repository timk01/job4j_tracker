package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.MemTracker;

public class CreateItem implements UserAction {

    private final Input input;
    private final Output out;
    private final Store memTracker;

    public CreateItem(Input input, Output out, Store memTracker) {
        this.input = input;
        this.out = out;
        this.memTracker = memTracker;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute() {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        out.println("Added item: " + item);
        return true;
    }
}
