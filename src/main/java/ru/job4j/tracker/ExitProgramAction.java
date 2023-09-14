package ru.job4j.tracker;

public class ExitProgramAction implements UserAction {

    private final Output out;

    public ExitProgramAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute() {
        out.println("=== Exit Program ===");
        return false;
    }
}
