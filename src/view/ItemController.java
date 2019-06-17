package view;

import domain.bean.Item;

import javax.swing.*;
import java.util.logging.Logger;

public class ItemController {

    private Logger logger = Logger.getLogger(ItemController.class.getSimpleName());

    private ItemView view;
    private ItemModel model;

    public ItemController(ItemView view, ItemModel model) {
        this.view = view;
        this.model = model;

        model.addObserver(view);

        // navigation
        view.getFirstButton().addActionListener(event -> getFirstItem());
        view.getLastButton().addActionListener(event -> getLastItem());
        view.getNextButton().addActionListener(event -> getNextItem());
        view.getPreviousButton().addActionListener(event -> getPreviousItem());

        // crud
        view.getNewButton().addActionListener(event -> newItemButtonClick());
        view.getCancelButton().addActionListener(event -> cancelButtonClick());

        view.getAddButton().addActionListener(event -> addItem());
        view.getDeleteButton().addActionListener(event -> deleteItem());
        view.getUpdateButton().addActionListener(event -> updateItem());

        getFirstItem();
    }

    private void getFirstItem() {
        try {
            model.getFirstItem();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    private void getLastItem() {
        try {
            model.getLastItem();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    private void getNextItem() {
        try {
            model.getNextItem();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    private void getPreviousItem() {
        try {
            model.getPreviousItem();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    private void getCurrentItem() {
        try {
            model.getCurrentItem();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    private void newItemButtonClick() {
        model.newItem();

        view.resetItemInfoValues();
        view.disableNavigationPanel();
        view.disableCrudPanel();
    }

    private void cancelButtonClick() {
        view.enableNavigationPanel();
        view.enableCrudPanel();

        getCurrentItem();
    }

    private void addItem() {
        try {
            int id = view.getItemIdFieldValue();
            String name = view.getItemNameFieldValue();
            double unitPrice = view.getUnitPriceFieldValue();
            int categoryId = view.getCategoryIdFieldValue();

            Item newItem = new Item(id, name, unitPrice, categoryId);
            model.addItem(newItem);

            JOptionPane.showMessageDialog(view, "Item added.");
            logger.info("Item " + id + " added!");
            newItemButtonClick();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Add failed!", JOptionPane.ERROR_MESSAGE);
            logger.severe(ex.getMessage());
        }
    }

    private void updateItem() {
        try {
            int id = view.getItemIdFieldValue();
            String name = view.getItemNameFieldValue();
            double unitPrice = view.getUnitPriceFieldValue();
            int categoryId = view.getCategoryIdFieldValue();

            Item item = new Item(id, name, unitPrice, categoryId);
            model.updateItem(item);

            JOptionPane.showMessageDialog(view, "Item updated.");
            logger.info("Item " + id + " updated!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Update failed!", JOptionPane.ERROR_MESSAGE);
            logger.severe(ex.getMessage());
        }
    }

    private void deleteItem() {
        try {
            int id = view.getItemIdFieldValue();
            model.deleteItem(id);

            JOptionPane.showMessageDialog(view, "Item deleted.");
            logger.info("Item " + id + " deleted!");
            model.getNextItem();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Delete failed!", JOptionPane.ERROR_MESSAGE);
            logger.severe(ex.getMessage());
        }
    }

}
