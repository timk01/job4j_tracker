package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {

    private final Output out;
    private final Tracker tracker;

    public ShowAllItemsAction(Output out, Tracker tracker) {
        this.out = out;
        this.tracker = tracker;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute() {
        out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Storage has no items");
        }
        return true;
    }
}
