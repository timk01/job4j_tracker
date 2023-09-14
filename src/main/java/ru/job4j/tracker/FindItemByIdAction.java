package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {

    private final Input input;
    private final Output out;
    private final Tracker tracker;

    public FindItemByIdAction(Input input, Output out, Tracker tracker) {
        this.input = input;
        this.out = out;
        this.tracker = tracker;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute() {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Item with id " + id + " cannot be found");
        }
        return true;
    }
}
