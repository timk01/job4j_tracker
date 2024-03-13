package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.MemTracker;

public class DeleteItem implements UserAction {

    private final Input input;
    private final Output out;
    private final Store memTracker;

    public DeleteItem(Input input, Output out, Store memTracker) {
        this.input = input;
        this.out = out;
        this.memTracker = memTracker;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute() {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        Item item = memTracker.findById(id);
        memTracker.delete(id);
        out.println(item != null ? "Item is deleted successfully." : "Cannot delete the item.");
        return true;
    }
}
