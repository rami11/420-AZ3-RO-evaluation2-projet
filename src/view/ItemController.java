package view;

import domain.bean.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class ItemController {

    private static int i = 0;
    private Logger logger = Logger.getLogger(ItemController.class.getSimpleName());

    private List<Item> items = new ArrayList<>();
    private Item currentItem;

    private Connection connection;

    private ItemView view;

    public ItemController(ItemView view) {
        this.view = view;

        try {
            connection = DbConnector.getConnection();
            loadItems();

            currentItem = getFirstItem().isPresent() ? getFirstItem().get() : null;

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    private void loadItems() throws SQLException {

        String query = "SELECT * FROM ITEM";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            logger.info("Loading items...");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double unitPrice = resultSet.getDouble("unit_price");
                int categoryId = resultSet.getInt("category_id");

                items.add(new Item(id, name, unitPrice, categoryId));
            }
            logger.info("Items loaded.");
        }
    }

    public void addItem(Item newItem) throws SQLException {
        String query = "INSERT INTO ITEM (ID, NAME, UNIT_PRICE, CATEGORY_ID) VALUES ("
                + newItem.getId() + ","
                + "'" + newItem.getName() + "'" + ","
                + newItem.getUnitPrice() + ","
                + newItem.getCategoryId()
                + ")";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            items.add(newItem);

        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw e;
        }
    }

    public void deleteItem(int itemId) throws SQLException {
        String query = "DELETE FROM ITEM WHERE ID = " + itemId;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);


        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new SQLException("Delete item failed!");
        }
    }

    public Optional<Item> getFirstItem() {
        if (items != null && !items.isEmpty()) {
            i = 0;
            currentItem = items.get(i);
            return Optional.ofNullable(currentItem);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Item> getLastItem() {
        if (items != null && !items.isEmpty()) {
            i = items.size() - 1;
            currentItem = items.get(i);
            return Optional.of(currentItem);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Item> getNextItem() {
        if (items != null && !items.isEmpty()) {
            currentItem = items.get(i < items.size() - 1 ? ++i : i);
            return Optional.of(currentItem);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Item> getPreviousItem() {
        if (items != null && !items.isEmpty()) {
            currentItem = items.get(i > 0 ? --i : i);
            return Optional.of(currentItem);
        } else {
            return Optional.empty();
        }
    }

    public Item getCurrentItem() {
        return currentItem;
    }

    public void showNextItem() {
        getNextItem().ifPresent(view::setItemViewValues);
    }

    public void showPreviousItem() {
        getPreviousItem().ifPresent(view::setItemViewValues);
    }

    public void showFirstItem() {
        getFirstItem().ifPresent(view::setItemViewValues);
    }

    public void showLastItem() {
        getLastItem().ifPresent(view::setItemViewValues);
    }

    public void showCurrentItem() {
        if (currentItem != null) {
            view.setItemViewValues(currentItem);
        }
    }

    public void newItemButtonClick() {
        view.setItemInfoEditable(true);
        view.resetItemInfoValues();
        view.disableNavigationPanel();
        view.disableCrudPanel();
    }

    public void cancelButtonClick() {
        view.setItemInfoEditable(false);
        this.showCurrentItem();
        view.enableNavigationPanel();
        view.enableCrudPanel();
    }

    public void updateButtonClick() {
        view.setItemInfoEditable(true);
        view.disableNavigationPanel();
        view.disableCrudPanel();
    }

}
