package view;

import domain.bean.Item;

import javax.swing.*;
import java.sql.*;
import java.util.Observable;
import java.util.logging.Logger;

public class ItemModel extends Observable {
    private static int rowNumber;
    private Logger logger = Logger.getLogger(ItemModel.class.getSimpleName());
    private Connection connection;
    private ResultSet resultSet;

    public ItemModel() {
        try {
            connection = DbConnector.getConnection();
            initItems();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    public void newItem() {
        try {
            rowNumber = resultSet.getRow();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void initItems() throws SQLException {

        String query = "SELECT * FROM ITEM";

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        resultSet = statement.executeQuery(query);
    }

    public void updateView() throws Exception {
        int itemId = resultSet.getInt(1);
        String itemName = resultSet.getString(2);
        int categoryId = resultSet.getInt(3);
        double unitPrice = resultSet.getDouble(4);
        Item item = new Item(itemId, itemName, unitPrice, categoryId);
        setChanged();
        notifyObservers(item);
    }

    public void getFirstItem() throws Exception {
        if (resultSet.isFirst())
            JOptionPane.showMessageDialog(null, "First item reached.");
        else {
            resultSet.first();
            updateView();
        }
    }

    public void getNextItem() throws Exception {
        if (resultSet.isLast())
            JOptionPane.showMessageDialog(null, "Last item reached.");
        else {
            resultSet.next();
            updateView();
        }
    }

    public void getPreviousItem() throws Exception {
        if (resultSet.isFirst())
            JOptionPane.showMessageDialog(null, "First item reached.");
        else {
            resultSet.previous();
            updateView();
        }
    }

    public void getLastItem() throws Exception {
        if (resultSet.isLast())
            JOptionPane.showMessageDialog(null, "Last item reached.");
        else {
            resultSet.last();
            updateView();
        }
    }

    public void getCurrentItem() throws Exception {
        updateView();
    }

    public void addItem(Item newItem) throws SQLException {
        String query = "INSERT INTO ITEM (ID, NAME, UNIT_PRICE, CATEGORY_ID) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, newItem.getId());
            pstmt.setString(2, newItem.getName());
            pstmt.setDouble(3, newItem.getUnitPrice());
            pstmt.setInt(4, newItem.getCategoryId());
            pstmt.executeUpdate();
        }
    }

    public void deleteItem(int itemId) throws SQLException {
        String sql = "DELETE FROM ITEM WHERE ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, itemId);
            pstmt.executeUpdate();
        }
    }

    public void updateItem(Item item) throws SQLException {
        String query = "UPDATE ITEM SET ID = ?, NAME = ?, UNIT_PRICE = ?, CATEGORY_ID = ?";
        query += " WHERE ID = ? ";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setDouble(3, item.getUnitPrice());
            pstmt.setInt(4, item.getCategoryId());
            pstmt.executeUpdate();
        }
    }
}
