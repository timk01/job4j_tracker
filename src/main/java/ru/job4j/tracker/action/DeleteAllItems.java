package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class DeleteAllItems implements UserAction {

    private final Input input;
    private final Output out;
    private final Store memTracker;

    public DeleteAllItems(Input input, Output out, Store memTracker) {
        this.input = input;
        this.out = out;
        this.memTracker = memTracker;
    }

    @Override
    public String name() {
        return "Delete all items";
    }

    @Override
    public boolean execute() {
        out.println("=== Delete all items ===");
        List<Item> allItems = memTracker.findAll();
        List<Integer> collect = allItems.stream()
                .map(Item::getId).toList();
        for (Integer integer : collect) {
            memTracker.delete(integer);
        }
        out.println("=== Все заявки удалены ===");
        return true;
    }
}