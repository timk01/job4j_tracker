package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateItem(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item oldItem = new Item("old item");
        tracker.add(oldItem);
        String replacedItem = "replaced item";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(oldItem.getId()), replacedItem, "1"}
        );
        List<UserAction> actions = List.of(
                new EditItem(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        assertThat(tracker.findById(oldItem.getId()).getName()).isEqualTo(replacedItem);
    }

    @Test
    public void whenNothingToEdit() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "replaced item", "1"}
        );
        List<UserAction> actions = List.of(
                new EditItem(in, out, tracker),
                new ExitProgram(out)
        );
        List<Item> items = tracker.findAll();
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
                new String[]{"0", String.valueOf(replacedItemId), replacedItem.getName(), "1"}
        );
        List<UserAction> actions = List.of(
                new EditItem(in, out, tracker),
                new ExitProgram(out)
        );
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
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new DeleteItem(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenNothingToDelete() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        List<UserAction> actions = List.of(
                new DeleteItem(in, out, tracker),
                new ExitProgram(out)
        );
        List<Item> items = tracker.findAll();
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
                new String[]{"0", String.valueOf(deletedItemId), "1"}
        );
        List<UserAction> actions = List.of(
                new DeleteItem(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        assertThat(tracker.findAll()).isNotEmpty();
        assertThat(tracker.findById(1000)).isNull();
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        List<UserAction> actions = List.of(
                new ExitProgram(out)
        );
        String ln = System.lineSeparator();
        new ConsoleUI(in, out, actions).run();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new EditItem(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Item is changed successfully." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenShowAllItemsItemTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first item"));
        Item second = tracker.add(new Item("second item"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new ShowAllItems(out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + first + ln
                        + second + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenNoItemsToShowTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new ShowAllItems(out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Storage has no items" + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindItemByIdTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(first.getId()), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new FindItemById(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + first + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenNoItemIsFoundByIdIdTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first item"));
        int searchId = 1000;
        Input in = new StubInput(
                new String[]{"0", String.valueOf(searchId), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new FindItemById(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Item with id " + searchId + " cannot be found" + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindItemsByNameTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first item"));
        Item second = tracker.add(new Item("first item"));
        Item third = tracker.add(new Item("another item"));
        Input in = new StubInput(
                new String[]{"0", first.getName(), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new FindItemsByName(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + first + ln
                        + second + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenNoItemsAreFoundByNameTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first item"));
        Item second = tracker.add(new Item("first item"));
        Item third = tracker.add(new Item("another item"));
        Item fourthNotAdded = new Item("another one item");
        Input in = new StubInput(
                new String[]{"0", fourthNotAdded.getName(), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new FindItemsByName(in, out, tracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Cannot find items with name: " + fourthNotAdded.getName() + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1", "0"}
        );
        List<UserAction> actions = List.of(
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select from 0 and till 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }
}