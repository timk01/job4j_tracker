package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConsoleUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemAction(in, out, tracker),
                new ExitProgramAction(out)
        };
        new ConsoleUI(in, out, actions).run();
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item oldItem = new Item("old item");
        tracker.add(oldItem);
        String replacedItem = "replaced item";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(oldItem.getId()), replacedItem, "1"}
        );
        UserAction[] actions = {
                new EditItemAction(in, out, tracker),
                new ExitProgramAction(out)
        };
        new ConsoleUI(in, out, actions).run();
        assertThat(tracker.findById(oldItem.getId()).getName()).isEqualTo(replacedItem);
    }

    @Test
    public void whenNothingToEdit() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "replaced item", "1"}
        );
        UserAction[] actions = {
                new EditItemAction(in, out, tracker),
                new ExitProgramAction(out)
        };
        Item[] items = tracker.findAll();
        assertThat(items).isEmpty();
        new ConsoleUI(in, out, actions).run();
        items = tracker.findAll();
        assertThat(items).isEmpty();
        Item item = tracker.findById(1);
        assertThat(item).isNull();
    }

    @Test
    public void whenEditItemWithWrongId() {
        Tracker tracker = new Tracker();
        Item oldItem = new Item("old item");
        tracker.add(oldItem);
        Item replacedItem = new Item("replaced item");
        int replacedItemId = 1000;
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(replacedItemId), replacedItem.getName(), "1"}
        );
        UserAction[] actions = {
                new EditItemAction(in, out, tracker),
                new ExitProgramAction(out)
        };
        new ConsoleUI(in, out, actions).run();
        replacedItem = tracker.findById(replacedItemId);
        assertThat(replacedItem).isNull();
        assertThat(tracker.findById(oldItem.getId()).getName()).isEqualTo(oldItem.getName());
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(in, out, tracker),
                new ExitProgramAction(out)
        };
        new ConsoleUI(in, out, actions).run();
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenNothingToDelete() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(in, out, tracker),
                new ExitProgramAction(out)
        };
        Item[] items = tracker.findAll();
        assertThat(items).isEmpty();
        new ConsoleUI(in, out, actions).run();
        items = tracker.findAll();
        assertThat(items).isEmpty();
        assertThat(tracker.findById(1)).isNull();
    }

    @Test
    public void whenDeleteItemWithWrongId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old item"));
        int deletedItemId = 1000;
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(deletedItemId), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(in, out, tracker),
                new ExitProgramAction(out)
        };
        new ConsoleUI(in, out, actions).run();
        assertThat(tracker.findAll()).isNotEmpty();
        assertThat(tracker.findById(1000)).isNull();
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        UserAction[] actions = {
                new ExitProgramAction(out)
        };
        String ln = System.lineSeparator();
        new ConsoleUI(in, out, actions).run();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit" + ln
        );
    }
}