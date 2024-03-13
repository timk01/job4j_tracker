package ru.job4j.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.sql.Timestamp.valueOf;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * keep not that we first add elem, and only after if check the serial id
     * @param item
     * @return item of type Item
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * it fully replaces the old item with new one but FIRST searches for it
     * <p>
     * or it won't find it at all (аin this case you see 0 in result(set))
     * @param id
     * @param item
     * @return boolean
     */
    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void findItemsByQuery(PreparedStatement statement, List<Item> items) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                items.add(new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("created").toLocalDateTime()
                ));
            }
        }
    }

    /**
     * had to add public Item constructor:
     * public Item(int id, String name, LocalDateTime created)
     * <p>
     * for LDT i use toLocalDateTime since we have TimeStamp in table
     * </p>
     * see also findItemsByQuery
     * @return list of found Items (or empty list)
     */

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items")) {
            findItemsByQuery(statement, items);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items where name = ?")) {
            statement.setString(1, key);
            findItemsByQuery(statement, items);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}