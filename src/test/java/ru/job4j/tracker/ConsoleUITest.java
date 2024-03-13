package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Store memTracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateItem(in, out, memTracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        assertThat(memTracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Store memTracker = new MemTracker();
        Item oldItem = new Item("old item");
        memTracker.add(oldItem);
        String replacedItem = "replaced item";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(oldItem.getId()), replacedItem, "1"}
        );
        List<UserAction> actions = List.of(
                new EditItem(in, out, memTracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        assertThat(memTracker.findById(oldItem.getId()).getName()).isEqualTo(replacedItem);
    }

    @Test
    public void whenNothingToEdit() {
        Store memTracker = new MemTracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "replaced item", "1"}
        );
        List<UserAction> actions = List.of(
                new EditItem(in, out, memTracker),
                new ExitProgram(out)
        );
        List<Item> items = memTracker.findAll();
        assertThat(items).isEmpty();
        new ConsoleUI(in, out, actions).run();
        items = memTracker.findAll();
        assertThat(items).isEmpty();
        Item item = memTracker.findById(1);
        assertThat(item).isNull();
    }

    @Test
    public void whenEditItemWithWrongId() {
        Store memTracker = new MemTracker();
        Item oldItem = new Item("old item");
        memTracker.add(oldItem);
        Item replacedItem = new Item("replaced item");
        int replacedItemId = 1000;
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(replacedItemId), replacedItem.getName(), "1"}
        );
        List<UserAction> actions = List.of(
                new EditItem(in, out, memTracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        replacedItem = memTracker.findById(replacedItemId);
        assertThat(replacedItem).isNull();
        assertThat(memTracker.findById(oldItem.getId()).getName()).isEqualTo(oldItem.getName());
    }

    @Test
    public void whenDeleteItem() {
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Old item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new DeleteItem(in, out, memTracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        assertThat(memTracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenNothingToDelete() {
        Store memTracker = new MemTracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        List<UserAction> actions = List.of(
                new DeleteItem(in, out, memTracker),
                new ExitProgram(out)
        );
        List<Item> items = memTracker.findAll();
        assertThat(items).isEmpty();
        new ConsoleUI(in, out, actions).run();
        items = memTracker.findAll();
        assertThat(items).isEmpty();
        assertThat(memTracker.findById(1)).isNull();
    }

    @Test
    public void whenDeleteItemWithWrongId() {
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Old item"));
        int deletedItemId = 1000;
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(deletedItemId), "1"}
        );
        List<UserAction> actions = List.of(
                new DeleteItem(in, out, memTracker),
                new ExitProgram(out)
        );
        new ConsoleUI(in, out, actions).run();
        assertThat(memTracker.findAll()).isNotEmpty();
        assertThat(memTracker.findById(1000)).isNull();
        assertThat(memTracker.findById(item.getId()).getName()).isEqualTo(item.getName());
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
        Store memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new EditItem(in, out, memTracker),
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
        Store memTracker = new MemTracker();
        Item first = memTracker.add(new Item("first item"));
        Item second = memTracker.add(new Item("second item"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new ShowAllItems(out, memTracker),
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
        Store memTracker = new MemTracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new ShowAllItems(out, memTracker),
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
        Store memTracker = new MemTracker();
        Item first = memTracker.add(new Item("first item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(first.getId()), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new FindItemById(in, out, memTracker),
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
        Store memTracker = new MemTracker();
        Item first = memTracker.add(new Item("first item"));
        int searchId = 1000;
        Input in = new StubInput(
                new String[]{"0", String.valueOf(searchId), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new FindItemById(in, out, memTracker),
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
        Store memTracker = new MemTracker();
        Item first = memTracker.add(new Item("first item"));
        Item second = memTracker.add(new Item("first item"));
        Item third = memTracker.add(new Item("another item"));
        Input in = new StubInput(
                new String[]{"0", first.getName(), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new FindItemsByName(in, out, memTracker),
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
        Store memTracker = new MemTracker();
        Item first = memTracker.add(new Item("first item"));
        Item second = memTracker.add(new Item("first item"));
        Item third = memTracker.add(new Item("another item"));
        Item fourthNotAdded = new Item("another one item");
        Input in = new StubInput(
                new String[]{"0", fourthNotAdded.getName(), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(
                new FindItemsByName(in, out, memTracker),
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