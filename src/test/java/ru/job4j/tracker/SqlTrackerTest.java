package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void saveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void findNothingOnEmptyTable() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void replaceItemOnEmptyTable() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        assertThat(tracker.replace(item.getId(), new Item())).isFalse();
    }

    @Test
    public void replaceExistedItemWithProperId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item oldItem = new Item("item");
        tracker.add(oldItem);
        int id = oldItem.getId();
        Item newItem =  new Item("new item");
        tracker.replace(id, newItem);
        assertThat(tracker.findById(id).getName()).isEqualTo(newItem.getName());
    }

    @Test
    public void replaceExistedItemWithWrongId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item oldItem = new Item("item");
        tracker.add(oldItem);
        assertThat(tracker.findAll()).hasSize(1);
        int id = oldItem.getId();
        Item newItem =  new Item("new item");
        tracker.replace(id + 1, newItem);
        assertThat(tracker.findAll()).hasSize(1);
        assertThat(tracker.findById(id).getName()).isEqualTo(oldItem.getName());
    }

    @Test
    public void replaceWhileNoItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item oldItem = new Item("item");
        int id = oldItem.getId();
        Item newItem =  new Item("new item");
        tracker.replace(id + 1, newItem);
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void deleteExistedItemWithProperId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item oldItem = new Item("item");
        tracker.add(oldItem);
        int id = oldItem.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void deleteExistedItemWithWrongId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item oldItem = new Item("item");
        tracker.add(oldItem);
        int id = oldItem.getId();
        tracker.delete(id + 1);
        assertThat(tracker.findById(id).getName()).isEqualTo(oldItem.getName());
    }

    @Test
    public void deleteWhileNoItems() {
        SqlTracker tracker = new SqlTracker(connection);
        assertThat(tracker.findAll()).isEmpty();
        Item oldItem = new Item("item");
        int id = oldItem.getId();
        tracker.delete(id);
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void findMultipleNamedItems() {
        SqlTracker tracker = new SqlTracker(connection);
        String name = "item";
        Item item = new Item(name);
        tracker.add(item);
        tracker.add(item);
        tracker.add(item);
        Item item2 = new Item("item2");
        tracker.add(item2);
        assertThat(tracker.findAll()).hasSize(4);
        assertThat(tracker.findByName(name)).hasSize(3);
    }

    @Test
    public void findNothingByNameOnEmptyTable() {
        SqlTracker tracker = new SqlTracker(connection);
        String name = "item";
        Item item = new Item(name);
        assertThat(tracker.findAll()).isEmpty();
        assertThat(tracker.findByName(name)).isEmpty();
    }

    @Test
    public void findAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        String name = "item";
        Item item = new Item(name);
        tracker.add(item);
        tracker.add(item);
        tracker.add(item);
        Item item2 = new Item("item2");
        tracker.add(item2);
        assertThat(tracker.findAll()).hasSize(4);
        assertThat(tracker.findAll().get(3)).isEqualTo(item2);
    }
}