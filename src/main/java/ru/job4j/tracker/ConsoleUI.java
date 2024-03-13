package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class ConsoleUI {

    private final Input input;
    private final Output out;
    private final List<UserAction> actions;

    public ConsoleUI(Input input, Output out, List<UserAction> actions) {
        this.input = input;
        this.out = out;
        this.actions = actions;
    }

    public void run() {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (Input.between(select, 0, actions.size())) {
                UserAction action = actions.get(select);
                run = action.execute();
            } else {
                out.println("Wrong input, you can select from 0 and till " + (actions.size() - 1));
            }
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(
                output, new ConsoleInput()
        );
        try (Store tracker = new SqlTracker()) {
            List<UserAction> actions = List.of(
                    new CreateItem(input, output, tracker),
                    new ShowAllItems(output, tracker),
                    new EditItem(input, output, tracker),
                    new DeleteItem(input, output, tracker),
                    new FindItemById(input, output, tracker),
                    new FindItemsByName(input, output, tracker),
                    new ExitProgram(output)
            );
            new ConsoleUI(input, output, actions).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}