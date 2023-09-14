package ru.job4j.tracker;

public class CreateItemAction implements UserAction {

    private final Input input;
    private final Output out;
    private final Tracker tracker;

    public CreateItemAction(Input input, Output out, Tracker tracker) {
        this.input = input;
        this.out = out;
        this.tracker = tracker;
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
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
