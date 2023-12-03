package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

public class ConsoleUI {

    private final Input input;
    private final Output out;
    private final UserAction[] actions;

    public ConsoleUI(Input input, Output out, UserAction[] actions) {
        this.input = input;
        this.out = out;
        this.actions = actions;
    }

    public void run() {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select from 0 and till " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute();
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(input, output, tracker),
                new ShowAllItems(output, tracker),
                new EditItem(input, output, tracker),
                new DeleteItem(input, output, tracker),
                new FindItemById(input, output, tracker),
                new FindItemsByName(input, output, tracker),
                new ExitProgram(output)
        };
        new ConsoleUI(input, output, actions).run();
    }
}