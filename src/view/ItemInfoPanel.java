package view;

import domain.bean.Item;

import javax.swing.*;
import java.awt.*;

public class ItemInfoPanel extends JPanel {

    private JTextField unitPriceField;
    private JTextField itemNameField;
    private JTextField catIdField;
    private JTextField itemIdField;

    private ItemController controller;

    public ItemInfoPanel(ItemController controller) {
        this.controller = controller;

        JLabel idLabel = new JLabel();
        itemNameField = new JTextField();
        JLabel nameLabel = new JLabel();
        catIdField = new JTextField();
        JLabel catIdLabel = new JLabel();
        unitPriceField = new JTextField();
        JLabel unitPriceLabel = new JLabel();
        itemIdField = new JTextField();
        JLabel infoLabel = new JLabel();

        GridBagConstraints gridBagConstraints;
        setLayout(new GridBagLayout());

        idLabel.setText("domain.bean.Item ID");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(9, 0, 9, 0);
        add(idLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(8, 0, 8, 0);
        add(itemIdField, gridBagConstraints);

        nameLabel.setText("domain.bean.Item Name");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(9, 0, 9, 0);
        add(nameLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(9, 0, 9, 0);
        add(itemNameField, gridBagConstraints);

        catIdLabel.setText("domain.bean.Category ID");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(9, 0, 9, 0);
        add(catIdLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(9, 0, 9, 0);
        add(catIdField, gridBagConstraints);

        unitPriceLabel.setText("Unit Price");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(9, 0, 9, 0);
        add(unitPriceLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(9, 0, 9, 0);
        add(unitPriceField, gridBagConstraints);

        infoLabel.setText("Cette application vous permet de parcourir et modifier les enregistrement de la table Article ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new Insets(69, 0, 30, 0);
        add(infoLabel, gridBagConstraints);
    }

    public void setItemViewValues(Item item) {
        itemNameField.setText(String.valueOf(item.getName()));
        catIdField.setText(String.valueOf(item.getCategoryId()));
        unitPriceField.setText(String.valueOf(item.getUnitPrice()));
        itemIdField.setText(String.valueOf(item.getId()));
    }

    public void resetItemViewValues() {
        itemNameField.setText("");
        catIdField.setText("");
        unitPriceField.setText("");
        itemIdField.setText("");
    }
}
