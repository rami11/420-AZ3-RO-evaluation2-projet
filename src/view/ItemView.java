package view;

import domain.bean.Item;

import javax.swing.*;
import java.awt.*;

public class ItemView extends JFrame {

    private NavigationPanel navigationPanel;
    private CrudPanel crudPanel;
    private ItemInfoPanel itemInfoPanel;

    private ItemController controller;

    /**
     * Creates new form view.ItemView
     */
    public ItemView() {
        this.controller = new ItemController(this);

        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        navigationPanel = new NavigationPanel(controller);
        crudPanel = new CrudPanel(controller);
        itemInfoPanel = new ItemInfoPanel(controller);

        getContentPane().add(navigationPanel, BorderLayout.NORTH);
        getContentPane().add(crudPanel, BorderLayout.SOUTH);
        getContentPane().add(itemInfoPanel, BorderLayout.CENTER);

        controller.showFirstItem();
       /* enablePanelNorth();
        disablePanelSouth();*/

        pack();
    }

    public void setItemViewValues(Item item) {
        itemInfoPanel.setItemViewValues(item);

        System.out.println("Current item: " + controller.getCurrentItem());
    }

    public void resetItemViewValues() {
        itemInfoPanel.resetItemViewValues();
    }
}
