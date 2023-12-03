package ru.job4j.tracker.action;

import ru.job4j.tracker.output.Output;

public class ExitProgram implements UserAction {

    private final Output out;

    public ExitProgram(Output out) {
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
