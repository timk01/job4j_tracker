package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.MemTracker;

public class EditItem implements UserAction {

    private final Input input;
    private final Output out;
    private final Store memTracker;

    public EditItem(Input input, Output out, Store memTracker) {
        this.input = input;
        this.out = out;
        this.memTracker = memTracker;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute() {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (memTracker.replace(id, item)) {
            out.println("Item is changed successfully.");
        } else {
            out.println("Cannot change the item.");
        }
        return true;
    }
}
