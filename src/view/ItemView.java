package view;

import domain.bean.Item;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ItemView extends JFrame implements Observer {

    private NavigationPanel navigationPanel;
    private CrudPanel crudPanel;
    private ItemInfoPanel itemInfoPanel;

    public ItemView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        navigationPanel = new NavigationPanel();
        crudPanel = new CrudPanel();
        itemInfoPanel = new ItemInfoPanel();

        getContentPane().add(navigationPanel, BorderLayout.NORTH);
        getContentPane().add(crudPanel, BorderLayout.SOUTH);
        getContentPane().add(itemInfoPanel, BorderLayout.CENTER);

        pack();
    }

    public void resetItemInfoValues() {
        itemInfoPanel.resetItemViewValues();
    }

    public void disableNavigationPanel() {
        navigationPanel.disablePanel();
    }

    public void disableCrudPanel() {
        crudPanel.setPanelEnabled(false);
    }

    public void enableNavigationPanel() {
        navigationPanel.enablePanel();
    }

    public void enableCrudPanel() {
        crudPanel.setPanelEnabled(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        itemInfoPanel.setItemViewValues((Item) arg);
    }

    public JButton getFirstButton() {
        return navigationPanel.getFirstButton();
    }

    public JButton getPreviousButton() {
        return navigationPanel.getPreviousButton();
    }

    public JButton getNextButton() {
        return navigationPanel.getNextButton();
    }

    public JButton getLastButton() {
        return navigationPanel.getLastButton();
    }

    public JButton getNewButton() {
        return crudPanel.getNewButton();
    }

    public JButton getUpdateButton() {
        return crudPanel.getUpdateButton();
    }

    public JButton getDeleteButton() {
        return crudPanel.getDeleteButton();
    }

    public JButton getAddButton() {
        return crudPanel.getAddButton();
    }

    public JButton getCancelButton() {
        return crudPanel.getCancelButton();
    }

    public int getItemIdFieldValue() {
        return itemInfoPanel.getItemId();
    }

    public String getItemNameFieldValue() {
        return itemInfoPanel.getItemName();
    }

    public int getCategoryIdFieldValue() {
        return itemInfoPanel.getCategoryId();
    }

    public double getUnitPriceFieldValue() {
        return itemInfoPanel.getUnitPrice();
    }
}
