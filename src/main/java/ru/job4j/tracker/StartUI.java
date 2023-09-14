package ru.job4j.tracker;

public class StartUI {

    private final Input input;
    private final Output out;

    public StartUI(Input input, Output out) {
        this.input = input;
        this.out = out;
    }

    public void init(UserAction[] actions) {
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
        new StartUI(input, output).init(actions);
    }
}