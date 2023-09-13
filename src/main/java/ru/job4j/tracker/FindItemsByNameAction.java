package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] byName = tracker.findByName(name);
        if (byName.length > 0) {
            for (Item item : byName) {
                System.out.println(item);
            }
        } else {
            System.out.println("Cannot find items with name: " + name);
        }
        return true;
    }
}
