package ru.job4j.tracker;

public class EditItemAction implements UserAction {

    private final Input input;
    private final Output out;
    private final Tracker tracker;

    public EditItemAction(Input input, Output out, Tracker tracker) {
        this.input = input;
        this.out = out;
        this.tracker = tracker;
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
        if (tracker.replace(id, item)) {
            out.println("Item is changed successfully.");
        } else {
            out.println("Cannot change the item.");
        }
        return true;
    }
}
