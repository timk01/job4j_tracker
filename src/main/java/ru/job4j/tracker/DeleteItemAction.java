package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {

    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        out.println(item != null ? "Item is deleted successfully." : "Cannot delete the item.");
        return true;
    }
}
