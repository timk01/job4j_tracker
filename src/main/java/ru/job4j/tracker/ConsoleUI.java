package ru.job4j.tracker;

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
            UserAction action = actions[select];
            run = action.execute();
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemAction(input, output, tracker),
                new ShowAllItemsAction(output, tracker),
                new EditItemAction(input, output, tracker),
                new DeleteItemAction(input, output, tracker),
                new FindItemByIdAction(input, output, tracker),
                new FindItemsByNameAction(input, output, tracker),
                new ExitProgramAction(output)
        };
        new ConsoleUI(input, output, actions).run();
    }
}