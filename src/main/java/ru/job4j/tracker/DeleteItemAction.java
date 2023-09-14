package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {

    private final Input input;
    private final Output out;
    private final Tracker tracker;

    public DeleteItemAction(Input input, Output out, Tracker tracker) {
        this.input = input;
        this.out = out;
        this.tracker = tracker;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute() {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        out.println(item != null ? "Item is deleted successfully." : "Cannot delete the item.");
        return true;
    }
}
