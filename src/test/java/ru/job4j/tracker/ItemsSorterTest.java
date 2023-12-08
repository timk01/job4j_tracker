package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.CreateItem;
import ru.job4j.tracker.action.ExitProgram;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemsSorterTest {

    @Test
    public void whenSortAscByName() {
        List<Item> items = Arrays.asList(
            new Item(1, "Sort"),
            new Item(3, "Open task"),
            new Item(2, "Close")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Close"),
                new Item(3, "Open task"),
                new Item(1, "Sort")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Sort"),
                new Item(3, "Open task"),
                new Item(2, "Close")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Sort"),
                new Item(3, "Open task"),
                new Item(2, "Close")
        );
        assertThat(items).isEqualTo(expected);
    }

}