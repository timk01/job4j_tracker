package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class CreateManyItems implements UserAction {

    private final Input input;
    private final Output out;
    private final Store memTracker;

    public CreateManyItems(Input input, Output out, Store memTracker) {
        this.input = input;
        this.out = out;
        this.memTracker = memTracker;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute() {
        out.println("=== Create many items ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            memTracker.add(new Item("Заявка № " + i));
        }
        out.println("Добавлено заявок: " + count);
        return true;
    }
}