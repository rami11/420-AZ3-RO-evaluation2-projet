import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ItemController {

    private static int i = 0;
    private Logger logger = Logger.getLogger(ItemController.class.getSimpleName());

    private List<Item> items = new ArrayList<>();
    private Connection connection;

    private PropertyChangeSupport support;

    public ItemController() {
        support = new PropertyChangeSupport(this);

        try {
            connection = DbConnector.getConnection();
            loadItems();

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public Item getFirstItem() {
        i = 0;
        return items.get(i);
    }

    public Item getLastItem() {
        i = items.size() - 1;
        return items.get(i);
    }

    public Item getNextItem() {
        return items.get(i < items.size() - 1 ? ++i : i);
    }

    public Item getPreviousItem() {
        return items.get(i > 0 ? --i : i);
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


}
