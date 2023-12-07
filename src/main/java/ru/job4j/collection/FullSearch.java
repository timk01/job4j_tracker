package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public Set<String> extractNumber(List<Task> taskList) {
        Set<String> tasks = new HashSet<>();
        for (Task task : taskList) {
            tasks.add(task.getNumber());
        }
        return tasks;
    }
}
