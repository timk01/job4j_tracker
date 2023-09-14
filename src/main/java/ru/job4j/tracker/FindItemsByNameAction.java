package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction {

    private final Input input;
    private final Output out;
    private Tracker tracker;

    public FindItemsByNameAction(Input input, Output out, Tracker tracker) {
        this.input = input;
        this.out = out;
        this.tracker = tracker;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute() {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] byName = tracker.findByName(name);
        if (byName.length > 0) {
            for (Item item : byName) {
                out.println(item);
            }
        } else {
            out.println("Cannot find items with name: " + name);
        }
        return true;
    }
}
