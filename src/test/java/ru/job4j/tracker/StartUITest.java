package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "edited item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName()).isEqualTo("edited item");
    }

    @Test
    public void whenDeleteFirstItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("new item");
        Item item2 = new Item("old item");
        tracker.add(item1);
        tracker.add(item2);
        String[] answers = {
                String.valueOf(item1.getId())
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item1.getId());
        Item notDeleted = tracker.findById(item2.getId());
        assertThat(notDeleted.getName()).isEqualTo("old item");
        assertThat(deleted).isNull();
    }

    @Test
    public void whenDeleteSecondItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("new item");
        Item item2 = new Item("old item");
        tracker.add(item1);
        tracker.add(item2);
        String[] answers = {
                String.valueOf(item2.getId())
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item2.getId());
        Item notDeleted = tracker.findById(item1.getId());
        assertThat(notDeleted.getName()).isEqualTo("new item");
        assertThat(deleted).isNull();
    }

    @Test
    public void whenDeleteBothItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("new item");
        Item item2 = new Item("old item");
        tracker.add(item1);
        tracker.add(item2);
        String[] answers = {
                String.valueOf(item1.getId()),
                String.valueOf(item2.getId())
        };
        Input input = new StubInput(answers);
        StartUI.deleteItem(input, tracker);
        StartUI.deleteItem(input, tracker);
        Item deletedFirst = tracker.findById(item2.getId());
        Item deletedSecond = tracker.findById(item1.getId());
        assertThat(deletedFirst).isNull();
        assertThat(deletedSecond).isNull();
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void whenCannotDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                "10"
        };
        Input input = new StubInput(answers);
        StartUI.deleteItem(input, tracker);
        Item supposedlyDeleted = tracker.findById(item.getId());
        assertThat(supposedlyDeleted).isNotNull();
        assertThat(supposedlyDeleted.getName()).isEqualTo("new item");
        assertThat(tracker.findAll()).isNotEmpty();
    }
}