package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class FindItemsByName implements UserAction {

    private final Input input;
    private final Output out;
    private final Tracker tracker;

    public FindItemsByName(Input input, Output out, Tracker tracker) {
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
