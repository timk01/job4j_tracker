package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction {

    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
